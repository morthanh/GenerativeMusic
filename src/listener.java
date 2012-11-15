
import note.Note;
import buffer.ToneBuffer;
import org.puredata.core.PdBase;
import org.puredata.core.PdReceiver;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mh
 */
public class listener implements PdReceiver {

    public int noteValue = 50;
    public int attack = 100;

    final ToneBuffer buffer;
    
    
    public listener(ToneBuffer buffer) {
        this.buffer = buffer;
    }

    
    
    
    
    @Override
    public void receiveBang(String source) {
        Note tone = buffer.pop();
//        System.out.print("Received Bang: ");
        
        if (tone != null){
//            System.out.print(tone.beat);
            PdBase.sendList("inst1_notevalue", 
                    tone.pitch, 
//                    "amplitude",    //0-127
                    tone.attack,    //0-2000
                    "decay",        //0-2000 
                    "lowpass",      //100-22000
                    "highpass",     //100-22000
                    "tembere",      //0-12
                    "deetune");     //0-5 );
    //        noteValue++;
    //        if (noteValue % 2 == 0) {
    //            PdBase.sendList("inst1_notevalue", noteValue, attack);
    //        }
        }
//        System.out.println();
        
        
    }

    @Override
    public void receiveFloat(String source, float x) {
        System.out.println("Received Float");
    }

    @Override
    public void receiveSymbol(String source, String symbol) {

        System.out.println("Received Symbol");
    }

    @Override
    public void receiveList(String source, Object... args) {
        System.out.println("Received List");
    }

    @Override
    public void receiveMessage(String source, String symbol, Object... args) {

//        System.out.println("Received Message (" + source + "," + symbol + ")");
    }

    @Override
    public void print(String s) {
        System.out.println("Received: '" + s + "'");
    }
}
