package lab_04;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class TarjetaCreditoImpl extends UnicastRemoteObject implements TarjetaCredito {

    private String cliente;
    private double saldo;

    public TarjetaCreditoImpl(String cliente, double saldo) throws RemoteException {
        super();
        this.cliente = cliente;
        this.saldo = saldo;
    }

    @Override
    public String consultarCliente() throws RemoteException {
        return cliente;
    }

    @Override
    public double consultarSaldo() throws RemoteException {
        return saldo;
    }

    @Override
    public String retirar(double monto) throws RemoteException {

        if (monto <= saldo) {
            saldo -= monto;
            return "Retiro realizado. Nuevo saldo: " + saldo;
        } else {
            return "Saldo insuficiente";
        }
    }

    @Override
    public String pagar(double monto) throws RemoteException {
        saldo += monto;
        return "Pago realizado. Nuevo saldo: " + saldo;
    }
}