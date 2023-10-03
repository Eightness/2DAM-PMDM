/**
 * Modular. Este programa realizará las siguientes acciones en este orden:
 * - Pedirá al usuario su nombre que no podrá contener números y tendrá que empezar por mayúscula.
 * - Mostrará el resultado.
 * - Pedirá dos números.
 * - Realizará la operación correspondiente a la opción introducida mediante la función adecuada.
 * - El programa no acabará hasta que la opción introducida sea cero.
 *
 * Tendrá las siguientes funciones:
 * 1. Mostrará un saludo por pantalla con el nombre del usuario.
 * 2. Mostrará un menú por pantalla con las siguientes opciones y pedirá una opción al ususario. El menú se repetirá hasta que la opción introducida sea válida.
 * 3. Una función para cada operación que recibirá dos valores y mostrará por pantalla la operación indicada.
 *
 * @author Albert Lozano Blasco
 * @version 5.4
 *
 */


/**
 * Función saludo.
 * Saludará al usuario con nombre "name", que se le pasa como parámetro a la función.
 */
fun greeting(name: String) {

}

/**
 * Función del menú.
 * Muestra el menú, pide una opción al usuario hasta que sea válida.
 */
fun menu() {
    println("""
            |1. Suma.
            |2. Resta.
            |3. Multiplicar.
            |4. Dividir.
            |5. Potencia.
            |0. Salir.
            """.trimIndent())
}

/**
 * Función main. Código que se ejecuta.
 */
fun main() {

}