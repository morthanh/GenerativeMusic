/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

/**
 *
 * @author mh
 */
public class Rules {
    
    
    //default/fallback rules
    private int tempoBpm = 100;                             //tempo in bpm
    private int[] usableScales = { Scale.SCALE_MAJOR };     //den/de skalaer som kan bruges
    private int transpose = 0;                              //transponering
    private int beats = 4;
    private int bars = 4;
    private int beatPerMeasure = beats*bars;                //antal slag pr. takt    (beats/bars)
    
    public Rules() {
    }

    
    
    
        
    /**
     * Returns Beats Per Minute converted to Milliseconds
     * @param bpm Beats per minute
     * @return Beats per minute as milliseconds
     */
    public double bmpToMillis(double bpm){
        // Bjørns magical formula here
        //TODO - lav generel formel
        return 15000 / bpm;
    }
    
    
    
    
    
    /****** Getters ******/
    /**
     * Retrieves the number of beats per measure
     * The default return value is 16
     * @return Number of beats per measure
     */
    public int getBeatPerMeasure() {
        return beatPerMeasure;
    }
    /**
     * Returns an array of integers representing the scales that are allowed
     * @return 
     */
    public int[] getUsableScales(){
        return usableScales;
    }
    /**
     * Returns the scale <code>i</code>. Will throw an 
     * <code>IllegargumentException</code> if the scale is not allowed
     * @param i The scale to get
     * @return The scale as integer array
     */
    public int[] getScale(int i){
        //see if the scale is allowed
        boolean found = false;
        for (int s : usableScales){
            if (s == i){
                found = true;
                break;
            }
        }
        if (found){
            return Scale.getScale(i);
        }
        else{
            throw new IllegalStateException("rules.Rules: Scale "+i+" is not allowed");
        }
    }
    public int getTempoInBpm(){
        return tempoBpm;
    }
    public int getTempoInMills(){
        return (int)bmpToMillis(tempoBpm);
    }
    
    
    
    /****** Setters ******/
    /**
     * Sets Beats Per Minute
     * @param bpm 
     */
    public void setTempoBmp(int bpm){
        this.tempoBpm = bpm;
    }
    /**
     * Replaces the allowed scales with a new one. Throws and 
     * IllegalArgumentException if one of the values are not valid scales.
     * @param scales the scales that should be allowed
     */
    public void addScales(int[] scales){
        //se if scale exists, if not throw exception
        for(int i : scales){
            if (i != Scale.SCALE_DORIAN &&
                i != Scale.SCALE_LOCRIAN &&
                i != Scale.SCALE_LYDIA &&
                i != Scale.SCALE_MAJOR && 
                i != Scale.SCALE_MINOR && 
                i != Scale.SCALE_MIXOLYDIAN && 
                i != Scale.SCALE_PHRYGIAN){
                throw new IllegalArgumentException("rules.Rules: Scale "+i+" is not allowed");
            }
        }
        usableScales = scales;
    }
    
}
