package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * Created by tommy on 3/24/2017.
 */

public class Encoder {
    private PrintWriter fout;
    private BufferedReader fin;
    private int hist[] = new int[256];

    public boolean openInputFile() {
        Scanner cin = new Scanner(System.in);
        System.out.println("File to encode: ");
        String inFile = cin.next();

        try {
            fin = new BufferedReader(new FileReader(inFile));
        } catch (Exception E) {
            System.err.println("Input file open fucked up");
            return false;
        }

        return true;
    }

    public boolean outputInputFile() {
        Scanner cin = new Scanner(System.in);
        System.out.println("Output File: ");
        String outFile = cin.next();
        try {
            fout = new PrintWriter(outFile);
        } catch (Exception E) {
            System.err.println("Output file open fucked up");
            return false;
        }

        return true;
    }

    public void getFrequency() {
        try {
            while(true) {
                int c = fin.read();
                if(c == -1) break;
                hist[c]++;
            }
            fin.reset();
        } catch (Exception E) {
            System.err.println("Reading from input file failed!!");
            return;
        }
    }

    public void resetFrequency() {
        hist = new int[256];
    }

    public void printFrequency() {
        System.out.print("[");
        for(int i=0; i<256; i++) {
            System.out.print(hist[i]);
            if(i!=255) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Encoder e = new Encoder();
        while(!e.openInputFile());
    }
}
