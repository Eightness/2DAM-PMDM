import kotlin.math.pow
import kotlin.system.exitProcess

/**
 * Modular. Este programa realizará las siguientes acciones en este orden:
 * - Pedirá al usuario su nombre que no podrá contener números y tendrá que empezar por mayúscula.
 * - Mostrará el saludo.
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

//Primero implementaremos las funciones para detectar, devolver y validar la entrada del usuario:

/**
 * Función getName.
 * Pedirá una cadena de texto al usuario hasta que sea válida (usando Regex).
 * @param message Le pasaremos como parámetro el mensaje que queramos transmitirle al usuario.
 * @return Devuelve el nombre validado que haya introducido el usuario.
 */
fun getName(message: String): String {
    val validateName = Regex("^[A-Z][a-z']*\\s?([A-Z][a-z']*)?\$") //Expresión regular para comprobar que la entrada del usuario sea correcta. (Puede ser un nombre compuesto e incluso un nombre de un sólo carácter en mayúscula).
    var name: String
    //Estructura do-while para pedirle al usuario su nombre hasta que sea válido.
    do {
        print(message)
        name = readln()
        //Condicional para indicar que el formato del nombre es incorrecto.
        if (!validateName.matches(name)) println("Formato de nombre incorrecto, por favor, prueba otra vez.")
    } while (!validateName.matches(name))

    return name
}

/**
 * Función getInt.
 * Pedirá un número entero al usuario hasta que sea válido (usando Regex).
 * @param message Le pasaremos como parámetro el mensaje que queramos transmitirle al usuario.
 * @return Devuelve el número entero validado que haya introducido el usuario.
 */
fun getInt(message: String): Int {
    val validateInt = Regex("^-?\\d+\$")   //Expresión regular para comprobar que la entrada del usuario sea correcta.
    var number: String
    //Estructura do-while para pedirle al usuario un número entero hasta que sea válido.
    do {
        print(message)
        number = readln()
        //Condicional para indicar que el número no es entero.
        if (!validateInt.matches(number)) println("No se ha introducido un número entero, por favor, prueba otra vez.")
    } while (!validateInt.matches(number))

    return number.toInt()
}

/**
 * Función getDouble.
 * Pedirá un número al usuario hasta que sea válido (usando Regex).
 * @param message Le pasaremos como parámetro el mensaje que queramos transmitirle al usuario.
 * @return Devuelve el número validado que haya introducido el usuario.
 */
fun getDouble(message: String): Double {
    val validateDouble = Regex("^-?\\d+(\\.\\d+)?$")    //Expresión regular para comprobar que la entrada del usuario sea correcta.
    var number: String
    //Estructura do-while para pedirle al usuario un número cualquiera hasta que sea válido.
    do {
        print(message)
        number = readln()
        //Condicional para indicar que no se ha introducido un número.
        if (!validateDouble.matches(number)) println("No se ha introducido un número, por favor, prueba otra vez.")
    } while (!validateDouble.matches(number))

    return number.toDouble()
}

//Procedemos a implementar las diferentes funciones del programa:

/**
 * Función greeting.
 * Saludará al usuario con nombre "name", que se le pasa como parámetro a la función.
 * @param name Le pasaremos como parámetro el nombre del usuario (El valor que devuelve la función getName).
 */
fun greeting(name: String) {
    println("¡Hola, bienvenido a este programa modular, $name!")
}

/**
 * Función menu.
 * Muestra el menú, pide una opción al usuario hasta que sea válida.
 * @return Devuelve la opción que haya elegido el usuario (Valor que devuelve la función getInt).
 */
fun menu(): Int {
    println("""
            
            |1. Suma.
            |2. Resta.
            |3. Multiplicar.
            |4. Dividir.
            |5. Potencia.
            |0. Salir.
            
            """.trimMargin("|"))

    return getInt("Elige una opción: ")
}

/**
 * Función operations.
 * Menú interno, se encargará de asignar qué operación ha elegido el usuario.
 * @param option Le pasaremos como parámetro la opción que haya elegido el usuario (El valor que devuelve la función menu).
 */
fun operations(option: Int) {
    when(option) {
        1 -> calculator("+")
        2 -> calculator("-")
        3 -> calculator("*")
        4 -> calculator("/")
        5 -> calculator("^")
        0 -> {
            println("Gracias por utilizar el programa, adiós.")
            exitProcess(0)
        }
        else -> println("Opción inválida.")
    }
}

//Procedemos a implementar la función que resolverá las diferentes operaciones del menú:

/**
 * Función calculator.
 * Se encarga de realizar y mostar el resultado de las diferentes operaciones del menú.
 * @param operation Le pasaremos como parámetro el símbolo de la operación que deseamos realizar.
 */
fun calculator(operation: String) {
    //Obtenemos dos valores Double.
    val number1 = getDouble("Introduce un número: ")
    val number2 = getDouble("Introduce otro número: ")
    //Asignamos a la variable result un valor dependiendo de la operación, usando el when.
    //La declaramos como Any porque si se divide entre 0, el valor será una String y no un Double. Así, según el caso, podrá ser de un tipo u otro.
    val result: Any = when(operation) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> if (number2 == 0.0) "No se puede dividir por 0." else number1 / number2
        "^" -> number1.pow(number2)
        else -> println("Opción inválida.")
    }
    //Mostramos el resultado por pantalla, usando las variables y el propio parámetro de la función.
    println("El resultado de $number1 $operation $number2 es: $result")
}

//Procedemos con la función main, que se encargará de ejecutar todo.

/**
 * Función main. Código que se ejecuta.
 */
fun main() {
    //Llamamos a la función de saludar y le pasamos como parámetro la función de obtener un nombre válido por Regex (a la cual le pasamos un mensaje como parámetro para el usuario).
    greeting(getName("Introduce tu nombre (Empieza por mayúscula, no contiene números y puede ser compuesto): "))
    //Estructura while infinita.
    while(true) {
        //Llamamos a la función de las operaciones. Como parámetro le pasamos la función que muestra el menú y devuelve la opción que haya elegido el usuario. Si elige 0, el programa termina directamente.
        operations(menu())
    }
}
