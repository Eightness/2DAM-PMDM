/**
 * Validating. El programa debe pedir al usuario los siguientes datos indicando al usuario si son datos correctos validándolos con expresiones regulares. Nombre completo, correo electrónico, DNI, edad y teléfono.
 * @author Albert Lozano Blasco
 * @version 7.7
 */

/**
 * Función main. Código escrito directamente en esta función.
 */
fun main() {
    //Creamos los Regex para poder validar los datos que introduzca el usuario.
    val checkName = Regex("^[a-zA-Z-' ]{3,50}$")
    val checkEmail = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z]+\\.[A-Za-z]{2,3}$")
    val checkDNI = Regex("^[0-9]{7,8}[A-Z]$")
    val checkAge = Regex("^[0-9]{1,3}$")
    val checkPhone = Regex("^[6-7-9][0-9]{8}$")

    //Pedimos al usuario los datos y los almacenamos en variables.
    print("Introduce tu nombre completo: ")
    var name = readln()
    print("Introduce tu email: ")
    var email = readln()
    print("Introduce tu DNI: ")
    var dni = readln()
    print("Introduce tu edad: ")
    var age = readln()
    print("Introduce tu teléfono: ")
    var phone = readln()

    //Comprobamos que los datos sigan el patrón de las Regex.
    if (!checkName.matches(name)) name = "Nombre inválido"
    if (!checkEmail.matches(email)) email = "Correo inválido"
    if (!checkDNI.matches(dni)) dni = "DNI inválido"
    if (!checkAge.matches(age)) age = "Edad inválida"
    if (!checkPhone.matches(phone)) phone = "Teléfono inválido"

    //Imprimimos los datos del usuario.
    println("""
        |Nombre completo: $name
        |Correo electrónico: $email
        |DNI: $dni
        |Edad: $age
        |Teléfono: $phone
    """.trimMargin())
}