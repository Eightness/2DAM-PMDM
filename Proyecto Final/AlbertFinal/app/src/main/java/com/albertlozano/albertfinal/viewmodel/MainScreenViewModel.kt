/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.albertlozano.albertfinal.database.ProductDatabase
import com.albertlozano.albertfinal.database.dao.ProductDAO
import com.albertlozano.albertfinal.database.entities.Product
import com.albertlozano.albertfinal.model.User
import com.albertlozano.albertfinal.preferences.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * MainScreenViewModel Class
 *
 * @constructor
 * application: Application
 *
 * @param application
 */
class MainScreenViewModel(application: Application) : AndroidViewModel(application) {
    //Attributes
    private val preferences = AppPreferences(application)

    var productList: LiveData<MutableList<Product>> = MutableLiveData()
    private val productDAO: ProductDAO = ProductDatabase.getInstance(application).productDAO()

    private val _userName = MutableLiveData<String>()
    var userName: LiveData<String> = _userName

    private val _selectedProduct = MutableLiveData<Product>()
    var selectedProduct: LiveData<Product> = _selectedProduct

    //Methods
    fun onUserNameChange(userName: String) {
        _userName.value = userName
    }

    fun saveUserName(userName: String) {
        viewModelScope.launch {
            preferences.saveUser(User(userName = userName))
            _userName.postValue("")
        }
    }

    fun loadUser() {
        viewModelScope.launch(Dispatchers.IO) {
            preferences.loadUser().collect { user ->
                _userName.postValue(user.userName)
            }
        }
    }

    fun deleteUserPreferences() {
        viewModelScope.launch(Dispatchers.IO) {
            preferences.deleteUserPreferences()
        }
    }

    suspend fun isDataStored(onCollected: (Boolean) -> Unit) {
        viewModelScope.launch {
            preferences.isDataStored().collect {
                onCollected(it)
            }
        }
    }

    fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            productList = productDAO.getAllProducts()
        }
    }

    fun addProduct(productName: String, supermarket: String, price: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            if (productDAO.productExists(productName) == 0) {
                productDAO.addProduct(Product(name = productName, supermarket = supermarket, price = price))
            }
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productDAO.deleteProduct(product)
        }
    }

    fun onProductClicked(product: Product) {
        _selectedProduct.value = product
    }

    suspend fun loadDefaultProducts() {
        val listOfDefaultProducts = listOf(
            Product(0, "Pan", "Mercadona", 0.48),
            Product(1, "Leche", "Carrefour", 1.20),
            Product(2, "Huevos", "Aldi", 2.00),
            Product(3, "Arroz", "Lidl", 1.50),
            Product(4, "Pasta", "Eroski", 0.75),
            Product(5, "Tomates", "Dia", 0.99),
            Product(6, "Cerveza", "SuperSol", 1.80),
            Product(7, "Queso", "Hipercor", 3.50),
            Product(8, "Manzanas", "Alcampo", 2.50),
            Product(9, "Aceite de oliva", "Caprabo", 4.75) ,
            Product(10, "Chocolate", "Dia", 1.99),
            Product(11, "Tarta", "SuperSol", 1.80),
            Product(12, "Pizza", "Hipercor", 3.50),
            Product(13, "Coca Cola", "Alcampo", 2.50),
            Product(14, "Agua", "Caprabo", 1.75)
        )

        for (series in listOfDefaultProducts) {
            productDAO.addProduct(series)
        }
    }

    fun updateProduct(inputProductName: String, inputSupermarket: String, inputPrice: Double) {
        val selectedProduct = _selectedProduct.value

        if (selectedProduct != null) {
            val updatedProduct = selectedProduct.copy(
                name = inputProductName,
                supermarket = inputSupermarket,
                price = inputPrice
            )

            viewModelScope.launch(Dispatchers.IO) {
                productDAO.updateProduct(updatedProduct)
            }
        }
    }
}