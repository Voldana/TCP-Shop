package store.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class TCPServer {

    private static final int PORT = 1974;

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }
    private int count = 0;
    private boolean stopAccepting = false;
    private static TCPClient client[] = new TCPClient[10];
    private String massege;

    public TCPServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (!stopAccepting) {
            Socket socket = serverSocket.accept();
            client[count] = new TCPClient(socket);
            client[count].start();
            count++;
        }
        /*Socket[] connectedSockets = new Socket[10];
        StoreManagement[] management = new StoreManagement[10];
        connectedSockets[0] = serverSocket.accept();
        BufferedReader massege = new BufferedReader(new InputStreamReader(connectedSockets[0].getInputStream()));
        String command = massege.readLine();
        int userCommand = Integer.parseInt(command);*/
    }

    /* public static void sendMassege(int index){
        client[index]
    }*/
    public static void sendMassegeToClient(String massege, int index) throws IOException {
        if (client[index] != null) {
            client[index].reciveMassege(massege);
        }
    }
}
