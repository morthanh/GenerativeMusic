package buffer;


import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import note.Note;

/**
 *
 * @author mh
 */
public class ToneBuffer extends Buffer<Note> {
    
    
    Queue<Note> buffer = new LinkedBlockingQueue<>(BUFFER_SIZE);

    /**
     *  Creates a new ToneBuffer object. Uses an LinkedBlockingQueue object 
     *  to store the Tone objects
     */
    public ToneBuffer() {
        super(10);
    }
    public ToneBuffer(int size){
        super(size);
    }
    
    
    @Override
    public boolean push(Note tone){
        return buffer.add(tone);
    }
    
    @Override
    public Note pop(){
        return buffer.poll();
    }

    @Override
    public int size() {
        return buffer.size();
    }

    
}
