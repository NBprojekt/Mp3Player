import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayMp3 { 
	public static void main( String [] args){ 
		
		JFileChooser fc = new JFileChooser();
		
		int result = fc.showOpenDialog(null);
		
		if ( result == JFileChooser.APPROVE_OPTION){
			try{
				
				File file = new File (fc.getSelectedFile().getAbsolutePath());
				FileInputStream fis = new FileInputStream (file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				
				try{
					
					Player player = new Player(bis);
					player.play();
					
				} catch (JavaLayerException e){
					System.out.println("Datei konnte nicht abgespielt werden");
				}
			} catch (IOException e){
				System.out.println("Datei konnte nicht gefunden werden");
				e.printStackTrace();
			}
		} 		

	}
}
