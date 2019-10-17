package cloud;

import cloud.exceptions.CloudGenericException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] memories = new int[] { 0, 1024, 2048, 4096, 5000 };
        int[] cpus = new int[] { 2, 1, 0, 2, 1 };
        int[] disks = new int[] { 10, 0, 40, 10, 80 };
        String[] os = new String[] { "Ubuntu", "CentOS", "Windows", "OSX", "Suse" };

        HashMap<Integer, CloudGenericException> exceptions = new HashMap<>();
        IntStream.range(0, 5).forEach((n) -> {
            try {
                createVM(memories[n], cpus[n], disks[n], n, os[n]);
            } catch (CloudGenericException e) {
                exceptions.put(n, e);
            }
        });

        System.out.println("Errores:");
        for (Map.Entry<Integer, CloudGenericException> entry : exceptions.entrySet()) {
            System.err.println(String.format("VM%d: %s: %s", entry.getKey(), entry.getValue().getClass(),
                    entry.getValue().getMessage()));
        }
    }

    static void createVM(int memoria, int cpu, int diskCapacity, int suffix, String os) throws CloudGenericException {
        VirtualMachine vm = new VirtualMachine(cpu, (long) memoria, String.format("VirtualMachine%s", suffix), os);
        NetworkCard nic1 = new NetworkCard("128.100.100.100", 1, 1000);
        NetworkCard nic2 = new NetworkCard("128.100.100.100", 2, 2000);
        HardDiskDrive hdd1 = new HardDiskDrive((long) diskCapacity, 1);
        HardDiskDrive hdd2 = new HardDiskDrive((long) diskCapacity, 2);
        vm.addNIC(nic1);
        vm.addNIC(nic2);
        vm.addHDD(hdd1);
        vm.addHDD(hdd2);
        System.out.println(vm.toString());
    }
}