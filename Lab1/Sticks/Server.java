package Sticks;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    private static final String BINDING_NAME = "RMISTICKS";
    private static final int port = 8080;

    public static void main(String[] args) throws RemoteException {

        final Board serviceClass = new Board();
        final Registry registry = LocateRegistry.createRegistry(port);

        IBoard proxyForServiceClass = (IBoard) UnicastRemoteObject.exportObject(serviceClass, 0);
        registry.rebind(BINDING_NAME, proxyForServiceClass);

    }
}
