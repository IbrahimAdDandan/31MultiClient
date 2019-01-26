/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author ibrahim
 */
public class Connection implements Runnable {

    public static Vector<ConnectedClient> clients = new Vector<>();
    public static int clientsNum = 0;
    private static ServerSocket server;
    private static final int PORT = 9876;
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    @Override
    public void run() {
        try {
            server = new ServerSocket(PORT);
            while (true) {
                socket = server.accept();
                ois = new ObjectInputStream(socket.getInputStream());
                oos = new ObjectOutputStream(socket.getOutputStream());
                clientsNum++;
                System.out.println("A new client was been added... " + clientsNum);
                ConnectedClient connectedClient = new ConnectedClient(clientsNum, socket, ois, oos);
                clients.add(connectedClient);
                connectedClient.oos.writeObject(Server.enabled);
                if (clients.size() == 2) {
                    StartPlaying startPlaying = new StartPlaying();
                    Thread thread = new Thread(startPlaying);
                    thread.start();
                }
            }

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void broadcasting(int total, int[] button) throws IOException {
        for (ConnectedClient client : clients) {
            client.oos.writeObject(total);
            client.oos.writeObject(button);
        }

    }

    public static void multiCastWinExclude(int clientID) throws IOException {
        for (ConnectedClient client : clients) {
            if (client.getClientID() == clientID) {
                continue;
            }
            client.oos.writeObject(10000);
        }
    }

}
