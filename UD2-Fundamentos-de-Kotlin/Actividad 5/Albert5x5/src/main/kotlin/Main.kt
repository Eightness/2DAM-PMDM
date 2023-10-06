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

}

/**
 * Función getInt. Se encargará de recoger cualquier valor entero introducido por el usuario y devolverlo validado.
 * @return Devolverá un entero introducido por el usuario.
 */
fun getInt(): Int {

    return 0
}

/**
 * Función menu. Se encargará de mostrar el menú de la aplicación.
 * @return Devolverá la opción elegida por el usuario.
 */
fun menu(): Int {

    return 0
}

/**
 * Función options. Se encargará de manejar la estructura "when" para operar según la opción elegida por el usuario.
 * @param option Se le pasará como parámetro la opción elegida por el usuario.
 */
fun options(option: Int) {

}

/**
 * Función fillMatrix. Se encargará de rellenar la matriz que se le pase como parámetro y la devolverá rellenada.
 * @param matrix Le pasaremos como parámetro una matriz para rellenar.
 * @param minNumber le pasaremos como parámetro un entero mínimo.
 * @param maxNumber le pasaremos como parámetro un entero máximo.
 * @return Devolverá la matriz rellenada.
 */
fun fillMatrixRandom(matrix: Array<Array<Int>>, minNumber: Int, maxNumber: Int): Array<Array<Int>> {

    return matrix
}

/**
 * Función showMatrix. Se encargará de mostrar por pantalla la matriz que se le pase como parámetro.
 * @param matrix Matriz que se le pasará como parámetro para mostrarla.
 */
fun showMatrix(matrix: Array<Array<Int>>) {

}

/**
 * Función searchNumberInMatrix. Se encargará de buscar un entero en una matriz. Mostrará por pantalla las posiciones en las que aparezca.
 * @param matrix Matriz que se le pasará para realizar la búsqueda.
 * @param number Entero que se le pasará para buscarlo.
 */
fun searchNumberInMatrix(matrix: Array<Array<Int>>, number: Int) {

}

/**
 * Función addOneToEachPos. Se encargará de sumar +1 a cada posición de la matriz y la mostrará por pantalla.
 * @param matrix Matriz que se le pasará para operar con ella.
 */
fun addOneToEachPos(matrix: Array<Array<Int>>) {

}

/**
 * Función transposeMatrix. Se encargará de realizar la transposición de una matriz y mostrarla por pantalla.
 * @param matrix Matriz que se le pasará para realizar la transposición.
 */
fun transposeMatrix(matrix: Array<Array<Int>>) {

}