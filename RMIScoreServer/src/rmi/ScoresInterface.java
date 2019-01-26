/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ibrahim
 */
public interface ScoresInterface extends Remote {
    
    public void scores(int length, int loserIndex) throws RemoteException;
}
