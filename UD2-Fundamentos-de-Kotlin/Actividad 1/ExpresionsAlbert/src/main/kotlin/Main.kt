/**
 * Circle. El programa debe pedir cuatro números decimales al usuario y debe realizar con esos números las siguientes operaciones:
 * Operación 1: a+b-c+d
 * Operación 2: (a*b+c*d)/(a+b+c+d)
 * Operación 3: a*a+b*b-c/d
 * Operación 4: a>b
 * Operación 5: a-b <= c-d
 * Operación 6: a>b o c<d
 * Operación 7: a<b y c<d o a+b>c-d
 * Operación 8: a+d<b*(c-a)
 *
 * @author Albert Lozano Blasco
 * @version 8.1
 */

/**
 * Función main. Código escrito directamente en la función.
 */
fun main() {
    //Pedimos al usuario 4 números decimales.
    print("Introduce un número decimal: ")
    val numberA = readln().toDouble()
    print("Introduce otro número decimal: ")
    val numberB = readln().toDouble()
    print("Introduce otro número decimal: ")
    val numberC = readln().toDouble()
    print("Introduce un último número decimal: ")
    val numberD = readln().toDouble()

    //Realizamos las operaciones y las almacenamos en diferentes variables.
    val operation1 = numberA + numberB - numberC + numberD
    val operation2 = (numberA * numberB + numberC * numberD) / (numberA + numberB + numberC + numberD)
    val operation3 = (numberA * numberA) + (numberB * numberB) - (numberC / numberD)
    val operation4 = numberA > numberB
    val operation5 = numberA - numberB <= numberC - numberD
    val operation6 = numberA > numberB || numberC < numberD
    val operation7 = numberA < numberB && numberC < numberD || numberA + numberB > numberC - numberD
    val operation8 = numberA + numberD < numberB * (numberC - numberA)


    //Imprimimos los resultados.
    println("""
        |Operación 1: $numberA + $numberB - $numberC + $numberD = $operation1
        |Operación 2: ($numberA * $numberB + $numberC * $numberD) / ($numberA + $numberB + $numberC + $numberD) = $operation2
        |Operación 3: ($numberA * $numberA) + ($numberB * $numberB) - ($numberC / $numberD) = $operation3
        |Operación 4: $numberA > $numberB = $operation4
        |Operación 5: $numberA - $numberB <= $numberC - $numberD = $operation5
        |Operación 6: $numberA > $numberB || $numberC < $numberD = $operation6
        |Operación 7: $numberA < $numberB && $numberC < $numberD || $numberA + $numberB > $numberC - $numberD = $operation7
        |Operación 8: $numberA + $numberD < $numberB * ($numberC - $numberA) = $operation8
    """.trimMargin())
}