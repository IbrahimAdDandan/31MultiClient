/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author ibrahim
 */
public class GenerateGrid {

    public int[][] generateGrid() {
        int arr[][] = new int[4][6];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = j+1;
            }
        }
        return arr;
    }
    
    public void initEnabledButton() {
        
    }

//    public int[][] generateGrid() {
//        int arr[][] = new int[4][6];
//        int temp[] = new int[6];
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 6; j++) {
//                int randomNumber = (int) Math.floor(Math.random() * 10 % 6) + 1;
//                while (temp[randomNumber - 1] >= 4) {
//                    randomNumber = (int) Math.floor(Math.random() * 10 % 6) + 1;
//                }
//                temp[randomNumber - 1]++;
//                arr[i][j] = randomNumber;
//            }
//        }
//        return arr;
//    }
}
