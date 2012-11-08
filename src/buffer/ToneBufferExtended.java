/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import tone.Tone;

/**
 *
 * @author mh
 */
public class ToneBufferExtended extends ToneBuffer {

    public ToneBufferExtended(int size) {
        super(size);
    }
    
    
    
    public int getSpaceLeft(){
        return BUFFER_SIZE - size();
    }
    
    public boolean pushList(Tone[] tones){
        for(Tone t : tones){
            if (!push(t)){
                return false;
            }
        }
        return true;
    }
    
    
}
