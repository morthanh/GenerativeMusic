package generator;


import note.Note;
import buffer.ToneBuffer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import rules.Rules;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mh
 */
public class RandomToneGenerator extends Generator{

    private static final int RANDOM_SEED = (int)(Math.random()*100000);
    
    
    
    private Random rand; 
    
    
    private int sleeptime = 10;
    private static final int minSleepTime = 10;
    

    public RandomToneGenerator(Rules rules, ToneBuffer buffer) {
        super(rules, buffer);
        this.buffer = buffer;
        rand = new Random(RANDOM_SEED);
        System.out.println("Random seed: " + RANDOM_SEED);
    }
    
    
    
    
    private int lowestPitch = 50;
    private int highestPitch = 90;
    private int lowestAttach = 100;
    private int highestAttach = 500;


    
    
    
    
    @Override
    public void run() {
        
        running = true;
        
        outer:
        while(running && !isInterrupted()){
            
            int beat = beat();
            
            //get random pitch
            int pitch = lowestPitch + rand.nextInt(highestPitch - lowestPitch);
            //get random attach
            int attach = lowestAttach + rand.nextInt(highestAttach - lowestAttach);
            
            
            while(!buffer.hasSpace()){
                sleeptime += 5;
                sleep(sleeptime);
                
                //make sure that the thread is not caugth in the loop when 
                //playing music has terminated(and buffer might always be full)
                if (!running){
                    break outer;
                }
                
            }
            if (sleeptime - 10 >= minSleepTime){
                sleeptime -= 10;
            }
            buffer.push(new Note(pitch, attach, beat));
            
            
            System.out.println("Making tone: " + beat + " - sleeptime: "+ sleeptime);
            
            sleep(50);
        }
        
        
    }
    
    
    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            System.out.println("ERROR in RandomToneGenerator: "+ex.getMessage());
            Thread.currentThread().interrupt();
        }
    }
    
}
