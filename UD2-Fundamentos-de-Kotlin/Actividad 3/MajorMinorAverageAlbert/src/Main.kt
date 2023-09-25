/**
 * MajorMinorAverage. Programa que pida números hasta que se introduzca el cero.
 * Cuando se introduzca un cero el programa finalizará, pero antes de finalizar el programa indicará el mayor y el menor de los introducidos y la media de todos los números.
 * @author Albert Lozano Blasco
 * @version 3.3
 */

/**
 * Función main. Código escrito directamente en esta función.
 */
fun main() {
    //Inicializamos y declaramos variables útiles para el programa.
    var number = 0
    var minor = Int.MAX_VALUE
    var major = Int.MIN_VALUE
    var sum = 0
    var index = 0

    //Estructura do-while
    do {
        //Le pedimos al usuario un número entero.
        print("Introduce un número entero (0 para finalizar): ")
        number = readln().toInt()

        //Condición para verificar que el usuario no ha introducido un 0.
        if (number != 0 ) {
            index++         //Sumamos +1 al index para saber cuántos números se han introducido. (Nos servirá para calcular la media).
            sum += number   //Sumamos el número introducido por el usuario.

            //Sobreescribimos las variables "minor" y "major" para actualizarlas, si consta.
            if (number < minor) minor = number else if (number > major) major = number
        }
    } while (number != 0)

    val average: Double = (sum / index).toDouble()

    //Resultado por pantalla.
    println("El número más pequeño introducido es: $minor")
    println("El número más grande introducido es: $major")
    println("La media de los números introducidos es: $average")
}
