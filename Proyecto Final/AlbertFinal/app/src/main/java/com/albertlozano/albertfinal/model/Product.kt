package com.albertlozano.albertfinal.model

data class Product(
    val id: Int = 0,
    val name: String = "",
    val supermarket: String = "",
    val price: Double = 0.0,
    var quantity: Int = 0,
    var favorite: Boolean = false
) {
    companion object {
        fun getData() : List<Product> {
            return listOf(
                Product(0, "Pan", "Mercadona", 0.48, 3, false),
                Product(1, "Leche", "Carrefour", 1.20, 2, false),
                Product(2, "Huevos", "SuperSol", 1.50, 1, false),
                Product(3, "Arroz", "Aldi", 0.80, 4, false),
                Product(4, "Manzanas", "Lidl", 2.00, 5, false),
                Product(5, "Queso", "Eroski", 1.80, 3, false),
                Product(6, "Pasta", "Dia", 0.60, 2, false),
                Product(7, "Tomates", "Alcampo", 1.30, 4, false),
                Product(8, "Papel Higiénico", "Hipercor", 2.50, 1, false),
                Product(9, "Pollo", "Ahorramas", 3.50, 2, false),
                Product(10, "Zanahorias", "Caprabo", 0.90, 3, false),
                Product(11, "Yogur", "Condis", 0.75, 4, false),
                Product(12, "Cerveza", "Froiz", 1.80, 6, false),
                Product(13, "Cereal", "Bonpreu", 2.20, 2, false),
                Product(14, "Aceite de Oliva", "Spar", 3.00, 1, false),
                Product(15, "Papel Aluminio", "Consum", 1.00, 1, false),
                Product(16, "Fresas", "Masymas", 2.50, 5, false),
                Product(17, "Sopa enlatada", "Suma", 1.20, 3, false),
                Product(18, "Galletas", "Mercadona", 1.50, 2, false),
                Product(19, "Salchichas", "Carrefour", 2.80, 4, false)
            )
        }
    }
}
