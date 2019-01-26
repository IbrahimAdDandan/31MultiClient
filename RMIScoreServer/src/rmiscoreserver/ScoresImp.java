/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiscoreserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import rmi.ScoresInterface;

/**
 *
 * @author ibrahim
 */
public class ScoresImp extends UnicastRemoteObject implements ScoresInterface {
    
    DBConnector connector;
    
    public ScoresImp() throws RemoteException {
        super();
        this.connector = new DBConnector();
    }

    @Override
    public void scores(int length, int loserIndex) throws RemoteException {
        /**
         * connect to data
         * for every one increments wins and total count, except the loser
         * for the loser increment lose and total count
         */
        try {
            this.connector.connect();
//            this.connector.connectSQLServer();
            this.connector.incLose(loserIndex);
            this.connector.incWin(length, loserIndex);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
