package cloud;

import java.util.HashMap;

import cloud.exceptions.CloudGenericException;
import cloud.util.CloudUtil;

public class VirtualMachine implements Powerable {
	final String id; // Identificador único
	int cpuCount; // Número de CPU
	long memoryGB; // Memoria en GB
	PowerState powerStatus = PowerState.POWERED_OFF; // Estado
	String name; // Nombre
	String guestOS; // Sistema Operativo

	/* 
	 * VirtualMachine[1]:
	 * Variable nics de ser un arreglo de
	 * tipo NetworkCard a un HashMap de tipo 
	 * HashMap<Integer, NetworkCard> 
	 */
	HashMap<Integer, NetworkCard> nics = new HashMap<>(); // Tarjetas de Red Virtuales
	/*
	 * VirtualMachine[10]
	 * Agregar variable hdds de tipo 
	 * HashMap<Integer, HardDiskDrive>
	 */
	HashMap<Integer, HardDiskDrive> hdds = new HashMap<>(); // Discos duros virtuales

	/*
	 * VirtualMachine[6]
	 * Constructor debe validar lo siguiente:
	 * - cpuCount(int) mayor a 0
	 * - memoryGB(long) mayor o 0
	 * - name(String) mayor a 5 caracteres
	 * - guestOS(String) mayor a 5 caracteres
	 */
	VirtualMachine(int cpuCount, long memoryGB, String guestOS) throws CloudGenericException {
		// Escribe tu código
		if (cpuCount <= 0) {
			throw new CloudGenericException("Número de CPUs debe ser mayor a 0.");
		}

		if (memoryGB < 1024) {
			throw new CloudGenericException("Memoria debe ser mayor o igual a 1024");
		} else if (memoryGB % 1024 != 0) {
			throw new CloudGenericException("Memoria debe ser multiplo de 1024");
		}

		if (guestOS.length() < 6) {
			System.err.println("Se recomienda un nombre de sistema operativo mayor a 5 caracteres.");
		}
		this.guestOS = guestOS;

		this.cpuCount = cpuCount;
		this.memoryGB = memoryGB;
		// }
		this.id = CloudUtil.getUUID();
	}

	VirtualMachine(int cpuCount, long memoryGB, String name, String guestOS) throws CloudGenericException {
		// Escribe tu código
		if (cpuCount <= 0) {
			throw new CloudGenericException("Número de CPUs debe ser mayor a 0.");
		}

		if (memoryGB < 1024) {
			throw new CloudGenericException("Memoria debe ser mayor o igual a 1024");
		} else if (memoryGB % 1024 != 0) {
			throw new CloudGenericException("Memoria debe ser mayor o igual a 1024");
		}

		if (guestOS.length() < 6) {
			System.err.println("Se recomienda un nombre de sistema operativo mayor a 5 caracteres.");
		}

		if (name.length() < 6) {
			System.err.println("Se recomienda un nombre mayor a 5 caracteres.");
		}

		this.cpuCount = cpuCount;
		this.memoryGB = memoryGB;
		this.name = name;
		this.guestOS = guestOS;
		// }
		this.id = CloudUtil.getUUID();
	}

	String getID() {
		return this.id;
	}

	int numberOfCPUs() {
		/* Obtener el número de CPUs de la VM */
		return this.cpuCount;
	}

	/**
	 * @return the powerStatus
	 */
	public PowerState getPowerStatus() {
		return powerStatus;
	}

	/**
	 * @param powerStatus the powerStatus to set
	 */
	public void setPowerStatus(PowerState powerStatus) {
		this.powerStatus = powerStatus;
	}

	/* 
	 * VirtualMachine[4]
	 * Complementar Método powerOn: validar si la
	 *  VM está prendida e imprimir mensaje 
	 * informando que el estado es prendido.
	 */
	@Override
	public void powerOn() {
		/* Encender la VM */
		// Escribe tu código {
		if (this.getPowerStatus() == PowerState.POWERED_ON) {
			System.out.println("La maquina esta prendida");
			return;
		}
		this.setPowerStatus(PowerState.POWERED_ON);
		// }
	}

