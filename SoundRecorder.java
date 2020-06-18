import javax.sound.sampled.*;
import java.io.*;
public class SoundRecorder {
	static final long time=6000;
	File file=new File("Record.wav");
	AudioFileFormat.Type filetype=AudioFileFormat.Type.WAVE;
	TargetDataLine dataline;
	AudioFormat getFormat() {
		double rate=8000.0;
		int bitsize=16;
		int channel=1;
		boolean sign=true;
		boolean bigend=true;
		AudioFormat af=new AudioFormat((float) rate,bitsize,channel,sign,bigend);
		return af;
	}
	void start() {
		try {
			AudioFormat af=getFormat();
			DataLine.Info info=new DataLine.Info(TargetDataLine.class, af);
			if(!AudioSystem.isLineSupported(info));{
				System.out.println("Line is not supported");
				System.exit(0);
			}
			dataline=(TargetDataLine)AudioSystem.getLine(info);
			dataline.open(af);
			dataline.start();
			System.out.println("Start to capture");
			AudioInputStream ais=new AudioInputStream(dataline);
			System.out.println("Start to record");
			AudioSystem.write(ais, filetype, file);
		}
		catch(LineUnavailableException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	void end() {
		dataline.stop();
		dataline.close();
		System.out.println("Finish");
	}
	public static void main(String args[]) {
		final SoundRecorder sr=new SoundRecorder();
		Thread stop=new Thread(new Runnable() {
			public void run() {
			try {
				Thread.sleep(time);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			sr.end();
			}
		});
		stop.start();
		sr.start();
	}
}
