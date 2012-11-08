
package rules;


/**
 *
 * @author mh
 */
public class Scale {
    
    //Grundtone
    static final int FUNDAMENTAL_NOTE = 60;
    
    //constants for the scales
    public static final int SCALE_DORIAN =     0;
    public static final int SCALE_LOCRIAN =    1;
    public static final int SCALE_LYDIA =      2;
    public static final int SCALE_MAJOR =      3;
    public static final int SCALE_MINOR =      4;
    public static final int SCALE_MIXOLYDIAN = 5;
    public static final int SCALE_PHRYGIAN =   6;
    
    
    // notes pr octave in a scale defined by the index
    private static final int[] NOTES_PR_OCTAVE = {7,7,7,7,7,7,7,7};
    
    
    
    //scales as integer arrays                                                                                                              XX
    static final int[] dorian =         {0,2,3,5,7,9,10,12,14,15,17,19,21,22,24,26,27,29,31,33,34,36,38,39,41,43,45,46,48,50,51,53,55,57,58,60,62,63,65,67,69,70,72,74,75,77,79,81,82,84,86,87,89,91,93,94,96,98,99,101,103,105,106,108,110,111,113,115,117,118,119,120,122,124,126,127} ;
    static final int[] locrian =        {0,1,3,5,6,8,10,12,13,15,17,18,20,22,24,25,27,29,30,32,34,36,37,39,41,42,44,46,48,49,51,53,54,56,58,60,61,63,65,66,68,70,72,73,75,77,78,80,82,84,85,87,89,90,92,94,96,97,99,101,102,104,106,108,109,111,113,114,116,118} ;
    static final int[] lydia =          {0,2,4,6,7,9,11,12,14,16,18,19,21,23,24,26,28,30,31,33,35,36,38,40,42,43,45,47,48,50,52,54,55,57,59,60,62,64,66,67,69,71,72,74,76,78,79,81,83,84,86,88,90,91,93,95,96,98,100,102,103,105,107,108,110,112,114,115,117,119,120,122,123,125,127} ;
    static final int[] major =          {0,2,4,5,7,9,11,12,14,16,17,19,21,23,24,26,28,29,31,33,35,36,38,40,41,43,45,47,48,50,52,53,55,57,59,60,62,64,65,67,69,71,72,74,76,77,79,81,83,84,86,88,89,91,93,95,96,98,100,101,103,105,107,108,110,112,113,115,117,119,120,121,123,125,127} ;
    static final int[] minor =          {0,2,3,5,7,8,10,12,14,15,17,19,20,22,24,26,27,29,31,32,34,36,38,39,41,43,44,46,48,50,51,53,55,56,58,60,62,63,65,67,68,70,72,74,75,77,79,80,82,84,86,87,89,91,92,94,96,98,99,101,103,104,106,108,110,111,113,115,116,118} ;
    static final int[] mixolydian =     {0,2,4,5,7,9,10,12,14,16,17,19,21,22,24,26,28,29,31,33,34,36,38,40,41,43,45,46,48,50,52,53,55,57,58,60,62,64,65,67,69,70,72,74,76,77,79,81,82,84,86,88,89,91,93,94,96,98,100,101,103,105,106,108,110,112,113,115,117,118} ; 
    static final int[] phrygian =       {0,1,3,5,6,8,10,11,12,13,15,17,18,20,22,23,24,25,27,29,30,32,34,35,36,37,39,41,42,44,46,47,48,49,51,53,54,56,58,59,60,61,63,65,66,68,70,71,72,73,75,77,78,80,82,83,84,85,87,89,90,92,94,95,96,97,99,101,102,104,106,107,108,109,111,113,114,116,118,119,121,122,124,126,127} ;
	
    
    
    /**
     * Method to return a scale as an integer array. The scales are referenced 
     * by a constant in Scale class with "SCALE_" prefix. Throws a 
     * IllegalArgumentException if the scale does not exist.
     * @param i The scale to return 
     * @return The scale as an integer array
     */
    public static int[] getScale(int i){
        switch(i){
            case SCALE_DORIAN:
                return dorian;
            case SCALE_LOCRIAN:
                return locrian;
            case SCALE_LYDIA:
                return lydia;
            case SCALE_MAJOR:
                return major;
            case SCALE_MINOR:
                return minor;
            case SCALE_MIXOLYDIAN:
                return mixolydian;
            case SCALE_PHRYGIAN:
                return phrygian;
            default:
                throw new IllegalArgumentException("rules.Scale: The scale "+ i + " does not exist");
        }
    }

    
    /**
     * Gets the index for a specific note in a specific octave from a specific scale
     * @param scale
     * @param octaveNum
     * @param noteOffset
     * @return 
     */
    public static int getNoteIndex(int scale, int octaveNum, int noteOffset){
        return NOTES_PR_OCTAVE[scale] * (octaveNum+1)  + noteOffset;
    }
    
    
    
    
    
}
