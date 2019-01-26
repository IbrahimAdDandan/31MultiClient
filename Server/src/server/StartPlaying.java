/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;

/**
 *
 * @author ibrahim
 */
public class StartPlaying implements Runnable {

//    int total = 0;
    @Override
    public void run() {
        GenerateGrid generateGrid = new GenerateGrid();
        int[][] gameGrid = generateGrid.generateGrid();
//        System.out.println("thread 2 is started");
        ConnectedClient client;
        try {
            for (int i = 0; i < Connection.clients.size(); i++) {
                client = Connection.clients.elementAt(i);
                client.oos.writeObject(10019);
                int[] clientResult = (int[]) client.ois.readObject();
                Server.enabled[clientResult[0]][clientResult[1]] = false;
                int resultVal = gameGrid[clientResult[0]][clientResult[1]];
                System.out.println("client choose: " + resultVal);
                Server.total += resultVal;
                Connection.broadcasting(Server.total, clientResult);
                if (Server.total >= 31) {
                    client.oos.writeObject(-10000);
                    Connection.multiCastWinExclude(client.getClientID());
                    Server.scores.scores(Connection.clients.size(), client.getClientID());
                    Server.total = 0;
                    Connection.clients.removeAllElements();
                    for (int k = 0; k < 4; k++) {
                        for (int j = 0; j < 6; j++) {
                            Server.enabled[k][j] = true;
                        }
                    }
                    Connection.clientsNum = 0;
                    break;
                }
                System.out.println("i:" + i + " and total is: " + Server.total);
                if (i == Connection.clients.size() - 1) {
                    i = -1;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
