/**
 * MinorOfZero. Programa que pida 10 números al usuario y finalmente muestre cuántos son mayores que cero.
 * @author Albert Lozano Blasco
 * @version 0.1
 */

/**
 * Función main. Código escrito directamente en esta función.
 */
fun main() {
    //Inicializamos y declaramos variables útiles para el programa.
    var positives = 0

    //Bucle repeat para preguntar 10 números al usuario.
    repeat (10) {
        //Le pedimos al usuario que introduzca un número entero.
        print("Introduce un número entero: ")

        //Si el valor introducido por el usuario es mayor que 0, sumamos +1 a "positives".
        if (readln().toInt() > 0) positives++
    }

    //Mostramos resultado por pantalla.
    println("Cantidad de números mayores que 0 introducidos: $positives")
}
