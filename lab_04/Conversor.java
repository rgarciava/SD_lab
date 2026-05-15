package lab_04;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Conversor extends Remote {

    public double convertirADolares(double monto)
            throws RemoteException;

    public double convertirAEuros(double monto)
            throws RemoteException;
}