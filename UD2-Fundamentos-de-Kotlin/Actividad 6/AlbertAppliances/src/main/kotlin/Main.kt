/**
 * Clase Appliance.
 * Subclase Washer.
 * Subclase Television.
 *
 * Crea una lista de 4 Electrodomésticos.
 * Instancia 2 objetos de la clase Washer y añádelos al array de Electrodomésticos en las posiciones 0 y 3. Usa literales para crear los objetos.
 * Instancia 2 objetos de la clase Television y añádelos al array de Electrodomésticos en las posiciones 1 y 2. Usa literales para crear los objetos.
 * Muestra todos los objetos del array Electrodomésticos mediante el método toString.
 * Indica si cada uno es una Televisión o una Lavadora.
 * Si el electrodoméstico es una Lavadora muestra un texto que indique que está en oferta y tendrá un descuento adicional del 15%.
 *
 * @author Albert Lozano Blasco
 * @version 9.3
 *
 */

/**
 * Función main.
 * Se encarga de ejecutar el programa.
 */
fun main() {
    //Creo una lista de objetos de la clase Appliance.
    val appliances = mutableListOf<Appliance>()

    //Instancio 2 objetos de la clase Washer (De forma literal).
    val washer1 = Washer("Samsung", "WW90TA049TH/EC", 359.0, "blanco", 'A', 9.0)
    val washer2 = Washer("LG", "F4WV3509S3W", 489.0, "blanco", 'B', 9.0)
    //Instancio 2 objetos de la clase Television (De forma literal).
    val tv1 = Television("Sony", "BRAVIA KD55X75WL", 745.0, "negro", 'G', 60.0, true, "Google TV")
    val tv2 = Television("Samsung", "Crystal UHD 2022 50BU8000", 429.0, "plata", 'G', 50.0, false, "Android TV")

    //Los añado al array de electrodomésticos en su orden correspondiente.
    appliances.add(washer1)
    appliances.add(tv1)
    appliances.add(tv2)
    appliances.add(washer2)

    //Bienvenida a la aplicación.
    println("""
            |
            |¡Bienvenid@ a la tienda de electrodomésticos de Albert!
            |Actualmente sólo tenemos 4 productos en venta:
            |
            """.trimMargin("|"))

    //Haciendo uso de las funciones de alcance "let" y "apply" iteramos y realizamos diferentes operaciones.
    appliances.forEach {
        it.let { appliance ->
            val type = if (appliance is Washer) "Lavadora" else if (appliance is Television) "Televisión" else "Electrodoméstico"
            val discount = if (appliance is Washer) "y tiene un descuento adicional del 15%" else ""
            if (appliance is Washer) {
                appliance.apply {
                    appliance.basePrice *= 0.75
                }
            }
            //Imprime la información.
            println("""
                |${appliances.indexOf(appliance)} $type $discount: ${appliance.toString()}
                """.trimMargin("|"))
        }
    }

    //Despedida de la aplicación.
    println("""
            |¡Muchas gracias por visitar la tienda!
            |Esperamos volver a verte :).
            """.trimMargin("|"))
}
