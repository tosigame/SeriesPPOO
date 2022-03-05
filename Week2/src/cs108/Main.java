package cs108;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {


    static double entropy(int[] freq){
        int count=0;
        for (int i = 0; i < freq.length; i++) {
            count+=freq[i];
        }
        double entropy=0;
        for (int i = 0; i < freq.length; i++) {
            double tempProb=(double) freq[i]/count;
            entropy+=tempProb*Math.log(tempProb)/Math.log(2);
        }
        System.out.println(-entropy);
        return -entropy;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 1; i++) {


            String file0Name = "/home/tosigame/IdeaProjects/SeriesPPOO/Week2/src/cs108/file" + i + ".bin";
            int[] file0 = byteFrequencies(file0Name);
            // System.out.println(Arrays.toString(file0));
            System.out.println("File:"+i+" average: " + average(file0));
            System.out.println("entropy: " + entropy(file0));
            System.out.println("historgram "+ stemplot(file0));
        }

    }
    static String stemplot(int[] freq){

        String histogram="";
        for (int i = 0; i <= freq.length/10; i++) {
            histogram+="\n"+i+"|";
            for (int j = 0; j < freq[i] ; j++) {


                    histogram += j % 10;

            }

        }
        return histogram;

    }
    static int[] byteFrequencies(String fileName) throws IOException {
        int[] b=new int[256];
        InputStream s=new FileInputStream(fileName);
        try {
            int temp=0;
            try {
                while(true){
                    temp=s.read();
                    if(temp!=-1) {
                        b[temp]++;
                    }else{
                        throw new EOFException();
                    }

                }
            }catch (EOFException e){
               // System.out.println("end of file");
            }

        }finally {
            s.close();
        }
        return b;
    }

    static double average(int[] freq){
        double average=0;
        for (int i = 0; i < freq.length ; i++) {
            average+=i*freq[i]/256.f;
        }
        return average;
    }
}
