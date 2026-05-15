package lab_04;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ConversorImpl extends UnicastRemoteObject
        implements Conversor {

    private final double tasaDolar = 3.70;
    private final double tasaEuro = 4.10;

    public ConversorImpl() throws RemoteException {
        super();
    }

    @Override
    public double convertirADolares(double monto)
            throws RemoteException {

        return monto / tasaDolar;
    }

    @Override
    public double convertirAEuros(double monto)
            throws RemoteException {

        return monto / tasaEuro;
    }
}