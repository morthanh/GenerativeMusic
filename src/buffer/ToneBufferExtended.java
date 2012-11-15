/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import note.Note;

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
    
    public boolean pushList(Note[] tones){
        for(Note t : tones){
            if (!push(t)){
                return false;
            }
        }
        return true;
    }
    
    
}
