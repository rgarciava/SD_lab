package lab_04;

import java.rmi.Naming;
import java.util.Scanner;

public class ClienteConversor {

    public static void main(String[] args) {

        try {

            Conversor conversor =
                    (Conversor) Naming.lookup(
                            "rmi://localhost/Conversor");

            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese monto en soles: ");
            double monto = sc.nextDouble();

            System.out.println("\n1. Convertir a dólares");
            System.out.println("2. Convertir a euros");

            int op = sc.nextInt();

            switch(op) {

                case 1:
                    System.out.println(
                            "Dólares: "
                                    + conversor.convertirADolares(monto));
                    break;

                case 2:
                    System.out.println(
                            "Euros: "
                                    + conversor.convertirAEuros(monto));
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
