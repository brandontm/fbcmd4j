package cloud;

import cloud.exceptions.CloudGenericException;
import cloud.util.CloudUtil;

public class HardDiskDrive {
	String id; // Identificador único
	long capacityGB; // Capacidad en GB
	int unitNumber; // Número de unidad
	String label; // Etiqueta

	/* 
	 * HardDiskDrive[1]
	 * Crear constructor y validar lo siguiente:
	 * - capacityGB debe ser mayor a 0 y múltiplo de 40
	 * HardDiskDrive[2]
	 * Reemplazar concatenación de strings 
	 * usando "+" por StringBuilder en Constructores 
	 */
	public HardDiskDrive(long capacityGB, int unitNumber) throws CloudGenericException {
		this.unitNumber = unitNumber;
		// Escribe tu código {
		if (capacityGB <= 0 || capacityGB % 40 != 0) {
			if (capacityGB <= 0)
				throw new CloudGenericException("La capacidad (en GB) debe ser mayor a 0.");

			System.err.println("Se recomienda usar multiplos de 40.");
		}

		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Hard Drive ");
		strBuilder.append(unitNumber);

		this.label = strBuilder.toString();

		this.capacityGB = capacityGB;

		this.id = CloudUtil.getUUID();
		// }
	}

	/*
	 * HardDiskDrive[3]
	 * Sobrecargar el método 
	 * java.lang.Object.toString() para mostrar la 
	 * representación en String de HardDiskDrive
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// Escribe tu código {
		sb.append(String.format("Etiqueta: %s", this.label));
		sb.append(System.lineSeparator());

		sb.append(String.format("Unidad: %d", this.unitNumber));
		sb.append(System.lineSeparator());

		sb.append(String.format("Capacidad (GB): %d", this.capacityGB));
		sb.append(System.lineSeparator());
		// }
		return sb.toString();
	}
}
