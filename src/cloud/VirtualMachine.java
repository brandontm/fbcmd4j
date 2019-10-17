package cloud;

import cloud.util.CloudUtil;

public class VirtualMachine {
	final String id; // Identificador único
	int cpuCount; // Número de CPU
	long memoryGB; // Memoria en GB
	boolean powerStatus; // Estado
	String name; // Nombre
	String guestOS; // Sistema Operativo
	NetworkCard[] nics; // Tarjetas de Red Virtuales

	VirtualMachine(int cpuCount, long memoryGB, String name, String guestOS) {
		this.id = CloudUtil.getUUID();
		this.cpuCount = cpuCount;
		this.memoryGB = memoryGB;
		this.name = name;
		this.guestOS = guestOS;
	}

	String getID() {
		return this.id;
	}

	boolean isPoweredOn() {
		/* Validar si la VM está prendida */
		return (this.powerStatus ? true : false);
	}

	int numberOfCPUs() {
		/* Obtener el número de CPUs de la VM */
		return this.cpuCount;
	}

	void powerOn() {
		/* Encender la VM */
		this.powerStatus = true;
	}

	void powerOff() {
		/* Apagar la VM */
		this.powerStatus = false;
	}

	void setName(String name) {
		/* Asignar nombre a la VM */
		this.name = name;
	}

	void addNICs(NetworkCard... nics) {
		/* Asignar NICs a la VM */
		this.nics = nics;
	}

	boolean hasNICs() {
		return (this.nics != null && this.nics.length > 0);
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(String.format("ID: %s", this.getID()));
		strBuilder.append(System.lineSeparator());

		strBuilder.append(String.format("Número de CPUs: %d", this.numberOfCPUs()));
		strBuilder.append(System.lineSeparator());

		strBuilder.append(String.format("Memoria (GB): %d", this.memoryGB));
		strBuilder.append(System.lineSeparator());

		strBuilder.append(String.format("Estado: %s", (this.isPoweredOn() ? "Encendido" : "Apagado")));
		strBuilder.append(System.lineSeparator());

		strBuilder.append(String.format("Nombre: %s", this.name));
		strBuilder.append(System.lineSeparator());

		strBuilder.append(String.format("Sistema Operativo: %s", this.guestOS));
		strBuilder.append(System.lineSeparator());

		strBuilder.append(String.format("Tarjetas de Red: %s", (this.hasNICs() ? "" : "No NICs")));
		strBuilder.append(System.lineSeparator());

		// NICs
		for (NetworkCard networkCard : nics) {
			String[] lines = networkCard.toString().split(System.getProperty("line.separator"));
			for (int i = 0; i < lines.length; i++) {
				lines[i] = "\t" + lines[i];
			}

			strBuilder.append(String.join(System.lineSeparator(), lines));
			strBuilder.append(System.lineSeparator());
			strBuilder.append(System.lineSeparator());
		}

		return strBuilder.toString();
	}
}
