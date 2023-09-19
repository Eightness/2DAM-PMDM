/**
 * Validating. El programa debe pedir al usuario los siguientes datos indicando al usuario si son datos correctos validándolos con expresiones regulares.
 * @author Albert Lozano Blasco
 * @version 7.7
 */

/**
 * Función main. Código escrito directamente en esta función.
 */
fun main() {
    //Creamos los Regex para poder validar los datos que introduzca el usuario.
    val checkName = Regex("^[a-zA-Z-' ]{3,50}\\\$")
    val checkEmail = Regex("^[A-Za-z0-9+_.-]+@(.+)\\\$")
    val checkDNI = Regex("^[0-9]{7,8}[A-Z]\\\$")
    val checkAge = Regex("^[0-9]{1,3}\\\$")
    val checkPhone = Regex("^[6-7-9][0-9]{8}\\\$")

    //Pedimos al usuario los datos y comprobamos las Regex.
    print("Introduce tu nombre completo: ")
    val name = if (readln().matches(checkName)) readln() else "Nombre inválido"
    print("Introduce tu email: ")
    val email = if (readln().matches(checkEmail)) readln() else "Email inválido"
    print("Introduce tu DNI: ")
    val dni = if (readln().matches(checkDNI)) readln() else "DNI inválido"
    print("Introduce tu edad: ")
    val age = if (readln().matches(checkAge)) readln() else "Edad inválida"
    print("Introduce tu teléfono: ")
    val phone = if (readln().matches(checkPhone)) readln() else "Teléfono inválido"

    //Imprimimos los datos del usuario.
    println("""
        |Nombre completo: $name
        |Correo electrónico: $email
        |DNI: $dni
        |Edad: $age
        |Teléfono: $phone
    """.trimMargin())
}