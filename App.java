import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class App
{
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        String response="";
        Scanner scanner = new Scanner(System.in);

        File file = new File("Travel - JayJen & tubebackr.wav"); 
        AudioInputStream audioSteam = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioSteam);

        System.out.print("\n  **  FBS Audio Player  **\n\n"+
                           "-==========================-\n"+
                           "(P >> play)  (S || stop)  (R |< reset)  (Q X Quit)\n"+
                           "waiting for your response ~ ~  \n "
                           );


        while(!response.equals("Q")){
            System.out.print("\t[=]   ");
            response = scanner.next();  
            response = response.toUpperCase();

            switch(response)
            {
                case "P": 
                    clip.start();
                    break;
                case "S":
                    clip.stop();
                    break;
                case "R":
                    clip.setMicrosecondPosition(0);
                    break;
                case "Q":
                    clip.close();
                    break;
                default :
                    System.out.println("Not a valid response");
            }
        }
        System.out.println("  **  Thank you for listening <3  **\n");

    }
}