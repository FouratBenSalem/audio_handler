import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

/*
    GOAL : to have an Audio Player GUI application that has buttons and event listeners, capable 
        of playing audio files of type .wav (mp3 isn't supported for now), and that enables the user to 
        play audio files in his computer by putting their path in a text field.
        look on internet if you can make this series of events : user right clicks on an audio file,
        chooses your application to play the audio, app launches and plays the piece (maybe by entering the path as an argument)

 USER GENERATED EXCEPTIONS : 
*/

public class App
{
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        String response="";
        Scanner scanner = new Scanner(System.in);
        System.out.println( "\n\t  **  FBS Audio Player  **\n\n"+
                            "\t    -==========================-\n"+ 
                            "\n\tPath to audio File : ");
        

        File file = new File("Travel - JayJen & tubebackr.wav"); 
        AudioInputStream audioSteam = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioSteam);

        System.out.print(  " Length : "+clip.getMicrosecondLength()+ " micro S\n"+
                           "\t(P |> Play)  (S || Stop)  (F >> Forward 10s)  (R |< Reset)  (Q X Quit)\n"+
                           "\twaiting for your response ~ ~  \n "
                           );


        while(!response.equals("Q")){
            System.out.print("\t\t[=]   ");
            response = scanner.next();  
            response = response.toUpperCase();

            switch(response)
            {
                case "P": 
                    if(clip.getMicrosecondPosition() == clip.getMicrosecondLength()){
                        clip.setMicrosecondPosition(0);
                        
                    }
                    System.out.println("\t\t>>");
                    clip.start();
                    break;
                case "S":
                    System.out.println("\t\t||");
                    clip.stop();
                    
                    break;
                case "F":
                    System.out.println("\t\t>>");
                    clip.setMicrosecondPosition( clip.getMicrosecondPosition() +10000000);
                    break;


                case "R":
                    System.out.println("\t\t|<");
                    clip.setMicrosecondPosition(0);
                    clip.start();

                    break;
                case "Q":
                    System.out.println("\t\tX");
                    clip.close();
                    break;
                default :
                    System.out.println("Not a valid response");
            }
        }
        System.out.println("  **  Thank you for listening <3  **\n");





        scanner.close();
    }
}