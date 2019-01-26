/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiscoreserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.ScoresInterface;

/**
 *
 * @author ibrahim
 */
public class RMIScoreServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Registry registry = LocateRegistry.createRegistry(9875);
            ScoresInterface score = new ScoresImp();
            registry.rebind("//localhost:9876/ScoreService", score);
            ScoreServerUI.main(args);
        } catch (RemoteException ex) {
            System.err.println(ex.getMessage());
        }
//        DBConnector connector = new DBConnector();
//        try {
//            connector.connect();
//            connector.connectSQLServer();
//            connector.initDB();
//            connector.addData();
//            connector.incLose(1);
//            connector.incWin(4, 2);
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }

    }

}
