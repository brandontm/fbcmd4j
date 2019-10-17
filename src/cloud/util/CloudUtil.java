package cloud.util;

import java.util.Random;
import java.util.UUID;

public class CloudUtil {
    static int macElements = 6;

    public static String getUUID(){
		return UUID.randomUUID().toString();
	}

	public static String getMACAddress(){
		/* Método para generar MAC addresses
		 * aleatorias con fines educativos
		 * Basado en método por Phate en 
		 * Stack Overflow
		 * */
	    Random random = new Random();
	    byte[] macAddress = new byte[macElements];

	    // Generar bytes aleatorios
	    random.nextBytes(macAddress);
	    
	    // Crear un StringBuilder de 18 elementos
	    // 64-D9-2C-A1-BD-B5
	    StringBuilder mac = new StringBuilder(18);

	    // Generar MAC Address basado en la generación
	    // aleatoria
    	int i = 0;
	    for(byte b : macAddress){
	    	mac.append(String.format("%02x%s", b, (mac.length() >= 0 && i < macElements -1 ? ":" : "")));
	    	i++;
	    }

	    // Regresar la dirección MAC en mayúsculas
	    return mac.toString().toUpperCase();
	}
}
