package lab_04;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorTarjeta {

    public static void main(String[] args) {

        try {

            LocateRegistry.createRegistry(1099);

            TarjetaCreditoImpl obj =
                    new TarjetaCreditoImpl("Ronald Garcia", 5000);

            Naming.rebind("rmi://localhost/Tarjeta", obj);

            System.out.println("Servidor RMI Tarjeta iniciado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}