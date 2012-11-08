/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import buffer.ToneBuffer;
import java.util.Random;
import rules.Rules;
import rules.Scale;
import tone.Tone;

/**
 *
 * @author mh
 */
public class RandomToneInScaleGenerator extends Generator{

    
    private static final int RANDOM_SEED = (int)(Math.random());
    
    private Random rand;
    
    
    int[] scale;
    
    
    
    
    
    public RandomToneInScaleGenerator(Rules rules, ToneBuffer buffer) {
        super(rules, buffer);
        this.buffer = buffer;
        rules.addScales(new int[] {Scale.SCALE_MIXOLYDIAN});
    }

    @Override
    public void run() {
        
        running = true;
        
        int octave = 3;
        
        scale = Scale.getScale(Scale.SCALE_MAJOR);
        int bottom = Scale.getNoteIndex(Scale.SCALE_MAJOR,octave , 0);
        int top = Scale.getNoteIndex(Scale.SCALE_MAJOR, octave +2 , 7);
        rand = new Random(RANDOM_SEED);
        
        outer:
        while(running && !isInterrupted()){
            
            int beat = beat();
            
            int noteIndex = bottom+rand.nextInt(top-bottom+1);
            System.out.println(bottom + " - " + top);
            while(!buffer.hasSpace()){
                
                if (!running){
                    break outer;
                }
            }
            buffer.push(new Tone(scale[noteIndex], 200, beat));
            
            
            
            System.out.println("Making tone: " + beat );
            
        }
        
        
    }
    
    
    
    
    
    
    
    
    
}
