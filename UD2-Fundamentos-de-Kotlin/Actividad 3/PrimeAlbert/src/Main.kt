/**
 * Prime. Programa que pida números e indique si son primos o no.
 * Tras comprobar un número e programa preguntará al usuario si se quiere comprobar otro o no.
 * Si dice que sí se volverá a repetir todo lo anterior, si dice que no el programa finalizará.
 *
 * @author Albert Lozano Blasco
 * @version 7.8
 */

/**
 * Función main. Código escrito directamente en esta función.
 */
fun main() {
    //Inicializamos variables útiles para el programa.
    var running = true  //booleano que define si el programa sigue ejecutándose o no.

    //Utilizamos un bucle do-while para pedir un número al usuario y preguntar si quiere seguir con el programa o no.
    do {
        //Le pedimos al usuario un número entero.
        print("Introduce un número entero positivo mayor que 1: ")  //Asumimos que el usuario introducirá un valor válido.
        val number = readln().toInt()
        var prime: Boolean   //booleano para detectar si un número introducido es primo o no.

        //Comprobación de número primo:

        //Comprobamos si el número introducido es par. Todos los números primos son impares con excepción del 2.
        if (number % 2 == 0) {
            prime = false
            //Excepción del número 2.
            if (number == 2) {
                prime = true
            }
        } else {
            prime = true
            primeCheck@ for (i in 3..<number step 2) {  //Recorremos a partir del 3 dando saltos de 2. (Sólo comprobamos números impares. El 1 no es primo y el 2 ya lo comprobamos antes).
                if (number % i == 0) {
                    prime = false
                    break@primeCheck
                }
            }
        }

        //Imprimimos el resultado de la comprobación.
        if (prime) println("El número $number es un número primo.") else println("El número $number no es un número primo.")

        //Preguntamos al usuario si quiere seguir con el programa.
        print("¿Quieres continuar con el programa? Introduce 1 (Sí) o 0 (No): ")
        if (readln().toInt() == 0) running = false

    } while (running)
}