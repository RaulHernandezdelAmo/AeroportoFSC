/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeroporto;

import aeroporto.AeroportoFSC;
import java.util.Iterator;
import java.util.Random;
import mycollections.LinkedQueue;
import mycollections.Queue;

/**
 *
 * @author Raul
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("-----------------");
        System.out.println("Airport AerOporto");
        System.out.println("-----------------");
        
        
        System.out.println("Creating airport with 10 flights");
        AeroportoFSC airport = new AeroportoFSC(10);
        
        System.out.println();
        
        System.out.println("Initializing landing/takingoffs");
        airport.fechaPista();
        
        System.out.println();
        
        System.out.println("Adding 5 flights to the ground");
        for(int i=0; i<5; i++){
            airport.addDescolar();
        }
        
        System.out.println("");
        
        System.out.println("Adding 3 flights to the air");
        for(int i=0; i<3; i++){
            airport.addAterrar();
        }
        
        System.out.println();
        
        System.out.println("Clearing the Runway");
        airport.fechaPista();
        
        System.out.println();
        
        System.out.println("Done");
    }
}