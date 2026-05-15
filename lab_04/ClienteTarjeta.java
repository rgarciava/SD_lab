package lab_04;

import java.rmi.Naming;
import java.util.Scanner;

public class ClienteTarjeta {

    public static void main(String[] args) {

        try {

            TarjetaCredito tarjeta =
                    (TarjetaCredito) Naming.lookup("rmi://localhost/Tarjeta");

            Scanner sc = new Scanner(System.in);

            int opcion;

            do {

                System.out.println("\n=== SISTEMA TARJETA ===");
                System.out.println("1. Consultar cliente");
                System.out.println("2. Consultar saldo");
                System.out.println("3. Retirar");
                System.out.println("4. Pagar");
                System.out.println("5. Salir");

                opcion = sc.nextInt();

                switch(opcion) {

                    case 1:
                        System.out.println("Cliente: "
                                + tarjeta.consultarCliente());
                        break;

                    case 2:
                        System.out.println("Saldo: "
                                + tarjeta.consultarSaldo());
                        break;

                    case 3:
                        System.out.print("Monto a retirar: ");
                        double retiro = sc.nextDouble();

                        System.out.println(
                                tarjeta.retirar(retiro));
                        break;

                    case 4:
                        System.out.print("Monto a pagar: ");
                        double pago = sc.nextDouble();

                        System.out.println(
                                tarjeta.pagar(pago));
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;
                }

            } while(opcion != 5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}