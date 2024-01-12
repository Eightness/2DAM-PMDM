package com.albertlozano.albertfinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertlozano.albertfinal.model.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    //Product list
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    //Selected product
    private val _selectedProduct = MutableLiveData<Product>()
    val selectedProduct: LiveData<Product> = _selectedProduct

    //Variable that indicates that we are obtaining data from repository
    private var _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading

    //When instantiating an object ProductViewModel and calling the constructor, this block will execute:
    init {
        //Coroutine: coroutineScope
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            _products.value = Product.getData()
            _isLoading.value = false
        }
    }

    //Methods

    fun deleteProduct(product: Product) {
        _products.value = _products.value?.filter { it != product }
    }

    fun onProductClicked(product: Product) {
        _selectedProduct.value = product
    }

    fun onFavoriteButtonClicked() {
        val auxProduct = _selectedProduct.value?.copy()
        auxProduct?.favorite = !auxProduct?.favorite!!
        _selectedProduct.value = auxProduct

        val auxList = mutableListOf<Product>()
        _products.value?.map { product ->
            if (auxProduct.name == product.name) {
                product.favorite = !product.favorite
            }
            auxList.add(product)
        }
        _products.value = auxList
    }
}