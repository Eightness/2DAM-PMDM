import java.util.*
/**
 * Implementación de la clase Appliance.
 *
 * @author Albert Lozano Blasco
 * @version 6.0
 *
 */

/**
 * Superclase Appliance.
 *
 * Esta clase representa electrodomésticos con propiedades como marca, modelo, precio base, color y consumo energético.
 *
 * @property brand La marca del electrodoméstico.
 * @property model El modelo del electrodoméstico.
 * @property basePrice El precio base del electrodoméstico en euros.
 * @property color El color del electrodoméstico (blanco, negro, rojo, azul o plata).
 * @property energyConsumption El consumo energético del electrodoméstico (de A a G).
 *
 * @constructor Crea un electrodoméstico con todos los atributos.
 * @constructor Crea un electrodoméstico con modelo y precio.
 * @constructor Crea un electrodoméstico con valores predeterminados.
 */
open class Appliance (
    //Constructor primario con todos los atributos.
    val brand: String,
    val model: String,
    var basePrice: Double = 100.0,
    color: String = "blanco",
    energyConsumption: Char = 'F'
) {
    //Inicializamos las propiedades color y energyConsumption.
    val color: String
    val energyConsumption: Char

    //Bloque inicializador. Se llama al crear una instancia de la clase.
    init {
        this.color = checkColor(color)
        this.energyConsumption = energyConsumptionCheck(energyConsumption)
    }

    //Constructor secundario con modelo y precio.
    constructor(model: String, price: Double) : this("Desconocida", model, price)   //Nota: Se le pasa como parámetro "desconocida" para la marca, puesto que no tiene un valor por defecto.

    //Constructor secundario vacío.
    constructor() : this("Desconocida", "Desconocido")  //Nota: Se le pasan como parámetros "desconocida" y "desconocido" para la marca y el modelo, puesto que no tienen un valor por defecto.

    //Funciones miembro de la clase:

    /**
     * Función checkColor.
     * Se encarga de validar el color que se le pasa como parámetro. Comprobará que sea uno de los colores especificados.
     * Si es alguno, lo devuelve, si no, devuelve "blanco" por defecto.
     *
     * @param color Color que se le pasa a la función para que lo compruebe.
     * @return Devolverá el color si coincide con alguno de los colores válidos o devolverá blanco si no.
     */
    private fun checkColor(color: String): String {
        val validColors = setOf("blanco", "negro", "rojo", "azul", "plata")
        return if (color.lowercase(Locale.getDefault()) in validColors) color.lowercase(Locale.getDefault()) else "blanco"  //"lowercase(Locale.getDefault())" es recomendación del IDE, ya que "toLowerCase()" está deprecated.
    }

    /**
     * Función energyConsumptionCheck.
     * Se encarga de validar la categoría de consumo de energía que se le pasa como parámetro. Comprobará que sea una de las categorías especificadas.
     * Si es alguna, la devuelve, si no, devuelve 'F' por defecto.
     *
     * @param char Letra que se le pasa a la función para que compruebe si es alguna categoría existente.
     * @return Devolverá la letra si coincide con alguna categoría, o 'F' si no coincide con ninguna.
     */
    private fun energyConsumptionCheck(char: Char): Char {
        val validCategories = setOf('A', 'B', 'C', 'D', 'E', 'F', 'G')
        return if (char in validCategories) char else 'F'
    }

    /**
     * Función finalPrice.
     * Se encarga de verificar el aumento de precio por eficiencia y/o por color y devuelve el precio final.
     *
     * @return Devolverá el precio base + el posible aumento de precio debido a la eficiencia energética y/o el color.
     */
    open fun finalPrice(): Double {
        //Tabla de eficiencia.
        val efficiencySurcharge = when (energyConsumption) {
            'A' -> 120.0
            'B' -> 100.0
            'C' -> 80.0
            'D' -> 60.0
            'E' -> 50.0
            'F' -> 30.0
            'G' -> 10.0
            else -> 0.0
        }
        //Tabla de color.
        val colorSurcharge = when (color) {
            "azul", "rojo" -> 40.0
            "plata" -> 70.0
            else -> 0.0
        }

        return basePrice + efficiencySurcharge + colorSurcharge
    }

}