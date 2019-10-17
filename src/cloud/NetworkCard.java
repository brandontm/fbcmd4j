package cloud;

import cloud.exceptions.CloudGenericException;
import cloud.util.CloudUtil;

public class NetworkCard {
	public static final int MAX_SPEED_MB = 100;
	public final String macAddress;
	public final int unitNumber;
	public final String label;
	public int speedMb = MAX_SPEED_MB;
	public String network;

	/*
	 * NetworkCard[1] Reemplazar concatenación de strings usando "+" por
	 * StringBuilder en Constructores
	 */
	NetworkCard(int unitNumber) throws CloudGenericException {
		if (unitNumber <= 0)
			throw new CloudGenericException("Numero de unidades de tarjetas de red debe ser mayor a 0.");

		this.unitNumber = unitNumber;
		// Escribe tu código {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Network Card ");
		strBuilder.append(unitNumber);

		this.label = strBuilder.toString();
		// }
		this.macAddress = CloudUtil.getMACAddress();
	}

	NetworkCard(String network, int unitNumber) {
		this.network = network;
		this.unitNumber = unitNumber;
		// Escribe tu código {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Network Card ");
		strBuilder.append(unitNumber);

		this.label = strBuilder.toString();
		// }
		this.macAddress = CloudUtil.getMACAddress();
	}

	NetworkCard(String network, int unitNumber, int speedMb) {
		this.network = network;
		this.unitNumber = unitNumber;
		this.speedMb = speedMb;
		// Escribe tu código {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Network Card ");
		strBuilder.append(unitNumber);

		this.label = strBuilder.toString();
		// }
		this.macAddress = CloudUtil.getMACAddress();
	}

	/*
	 * NetworkCard[2] obrecargar el método java.lang.Object.toString() para mostrar
	 * la representación en String de NetworkCard como lo hacía
	 * CloudUtil.printNICInfo() (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// Escribe tu código {
		sb.append(String.format("Mac Adress: %s", this.macAddress));
		sb.append(System.lineSeparator());

		sb.append(String.format("Unit Number: %d", this.unitNumber));
		sb.append(System.lineSeparator());

		sb.append(String.format("Label: %s", this.label));
		sb.append(System.lineSeparator());

		sb.append(String.format("Max Speed (MB): %d", NetworkCard.MAX_SPEED_MB));
		sb.append(System.lineSeparator());

		sb.append(String.format("Network: %s", this.network));
		sb.append(System.lineSeparator());
		// }
		return sb.toString();
	}
}
