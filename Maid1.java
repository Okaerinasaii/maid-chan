import java.util.Scanner;
import java.io.*;
import sun.audio.*;
/**
 * Maid themed chat-bot
 * 
 * @author Derek Nguyen and Richard Xu 
 * @version (a version number or a date)
 */
    public class Maid1
    {
        public static void main(String args[]) throws InterruptedException
        {
            Scanner keyboard = new Scanner(System.in);
            String []positive = new String[20];
            positive[0] = "good";
            positive[1] = "well";
            positive[2] = "great";
            positive[3] = "amazing";
            String []emoticon = {"｡^‿^｡", "(＾ω＾)", "(◑‿◐)", "(∩^o^)⊃━☆ﾟ.*･｡ﾟ", "(っ´▽｀)っ","(#^-^#✿)" };
            //String []qwords = {"who", "what", "where", "when", "how", "why"};
            //String []nouns = {"time", "person", "year", "way", "day", "thing", "man", "world", "life", "hand", "part", "child", "eye", "woman", "place", "work", "week", "case", "point", "government", "company", "number", "group", "problem", "fact"};
            spek("Hello, what is your name?");
            String name = keyboard.nextLine();
            spek("Welcome Master "+ name +", nice to meet you!");
            spek("How are you feeling?");
            String answer = keyboard.nextLine();
            String[] reply = answer.split(" ");
            // insert file thingy for positive things here
            boolean set = happy(reply, positive);
            boolean tired = false;
            while (!tired)
            {
                if(set)
                {
                    spek("That's good!"); //emojis ^-^
                    
                }
                else
                {
                    spek("Aw, can I play a song for you");
                    String songd = keyboard.nextLine();
                    if (songd.equals("yes"))
                    {
                        music();
                    }
                    else
                    {
                        System.out.println("I've prepared dinner!");
                    }
                }
                if (set)
                {
                    spek("I have a special dinner prepared for you! " + emoticon[3]);
                    spek("Here is (dish)!");
                }
                else
                {
                    spek("How are you feeling now?");
                    answer = keyboard.nextLine();
                    reply = answer.split(" ");
                    if(set)
                    {
                        spek("Yay" + emoticon[rng()]);
                        spek("I have a special dinner prepared for you! " + emoticon[3]);
                        spek("no looking!" + emoticon[5]);                    
                    }
                }
                spek("Are you tired");
                answer = keyboard.nextLine();
                for (int i = 0; i < answer.length();i++)
                {
                    if (answer.substring(i,i+1).equals("ye"))
                        tired = true;
                }
            }
            spek("goodbye Master" + name);
            System.exit(0);
        }
        public static boolean happy(String[]x, String[]y)
        {
            boolean id= false;
            for (int i = 0; i<x.length;i++)
            {
                 for (int j = 0; j<y.length;j++)
                {
                    if (x[i].equals(y[j]))
                    {   
                        id = true;
                    }
                }
            }
            for (int i = 0; i<x.length;i++)
            {
                if ("not".equals(x[i]))
                {
                    id = false; //figure this stuff out
                }
            }
            return id;
        }
        public static int rng()
        {
            int num = (int)(Math.random() * 5);
            return num;
        }
        public static void spek(String voice) throws InterruptedException
        {
            for(int i = 0; i<voice.length(); i++)
            {
                System.out.print(voice.charAt(i));
                Thread.sleep(100);
            }
            System.out.println("");
            return;
        }
        public static void music()
        {
            AudioPlayer change = AudioPlayer.player;
            AudioStream song; 
            AudioData md;
            
            ContinuousAudioDataStream loop = null;
            
            try
            {
                song = new AudioStream(new FileInputStream("Safari.wav"));
                md = song.getData();
                loop = new ContinuousAudioDataStream(md);
            }catch(IOException error){}
            change.start(loop);
        }
    }
