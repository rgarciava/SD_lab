package lab_04;

import java.rmi.Naming;
import java.util.Scanner;

public class ConversionClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            // 1. Localizar el objeto remoto en el servidor
            System.out.println("Conectando al servidor...");
            ConversionInterface servicio = (ConversionInterface) Naming.lookup("rmi://localhost:1099/ConversionService");
            
            // 2. Obtener información inicial del servidor (usando los nuevos métodos)
            System.out.println("Conexión exitosa.");
            System.out.println("Tasas actuales del día:");
            System.out.println("Dólar: S/ " + servicio.getTasaDolar());
            System.out.println("Euro:  S/ " + servicio.getTasaEuro());
            System.out.println("----------------------------------------");

            // 3. Interacción con el usuario
            System.out.print("Ingrese el monto en Soles (PEN) a convertir: ");
            double monto = sc.nextDouble();

            System.out.println("\n--- RESULTADOS DE CONVERSIÓN ---");
            
            // Llamadas remotas a los métodos de conversión
            double dolares = servicio.convertirADolares(monto);
            double euros = servicio.convertirAEuros(monto);

            System.out.println("Monto original: S/ " + monto);
            System.out.println("En Dólares (USD): $ " + dolares);
            System.out.println("En Euros (EUR):   € " + euros);
            System.out.println("----------------------------------------");

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}