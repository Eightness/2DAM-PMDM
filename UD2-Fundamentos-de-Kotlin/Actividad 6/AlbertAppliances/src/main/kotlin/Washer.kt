/**
 * Implementación de la clase Washer.
 *
 * @author Albert Lozano Blasco
 * @version 5.2
 *
 */

/**
 * Clase Washer.
 * Subclase de Appliance que representa una lavadora con características específicas.
 *
 * @property charge La capacidad de carga de la lavadora.
 *
 * @constructor Crea una lavadora con todos los atributos.
 */
class Washer(
    brand: String,
    model: String,
    basePrice: Double,
    color: String,
    energyConsumption: Char,
    val charge: Double
) : Appliance(brand, model, basePrice, color, energyConsumption) {

    /**
     * Función toString. Sobreescrita.
     * Devuelve una representación en forma de cadena que muestra toda la información de la lavadora, incluyendo su precio final.
     *
     * @return Cadena que describe la lavadora, incluyendo su marca, modelo, precio base, color, consumo de energía y carga.
     */
    override fun toString(): String {
        return  """
                |
                | Marca: $brand
                | Modelo: $model
                | Precio base: $basePrice €
                | Color: $color
                | Consumo de energía: $energyConsumption
                | Carga: $charge kg
                | Precio final: ${finalPrice()} €
                | 
                """.trimMargin("|")
    }
}
