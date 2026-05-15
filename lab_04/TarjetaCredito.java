package lab_04;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TarjetaCredito extends Remote {

    public String consultarCliente() throws RemoteException;

    public double consultarSaldo() throws RemoteException;

    public String retirar(double monto) throws RemoteException;

    public String pagar(double monto) throws RemoteException;
}