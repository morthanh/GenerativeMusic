
package util;

import java.util.Random;

/**
 * 
 */
public class Markov {
    
    
    Random rand = new Random();
    
    private final int numStates;
    private int state = 0;
    
    double[][] table;

    /**
     * Creates an empty(full of zeroes) table for the Markov chain.
     * The state after creation is 0(zero).
     * @param numStates Number of states
     */
    public Markov(int numStates) {
        table = new double[numStates][numStates];
        this.numStates = numStates;
        

    }
    
    /**
     * Sets the values of a specific row/state in the Markov table
     * @param row The row/state
     * @param i integer array with the nye array. Must be same the same length as the number of states.
     */
    public void setRow(int row, double[] i){
        if (i.length != numStates || row >= numStates){
            throw new IllegalStateException();
        }
        double sum = 0;
        for (int k = 0; k < numStates; k++){
            sum += i[k];
            if (sum > 1.1){
                throw new IllegalArgumentException();
            }
            table[row][k] = i[k];
        }
        
    }
    
    /**
     * Gets the current state of the Markov chain
     * @return An integer representing the state
     */
    public int getState(){
        return state;
    }
    
    /**
     * Sets the current state of the Markov chain
     * @param state
     * @return 
     */
    public void setState(int state){
        this.state = state;
    }
    
    /**
     * Gets the new state based on the values in the Markov table
     * @return An integer representing the new state
     */
    public int getNewState(){
        double chance = rand.nextDouble();
        double ret = 0;
        for(int i = 0; i < numStates; i++){
            
            ret += table[state][i];
            if (ret >= chance){
                state = i;
                return state;
            }
        }
        throw new IllegalStateException();
    }
    
    /**
     * Generates random values for all cells in the Markov table
     */
    public void generateRandomTable(){
        for (int i = 0; i < numStates; i++){
            double rowTotal = 0;
            for (int j = 0; j < numStates;j++){
                //hvis sidste i rækken, tag 1-rowtotal
                double r = rand.nextDouble() / numStates;
                table[i][j] = r;
                rowTotal += r;
                
            }
            double rest = 1 - rowTotal;
            double restDiv = rest / numStates;
            for (int j = 0; j < numStates; j++){
                table[i][j] += restDiv;
            }
            
        }
    }
    
    /**
     * Prints the table formated for textual display
     */
    public void printTable(){
        System.out.println("Markov Chain Table");
        for(int i = 0; i < numStates; i++){
            double t = 0;
            for (int j = 0; j < numStates; j++){
                t += table[i][j];
                System.out.format("%7.4f", table[i][j]);
            }
            System.out.println(" - t:" + t);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Test program to run the Markov chain. Generates a table with 5 states
     * and fills them with random values. Then prints the table and prints the 
     * next 100 states in the Markov chain starting at state 0. 
     * @param args 
     */
    public static void main(String[] args) {
        Markov m = new Markov(5);
        m.generateRandomTable();
        m.printTable();
        for (int i = 0; i < 100; i++){
            System.out.println("new state:"+m.getNewState());
        }
    }
    
}