	/* 
	 * VirtualMachine[5]
	 * Método powerOff: validar si la VM está prendida 
	 * e imprimir mensaje informando que el estado es apagado.
	 */
	@Override
	public void powerOff() {
		// Escribe tu código {
		if (this.getPowerStatus() == PowerState.POWERED_OFF) {
			System.out.println("La maquina esta apagada");
			return;
		}
		this.setPowerStatus(PowerState.POWERED_OFF);
		// }
	}

	@Override
	public void suspend() {
		if (this.getPowerStatus() == PowerState.SUSPENDED) {
			System.out.println("La maquina esta suspendida");
			return;
		}
		this.setPowerStatus(PowerState.SUSPENDED);
	}

	void setName(String name) {
		/* Asignar nombre a la VM */
		this.name = name;
	}

	/* 
	 * VirtualMachine[2]
	 * Complementar Método addNIC(NetworkCard nic). 
	 * el id debe ser el valor de unitNumber
	 */
	void addNIC(NetworkCard nic) {
		/* Agregar NIC a la VM */
		// Escribe tu código {
		this.nics.put(nic.unitNumber, nic);
		// }
	}

	/* 
	 * VirtualMachine [3]
	 * Complementar Método addNICs 
	 * (HashMap<Integer, NetworkCard> nics)
	 */
	void addNICs(HashMap<Integer, NetworkCard> nics) {
		/* Inicializar nics con un arrayList*/
		// Escribe tu código {
		this.nics = nics;
		// }
	}

	/*
	 * VirtualMachine 11
	 * Crear Métodos addHDD(HardDiskDrive hdd) y 
	 * addHDDs(HashMap<Integer, HardDiskDrive>) 
	 */
	void addHDD(HardDiskDrive hdd) {
		/* Agregar HDD a la VM */
		// Escribe tu código {
		this.hdds.put(hdd.unitNumber, hdd);
		// }
	}

	void addHDDs(HashMap<Integer, HardDiskDrive> hdds) {
		/* Agregar HDDs a la VM */
		// Escribe tu código {
		this.hdds.putAll(hdds);
		// }
	}

	/*
	 * VirtualMachine[7]
	 * Sobrecargar el método java.lang.Object.toString() para mostrar
	 *  la representación en String de VirtualMachine 
	 *  como lo hacía CloudUtil.printVMInfo() incluyendo:
	 *  - Los objetos NICs
	 *  - Los objetos HDDs
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// Escribe tu código {
		sb.append(String.format("ID: %s", this.getID()));
		sb.append(System.lineSeparator());

		sb.append(String.format("Número de CPUs: %d", this.numberOfCPUs()));
		sb.append(System.lineSeparator());

		sb.append(String.format("Memoria (GB): %d", this.memoryGB));
		sb.append(System.lineSeparator());

		sb.append(String.format("Estado: %s", this.getPowerStatus()));
		sb.append(System.lineSeparator());

		sb.append(String.format("Nombre: %s", this.name));
		sb.append(System.lineSeparator());

		sb.append(String.format("Sistema Operativo: %s", this.guestOS));
		sb.append(System.lineSeparator());

		sb.append(String.format("Tarjetas de Red: %s", (this.nics.isEmpty() ? "No NICs" : "")));
		sb.append(System.lineSeparator());

		// NICs
		for (NetworkCard networkCard : this.nics.values()) {
			String[] lines = networkCard.toString().split(System.getProperty("line.separator"));
			for (int i = 0; i < lines.length; i++) {
				lines[i] = "\t" + lines[i];
			}

			sb.append(String.join(System.lineSeparator(), lines));
			sb.append(System.lineSeparator());
			sb.append(System.lineSeparator());
		}

		sb.append(String.format("Discos duros: %s", (this.hdds.isEmpty() ? "No HDDs" : "")));
		sb.append(System.lineSeparator());

		// HDDs
		for (HardDiskDrive hdd : this.hdds.values()) {
			String[] lines = hdd.toString().split(System.getProperty("line.separator"));
			for (int i = 0; i < lines.length; i++) {
				lines[i] = "\t" + lines[i];
			}

			sb.append(String.join(System.lineSeparator(), lines));
			sb.append(System.lineSeparator());
			sb.append(System.lineSeparator());
		}
		// }

		return sb.toString();
	}
}
