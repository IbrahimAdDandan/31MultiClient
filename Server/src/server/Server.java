/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.ScoresInterface;

/**
 *
 * @author ibrahim
 */
public class Server {

    public static boolean enabled[][] = new boolean[4][6];
    public static int total = 0;
    public static ScoresInterface scores;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 6; j++) {
                    Server.enabled[i][j] = true;
                }
            }
            Registry registery = LocateRegistry.getRegistry("localhost", 9875);
            scores = (ScoresInterface) registery.lookup("//localhost:9876/ScoreService");
            Connection connection = new Connection();
            Thread thread1 = new Thread(connection);
            thread1.start();
        } catch (RemoteException | NotBoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
