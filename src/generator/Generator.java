/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import buffer.Buffer;
import rules.Rules;

/**
 *
 * @author mh
 */
public abstract class Generator extends Thread{
    
    protected Rules rules;
    protected Buffer buffer;
    
    /**
     * This variable is used to keep the thread going. If <code>running</code>
     * is false then the thread should stop.
     */
    protected volatile boolean running = false;
    
    //beat counter for generator proccessing
    protected int beatCount = 0;
    //measure count for generator proccessing
    protected int measureCount = 0;

    public Generator(Rules rules, Buffer buffer) {
        this.rules = rules;
        this.buffer = buffer;
    }
    
    
    
    
    
    
    @Override
    public void interrupt() {
        running = false;
        super.interrupt();
    }
    
    /**
     * Adds 1 to beatCount and returns the current beat number
     * @param i 
     * @return 
     */
    protected int beat(){
        int b = beatCount++%(rules.getBeatPerMeasure());
        if (b == 0) {measureCount++;}
        return b;
    }

    
    
}
