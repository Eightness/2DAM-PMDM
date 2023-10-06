import java.lang.Exception
import kotlin.random.Random
import kotlin.system.exitProcess

/**
 * Matrix5x5. El programa pedirá al usuario un número N entre 3 y 6. Con ese número creará una matriz de NxN.
 * A continuación, mostrará un menú y según la opción elegida realizará la acción indicada.
 * Después de realizar cada acción volverá a mostrar el menú y el programa solo acabará al introducir la opción de salir.
 *
 * Menú:
 *    1.- Rellenar matriz (números aleatorios entre 0 y 9)
 *    2.- Mostrar (muestra la matriz por pantalla)
 *    3.- Buscar número: pedirá un número entre 0 y 9 al usuario e indicará línea por línea si ese número se encuentra en la fila.
 *    4.- Añadir uno: sumará uno a cada elemento de la matriz, si tras sumar uno algún elemento es 10 lo convertirá a 0.
 *    5.- Traspuesta (muestra la traspuesta de la matriz)
 *    0.- Salir
 *
 * Se debe tener en cuenta que si aún no se ha rellenado la matriz las opciones 2 a 5 deben de mostrar un mensaje indicando que la matriz está vacía.
 *
 * Si se introduce una opción no válida en el menú se mostrará un error antes de volver a mostrar el menú.
 *
 * @author Albert Lozano Blasco
 * @version 9.3
 *
 */

/**
 * Función main. Ejecuta el programa.
 */
fun main() {
    println()
    println("¡Bienvenido a la aplicación Matriz 5x5! por Albert Lozano.")
    println()
    val matrix = generateMatrix(getInt("Dime de qué tamaño quieres tu matriz NxN (Valor entre 3 y 6): ", 3, 6))

    while (true)
        options(menu(), matrix)
}

/**
 * Función getInt. Se encargará de recoger cualquier valor entero introducido por el usuario y devolverlo validado.
 * @param message Le pasaremos una String con el mensaje que queramos mostrarle al usuario.
 * @return Devolverá un entero introducido por el usuario validado.
 */
fun getInt(message: String): Int {
    //Estructura while para pedirle al usuario un número entero hasta que lo introduzca correctamente.
    while (true) {
        print(message)
        try {
            return readln().toInt()
        } catch (e: NumberFormatException) {
            print("No se ha introducido un número entero. ")
        }
    }
}

/**
 * Función getInt. (Sobrecarga). Se encargará de recoger cualquier valor entero que esté entre un número x e y.
 * @param message Mensaje para el usuario.
 * @param minNumber Primer número.
 * @param maxNumber Segundo número.
 * @return Devolverá el número entero introducido el usuario validado.
 */
fun getInt(message: String, minNumber: Int, maxNumber: Int): Int {
    //Estructura while para pedirle al usuario un número entero hasta que lo introduzca correctamente.
    while (true) {
        print(message)
        try {
            val number = readln().toInt()
            if (number in minNumber..maxNumber)
                return number
            else throw Exception("El número tiene que estar entre $minNumber y $maxNumber. ")
        } catch (e: NumberFormatException) {
            print("No se ha introducido un número entero. ")
        } catch (e: Exception) {
            print("${e.message}")
        }
    }
}

/**
 * Función generateMatrix. Se encargará de generar una matriz de N x N.
 * @param number Será N.
 */
fun generateMatrix(number: Int): Array<Array<Int>> {
    return Array(number) { Array(number) { 0 } }
}

/**
 * Función menu. Se encargará de mostrar el menú de la aplicación.
 * @return Devolverá la opción elegida por el usuario.
 */
fun menu(): Int {
    println("""
            |
            |1.- Rellenar matriz (números aleatorios entre 0 y 9).
            |2.- Mostrar matriz.
            |3.- Buscar número.
            |4.- Añadir uno. (Si la suma es 10, se convertirá a 0).
            |5.- Traspuesta.
            |0.- Salir.
            |
            """.trimMargin("|"))
    return getInt("Elige una opción: ")
}

/**
 * Función options. Se encargará de manejar la estructura "when" para operar según la opción elegida por el usuario.
 * @param option Se le pasará como parámetro la opción elegida por el usuario.
 */
fun options(option: Int, matrix: Array<Array<Int>>) {
    when(option) {
        1 -> fillMatrixRandom0To9(matrix, 0, 9)
        2 -> showMatrix(matrix)
        3 -> searchNumberInMatrix(matrix, getInt("¿Qué número quieres buscar? "))
        4 -> addOneToEachPos(matrix)
        5 -> transposeMatrix(matrix)
        0 -> {
            println("¡Muchas gracias por usar mi aplicación, hasta luego!")
            exitProcess(0)
        }
        else -> println("Opción introducida inválida. Algo salió mal.")
    }
}

/**
 * Función fillMatrix. Se encargará de rellenar la matriz que se le pase como parámetro y la devolverá rellenada.
 * @param matrix Le pasaremos como parámetro una matriz para rellenar.
 * @param minNumber le pasaremos como parámetro un entero mínimo.
 * @param maxNumber le pasaremos como parámetro un entero máximo.
 * @return Devolverá la matriz rellenada.
 */
fun fillMatrixRandom0To9(matrix: Array<Array<Int>>, minNumber: Int, maxNumber: Int): Array<Array<Int>> {
    for ((i, _) in matrix)
        for((j, _) in matrix)
            matrix[i][j] = Random.nextInt(minNumber, maxNumber + 1)

    return matrix
}

/**
 * Función showMatrix. Se encargará de mostrar por pantalla la matriz que se le pase como parámetro.
 * @param matrix Matriz que se le pasará como parámetro para mostrarla.
 */
fun showMatrix(matrix: Array<Array<Int>>) {
    println("Matriz:")
    for ((i, _) in matrix) {
        for((j, _) in matrix)
            print("[${matrix[i][j]}] ")
        println()
    }
}

/**
 * Función searchNumberInMatrix. Se encargará de buscar un entero en una matriz. Mostrará por pantalla las posiciones en las que aparezca.
 * @param matrix Matriz que se le pasará para realizar la búsqueda.
 * @param number Entero que se le pasará para buscarlo.
 */
fun searchNumberInMatrix(matrix: Array<Array<Int>>, number: Int) {
    var found = false

    for ((i, _) in matrix) {
        for((j, _) in matrix)
            if (matrix[i][j] == number) {
                found = true
                println("El número $number se ha encontrado en la posicion [$i][$j] ")
            }
    }

    if (!found) println("No se han encontrado resultados.")
}

/**
 * Función addOneToEachPos. Se encargará de sumar +1 a cada posición de la matriz y la mostrará por pantalla.
 * @param matrix Matriz que se le pasará para operar con ella.
 */
fun addOneToEachPos(matrix: Array<Array<Int>>) {
    for ((i, _) in matrix)
        for ((j, _) in matrix)
            matrix[i][j] += 1

    showMatrix(matrix)
}

/**
 * Función transposeMatrix. Se encargará de realizar la transposición de una matriz y mostrarla por pantalla.
 * @param matrix Matriz que se le pasará para realizar la transposición.
 */
fun transposeMatrix(matrix: Array<Array<Int>>) {
    println("Hello hehe.")
}