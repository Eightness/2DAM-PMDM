/**
 * AcumulatingN. Programa que pida un número al usuario (N), a continuación, pedirá N números y finalmente mostrará la suma de esos N números.
 * Solo debe añadir los números a la suma si son positivos.
 *
 * @author Albert Lozano Blasco
 * @version 2.4
 */

/**
 * Función main. Código escrito directamente en esta función.
 */
fun main() {
    //Inicializamos variables.
    var number: Int
    var sum = 0

    //Le pedimos al usuario un número entero positivo.
    print("Introduce un número positivo entero: ")
    val times = readln().toInt()

    //Preparamos un bucle repeat para pedirle al usuario "times" veces un número.
    repeat (times) {
        //Le pedimos al usuario un número entero.
        print("Introduce un número entero: ")
        number = readln().toInt()

        //Condición para ver si el número introducido es positivo o negativo.
        if (number >= 0) sum += number
    }

    //Mostramos por pantalla el resultado de la suma.
    println("El resultado de la suma es: $sum.")
}