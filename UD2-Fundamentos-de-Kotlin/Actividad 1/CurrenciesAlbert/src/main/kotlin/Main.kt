/**
 * Currencies. El programa debe pedir una cantidad en € al usuario y a continuación mostrará el equivalente en las siguientes divisas: dólares, libras, yenes.
 * @author Albert Lozano Blasco
 * @version 5.6
 */

/**
 * Función main. Código escrito directamente en la función.
 */
fun main() {
    //Pedimos al usuario una cantidad en euros y lo almacenamos en una variable.
    print("Introduce una cantidad en €: ")
    val euros = readln().toDouble()

    //Realizamos las operaciones de conversión y almacenamos el resultado en variables.
    val dollars = euros * 1.07
    val pounds = euros * 0.86
    val yens = euros * 157.49

    //Imprimimos las conversiones realizadas anteriormente.
    println("""
        |Conversión a dólares: $dollars $
        |Conversión a libras: $pounds £
        |Conversión a yenes: $yens ¥
    """.trimMargin())
}