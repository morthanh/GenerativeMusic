/**
 * 
 * For information on usage and redistribution, and for a DISCLAIMER OF ALL
 * WARRANTIES, see the file, "LICENSE.txt," in this distribution.
 * 
 */



import buffer.ToneBuffer;
import buffer.ToneBufferExtended;
import generator.Generator;
import generator.MarkovTestGenerator;
import generator.RandomToneInScaleGenerator;
import org.puredata.core.PdBase;
import rules.Rules;

/**
 *
 * Minimal tutorial example of how to use libpd with JavaSound.
 *
 * @author Peter Brinkmann (peter.brinkmann@gmail.com)
 *
 */
public class JavaSoundSample {

	public JavaSoundSample() throws Exception {
                
                ToneBuffer buffer = new ToneBufferExtended(8);
                listener l = new listener(buffer);
                Rules rules = new Rules();
                
		JavaSoundThread audioThread = new JavaSoundThread(44100, 2, 16);
                Generator toneGeneratorThr = new MarkovTestGenerator(rules, buffer);
                
                PdBase.setReceiver(l);
                dispatcher disp = new dispatcher();
                disp.addListener("metro", l);
		int patch = PdBase.openPatch("4step.pd");
                PdBase.sendFloat("tempo", 200);
                
                //start the two threads
		audioThread.start();
                Thread.sleep(1000);
                toneGeneratorThr.start();
                
                
		Thread.sleep(20000);  // Sleep for five seconds; this is where the main application code would go in a real program.
                
                //shutdown and end
		audioThread.interrupt();
		audioThread.join();
                toneGeneratorThr.interrupt();
                audioThread.join();
                
		PdBase.closePatch(patch);
	}
}
