import java.util.Random;
import mycollections.LinkedQueue;
/**
Classe que simula a gestão de uma pista do aeroporto FSC.
@author
@version
*/
public class AeroportoFSC
{
private ...//here its the DS of flights
(...)
public AeroportoFSC(){} // end of construtor

/** Creates an airport with the specified number of flights
assigned randomly to be either in the air or on the ground.
@param voos The number of flights in both air and ground combined.
*/
public AeroportoFSC(int voos){
(...)
} // end of construtor
/** Simulates a randomly flight. */
public void addRandom(){
(...)
} // end of addRandom
/** Simulates flights on the ground. */
public void addDescolar(){
(...)
} // end of addDescolar
/** Simulates flights on the air. */
public void addAterrar(){
(...)
} // end of addAterrar
/** Simulates a landing/takeoff cycle. */
public void aterrarEdescolar(){
(...)
} // end of aterrarEdescolar
/** Simulates all flights in the air landing on the runway and all planes on the ground taking off, leaving both runway
empty. */
public void fechaPista(){
(...)
} // end of fechaPista
} // end of AeroportoFSC