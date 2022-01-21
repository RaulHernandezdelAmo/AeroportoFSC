package aeroporto;

import java.util.Iterator;
import java.util.Random;
import mycollections.LinkedQueue;
import mycollections.Queue;
/**
Classe que simula a gestão de uma pista do aeroporto FSC.
@author
@version
*/
public class AeroportoFSC {
    Queue<Integer> landingPlanes = new LinkedQueue<>();
    Queue<Integer> takingOffPlanes = new LinkedQueue<>();
    
    public AeroportoFSC(){} //end of construtor

    /** Creates an airport with the specified number of flights
    assigned randomly to be either in the air or on the ground.
    @param voos The number of flights in both air and ground combined.
    */
    public AeroportoFSC(int voos){
        for(int i=0; i<voos; i++){
            addRandom();
        }
    } //end of construtor
    
    /** Simulates a randomly flight. */
    public void addRandom(){
        int flightId;
        int landingOrTakingOff;
        Random random = new Random();
        flightId = random.nextInt(900)+100;
        landingOrTakingOff = random.nextInt(2);
        if(landingOrTakingOff == 0){
            landingPlanes.enqueue(flightId);
            System.out.println("Flight " + flightId + " entered the Landing Queue.");
        }else{
            takingOffPlanes.enqueue(flightId);
            System.out.println("Flight " + flightId + " entered the Taking Off Queue.");
        }
    } // end of addRandom
    
    /** Simulates flights on the ground. */
    public void addDescolar(){
        int flightId;
        Random random = new Random();
        flightId = random.nextInt(900)+100;
        takingOffPlanes.enqueue(flightId);
        System.out.println("Flight " + flightId + " entered the Taking off Queue.");
    } // end of addDescolar
    
    /** Simulates flights on the air. */
    public void addAterrar(){
        int flightId;
        Random random = new Random();
        flightId = random.nextInt(900)+100;
        landingPlanes.enqueue(flightId);
        System.out.println("Flight " + flightId + " entered the Landing Queue.");
    } // end of addAterrar
    
    /** Simulates a landing/takeoff cycle. */
    public void aterrarEdescolar(){
        //We don't understund what we have to do in this method. We will follow the approach of creating a full set of planes landing and taking off, 
        //and to make them go through the runway
        for(int i=0; i<15; i++){
            addRandom();
        }
        fechaPista();        
    } // end of aterrarEdescolar
    
    /** Simulates all flights in the air landing on the runway and all planes on the ground taking off, leaving both runway
    empty. */
    public void fechaPista(){
        int flightId;
        Iterator<Integer> it = landingPlanes.iterator();
        while(it.hasNext()){
            flightId = it.next();
            if(landingPlanes.dequeue()==flightId){
                System.out.println("Flight " + flightId + " is Landing");
            }            
        }
        Iterator<Integer> it2 = takingOffPlanes.iterator();
        while(it2.hasNext()){
            flightId = it2.next();
            if(takingOffPlanes.dequeue()==flightId){
                System.out.println("Flight " + flightId + " is Taking off");
            } 
        }
        if(landingPlanes.size()==0 && takingOffPlanes.size()==0){
            System.out.println("No planes need to land or take off");
        }
        
    } // end of fechaPista
} // end of AeroportoFSC