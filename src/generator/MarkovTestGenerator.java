/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import buffer.Buffer;
import buffer.ToneBufferExtended;
import java.util.Random;
import rules.Rules;
import rules.Scale;
import note.Note;
import util.Markov;

/**
 *
 * @author mh
 */
public class MarkovTestGenerator extends Generator{

    
    private static final int RANDOM_SEED = (int)(Math.random()*100);
    
    private static final int numStates = 4;
    private static final int pieceSize = 8;
    
    
    private Markov markov;
    private Random rand;
    
    
    private Note[][] toneLists;
    private int[] scale;
    
    
    public MarkovTestGenerator(Rules rules, Buffer buffer) {
        super(rules, buffer);
        markov = new Markov(numStates);
        toneLists = new  Note[numStates][pieceSize];
        buildLists();
    }
    
    
    
    public final void buildLists(){
        System.out.println("Generator: using seed "+ RANDOM_SEED);
        int octave = 3;
        scale = Scale.getScale(Scale.SCALE_MAJOR);
        int bottom = Scale.getNoteIndex(Scale.SCALE_MAJOR,octave , 0);
        int top = Scale.getNoteIndex(Scale.SCALE_MAJOR, octave +2 , 7);
        rand = new Random(RANDOM_SEED);
        
        for(int i = 0; i < numStates; i++){
            for (int j = 0; j < pieceSize; j++){
                int beat = beat();
                int noteIndex = bottom+rand.nextInt(top-bottom+1);
                toneLists[i][j] = new Note(scale[noteIndex], 200, beat);
            }
        }
        
        markov.setRow(0, new double[] {0,1,0,0});
        markov.setRow(1, new double[] {0,0,1,0});
        markov.setRow(2, new double[] {0,0,0,1});
        markov.setRow(3, new double[] {1,0,0,0});
        
    }

    @Override
    public void run() {
        
        running = true;
        
        ToneBufferExtended buff = (ToneBufferExtended)buffer;
        
        int state = rand.nextInt(numStates);
        
        outer:
        while(running && !isInterrupted()){
            
            
            while(!buffer.hasSpace()){
                
                if (!running){
                    break outer;
                }
            }
            if (buff.getSpaceLeft() >= pieceSize){
                buff.pushList(toneLists[state]);
                state = markov.getNewState();
                System.out.println("Pushing state: " + state);
            }
            
            
            
        }
        
    }
    
    
    
    

    
    
}
