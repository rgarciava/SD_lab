package lab_04;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorConversor {

    public static void main(String[] args) {

        try {

            LocateRegistry.createRegistry(1099);

            ConversorImpl obj = new ConversorImpl();

            Naming.rebind("rmi://localhost/Conversor", obj);

            System.out.println("Servidor Conversor iniciado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}