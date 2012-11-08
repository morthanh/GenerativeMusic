package buffer;


/**
 * This is a abstract class for the classes that will be used as buffers. This 
 * class provides common methods that a buffer should provide like push(), pop(), and size(). 
 * 
 */
public abstract class Buffer<T> {
    
    /**
     * The size of the buffer
     */
    protected final int BUFFER_SIZE;

    public Buffer() {
        this(64);
    }
    public Buffer(int bufferSize){
        this.BUFFER_SIZE = bufferSize;
    }
    
    
    /**
     * This method will add the object <code>obj</code> 
     * to the buffer and return <code>true</code>. 
     * If <code>obj</code> could not be added then <code>false</code> must be
     * returned instead.
     * @param obj The object to add to the buffer
     * @return <code>true</code> if successfully added, <code>false</code> otherwise
     */
    public abstract boolean push(T obj);
    
    /**
     * Will remove an element from the buffer and return that object. If the 
     * buffer is empty then <code>null</code>is returned
     * @return An element from the buffer
     */
    public abstract T pop();
    
    /**
     * Returns a <code>boolean</code> indicating whether or not 
     * the buffer is full or not
     * @return <code>true</code> if the buffer is not empty, <code>false</code> otherwise
     */
    public boolean hasSpace(){
        return BUFFER_SIZE > this.size();
    }
    
    /**
     * Returns a <code>boolean</code> indicating whether or not 
     * the buffer is empty or not
     * @return <code>true</code> if the buffer is empty, <code>false</code> otherwise
     */
    public boolean isEmpty(){
        return this.size() > 0;
    }
    
    /**
     * Returns the number of elements in the buffer. This method must be properly implemented
     * by a subclass if the rest of the methods are to work properly.
     * @return An <code>int</code> representing the current size of the buffer
     */
    public abstract int size();
    
}
