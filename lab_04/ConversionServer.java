package lab_04;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            // 1. Iniciar el registro RMI en el puerto estándar 1099
            LocateRegistry.createRegistry(1099);
            
            // 2. Instanciar el objeto que contiene la lógica (Implementación)
            ConversionImpl servicio = new ConversionImpl();
            
            // 3. Registrar el objeto en el RMI Registry con un nombre lógico
            // Se usa rebind para reemplazar cualquier registro previo con el mismo nombre
            Naming.rebind("rmi://localhost:1099/ConversionService", servicio);
            
            System.out.println("========================================");
            System.out.println("Servidor de Conversión iniciado...");
            System.out.println("Esperando peticiones de clientes...");
            System.out.println("========================================");
            
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}