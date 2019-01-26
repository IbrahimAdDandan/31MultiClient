/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author ibrahim
 */
public class Connection {

    private static InetAddress host;
    private static Socket socket;
    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;
    
    public static void connect() throws UnknownHostException, IOException {
        host = InetAddress.getLocalHost();
        socket = new Socket(host.getHostName(), 9876);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }
}
