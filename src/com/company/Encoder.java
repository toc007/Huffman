package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * Created by tommy on 3/24/2017.
 */

public class Encoder {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("File to encode: ");
        String inFile = cin.next();
        System.out.println("Output File: ");
        String outFile = cin.next();

        // handles reading/writing to output file
        PrintWriter fout;
        BufferedReader fin;

        //
        try {
            fin = new BufferedReader(new FileReader(inFile));
            fout = new PrintWriter(outFile);
            int hist[] = new int[256];
            while (true) {
                int charIn = fin.read();
                if (charIn == -1)
                    break;
                hist[charIn]++;
                System.out.println((char) charIn);
            }
        } catch (FileNotFoundException E) {
            System.err.println("Output file open failed!!");
            return;
        } catch (Exception E) {
            System.err.println("Something fucked up");
            return;
        }
    }


}
