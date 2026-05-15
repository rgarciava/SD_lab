package lab_04;

// Estas son las librerías que te faltaban
import java.rmi.server.UnicastRemoteObject; 
import java.rmi.RemoteException;

public class ConversionImpl extends UnicastRemoteObject implements ConversionInterface {
    
    private static final double TASA_DOLAR = 3.75; // 1 USD = 3.75 PEN
    private static final double TASA_EURO  = 4.10; // 1 EUR = 4.10 PEN

    public ConversionImpl() throws RemoteException { 
        super(); 
    }

    @Override
    public double convertirADolares(double monto) throws RemoteException {
        if (monto < 0) throw new RemoteException("Monto negativo");
        return Math.round((monto / TASA_DOLAR) * 100.0) / 100.0;
    }

    @Override
    public double convertirAEuros(double monto) throws RemoteException {
        if (monto < 0) throw new RemoteException("Monto negativo");
        return Math.round((monto / TASA_EURO) * 100.0) / 100.0;
    }

    // Faltaba implementar estos dos métodos de la interfaz:
    @Override
    public double getTasaDolar() throws RemoteException {
        return TASA_DOLAR;
    }

    @Override
    public double getTasaEuro() throws RemoteException {
        return TASA_EURO;
    }
}