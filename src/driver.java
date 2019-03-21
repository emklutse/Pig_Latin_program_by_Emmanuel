/*
Emmanuel Klutse
This program takes a string and converts it to pig latin.
 */

import java.util.Arrays;
import java.util.Scanner;

public class driver {
    public static void main(String[] args)
    {
        while (true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("This program will take a sentence and turn it into pig latin. ");
            System.out.println("Enter your sentence here: ");
            String sentence = scan.nextLine();
            System.out.println(pigLatin(sentence));
        }
    }

    public static String pigLatin(String sent)
    {
        String[] list = sent.split("\\s+");//this will split a string by spaces into an array of string.
        StringBuilder buffer = new StringBuilder();
        for(int i=0; i<list.length; i++) {
            char[] charbuf = list[i].toCharArray();//turning array to string
            if (!Character.isDigit(charbuf[0])) {
                if(Character.isLetter(charbuf[charbuf.length-1])){
                    leftRotate(charbuf,1);
                    buffer.append(charbuf).append("AY ");
                }
                else if(!Character.isAlphabetic(charbuf[0])){
                    char first = charbuf[0];
                    char[] copybuf = Arrays.copyOfRange(charbuf,1,charbuf.length-1);
                    leftRotate(copybuf,1);
                    buffer.append(first).append(copybuf).append("AY ");
                }
                else{
                    char last = charbuf[charbuf.length-1];
                    char[] copybuf = Arrays.copyOf(charbuf,charbuf.length-1);
                    leftRotate(copybuf,1);
                    buffer.append(copybuf).append("AY").append(last).append(" ");
                }
            }
            else buffer.append(list[i]).append(" ");
        }
        String out = buffer.toString();
        return out;
    }

  public static void leftRotate(char buf[], int d)
  {
        for (int i = 0; i < d; i++)
        {
            int j;
            char temp = buf[0];
            for (j = 0; j<buf.length-1; j++)
            {
                buf[j] = buf[j + 1];
            }
            buf[j] = temp;
        }
    }
}
