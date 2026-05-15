package lab_04;

import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface ConversionInterface extends Remote {
	public double convertirADolares(double monto) throws RemoteException;
	public double convertirAEuros(double monto)   throws RemoteException;
	public double getTasaDolar()              	throws RemoteException;
	public double getTasaEuro()               	throws RemoteException;
}
