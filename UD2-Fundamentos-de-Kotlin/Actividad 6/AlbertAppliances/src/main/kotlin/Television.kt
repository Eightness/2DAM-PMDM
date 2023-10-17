/**
 * Implementación de la clase Television.
 *
 * @author Albert Lozano Blasco
 * @version 7.4
 *
 */

/**
 * Clase Television.
 * Subclase de Appliance que representa una televisión con características específicas.
 *
 * @property resolution La resolución de la televisión en pulgadas.
 * @property smartTV Indica si la televisión es un Smart TV (true) o no (false).
 * @property operativeSystem El sistema operativo de la televisión en caso de ser un Smart TV.
 *
 * @constructor Crea una televisión con todos los atributos.
 */
class Television(
    brand: String,
    model: String,
    basePrice: Double,
    color: String,
    energyConsumption: Char,
    val resolution: Double,
    val smartTV: Boolean,
    val operativeSystem: String
) : Appliance(brand, model, basePrice, color, energyConsumption) {

    /**
     * Función finalPrice. Sobreescrita.
     * Calcula el precio final de la televisión, considerando su precio base y un aumento adicional del 23% si la resolución supera las 55 pulgadas.
     *
     * @return El precio final de la televisión.
     */
    override fun finalPrice(): Double {
        val basePrice = super.finalPrice()
        val resolutionSurcharge = if (resolution > 55) basePrice * 0.23 else 0.0
        return basePrice + resolutionSurcharge
    }

    /**
     * Función toString. Sobreescrita.
     * Devuelve una representación en forma de cadena que muestra toda la información de la televisión,
     * incluyendo su precio final.
     *
     * @return Cadena que describe la televisión, incluyendo su marca, modelo, precio final, color, consumo de energía, resolución, si es Smart TV y el sistema operativo (si es aplicable).
     */
    override fun toString(): String {
        return  """
                |
                | Marca: $brand
                | Modelo: $model
                | Precio base: $basePrice €
                | Color: $color
                | Consumo de energía: $energyConsumption
                | Resolución: $resolution pulgadas.
                | SmartTV: $smartTV
                | Sistema Operativo: $operativeSystem
                | Precio final: ${finalPrice()} €
                | 
                """.trimMargin("|")
    }
}
