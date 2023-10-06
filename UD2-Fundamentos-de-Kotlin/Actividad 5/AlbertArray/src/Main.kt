import kotlin.math.absoluteValue

/**
 * Array. Pide números al usuario y los almacena en una colección.
 * El programa debe dejar de pedir números cuando el valor introducido sea "fin".
 * El programa dirá cuántos números hay de una cifra, cuántos hay de dos, cuántos hay de más de dos cifras y cuántos son pares.
 *
 * A continuación, el programa preguntará si se desean introducir más números o se desea acabar el programa.
 * Si se elige la opción de introducir más números preguntará si quiere continuar con los números introducidos anteriormente o quiere comencar de nuevo.
 * Después, realizará las mismas comprobaciones mencionadas anteriormente.
 *
 * Si se elige acabar el programa se mostrará una despedida y finalizará el programa.
 * Cada vez que se muestra la cantidad de números de cada cifra se preguntará si se quiere introducir más números o se quiere acabar el programa.
 *
 * @author Albert Lozano Blasco
 * @version 2.4
 *
 */

/**
 * Función main. Ejecuta el programa.
 */
fun main() {
    //Declaramos e inicializamos variables útiles para el programa.
    var currentNumbers = mutableListOf<Int>()
    //var numbers = currentNumbers
    var continueProgram = true

    //Estructura do-while principal del programa.
    do {
        //Llamamos a la función fillArray para rellenar el array con la entrada del usuario.
        currentNumbers = fillArray(currentNumbers)
        //Mostramos las estadísticas del array con la función showStatistics.
        showStatistics(currentNumbers)

        //Estrcutura do-while para manejar la entrada del usuario.
        do {
            //Le pedimos al usuario que elija.
            print("¿Deseas introducir más números o finalizar el programa? (Escribe 'introducir' o 'fin'): ")
            val decision = readln()

            //Manejamos las posibles opciones.
            when (decision) {
                "fin" -> {
                    continueProgram = false
                    println("Muchas gracias por utilizar el programa, ¡hasta luego!")
                }
                "introducir" -> {
                    print("¿Quieres continuar con los números anteriores o empezar de nuevo? (Escribe 'reset' para empezar de nuevo o cualquier otra cosa para continuar): ")
                    val option = readln()
                    if (option == "reset") currentNumbers.clear()
                }
                else -> println("Opción introducida inválida.")
            }

        } while (decision != "fin" && decision != "introducir")

        //Asignamos los números actuales a la lista principal.
//        currentNumbers.clear()
//        currentNumbers.addAll(currentNumbers)

    } while (continueProgram)
}

/**
 * Función showStatistics. Muestra las estadísticas de los números.
 * @param numbers Le pasamos como parámetro el array de enteros que ha introducido el usuario.
 */
fun showStatistics(numbers: List<Int>) {
    println("""
            |Números de una cifra: ${numbers.filter { it.absoluteValue in 0..9 }.size}
            |Números de dos cifras: ${numbers.filter { it.absoluteValue in 10..99 }.size}
            |Números con más de dos cifras: ${numbers.filter { it.absoluteValue > 99 }.size}
            |Números pares: ${numbers.filter {it % 2== 0 }.size}
            """.trimMargin("|"))
}

/**
 * Función fillArray. Se encarga de rellenar un array con la entrada del usuario.
 * @return Devuelve el array rellenado con números enteros.
 */
fun fillArray(numbers: MutableList<Int>): MutableList<Int> {
    //Le pedimos al usuario que introduzca datos.
    println("Introduce números (escribe 'fin' para terminar): ")
    var input = readln()

    //Estructura while para ir pidiendo datos al usuario hasta que introduzca "fin".
    while (input != "fin") {
        try {
            numbers.add(input.toInt())
        } catch (e: Exception) {
            println("Se ha introducido un tipo de dato incorrecto. Por favor, introduce un número o 'fin' para finalizar el programa.")
        }
        input = readln()
    }
    return numbers
}
