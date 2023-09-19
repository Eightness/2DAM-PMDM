/**
 * Circle. El programa pedirá al usuario el radio de un círculo y mostrará por pantalla su perímetro, su área y el volumen de una esfera de ese radio su volumen.
 * @author Albert Lozano Blasco
 * @version 8.1
 */

/**
 * Función main. Código escrito directamente en la función.
 */
fun main() {
    //Pedimos al usuario el radio de un círculo.
    print("Introduce el radio de un círculo: ")
    val radius = readln().toDouble()

    //Realizamos las operaciones para calcular el perímetro, área y volumen de una esfera con el mismo radio.
    val perimeter = 2 * radius * 3.1416
    val area = 3.1416 * radius * radius
    val volume = (4.0 / 3.0) * 3.1416 * (radius * radius * radius)

    //Imprimimos los resultados.
    println("""
        |Perímetro del círculo: $perimeter 
        |Área del círculo: $area 
        |Volumen de una esfera con el mismo radio: $volume 
    """.trimMargin())
}