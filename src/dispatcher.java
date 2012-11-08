
import org.puredata.core.utils.PdDispatcher;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mh
 */
public class dispatcher extends PdDispatcher{

    @Override
    public void print(String s) {
        System.out.println("Dispatcher.print(): "+s);
    }
    
}
