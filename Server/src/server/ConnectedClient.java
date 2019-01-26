/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author ibrahim
 */
public class ConnectedClient {
    
    public ObjectInputStream ois;
    public ObjectOutputStream oos;
    private final Socket socket;
    private final int clientID;
    
    public ConnectedClient(int clientID, Socket socket, ObjectInputStream ois, ObjectOutputStream oos) {
        this.clientID = clientID;
        this.socket = socket;
        this.ois = ois;
        this.oos = oos;
    } 
    
    public int getClientID() {
        return this.clientID;
    }
}
