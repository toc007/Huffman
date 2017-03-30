package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by tommy on 3/24/2017.
 */

public class Encoder{

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("File to encode: ");
        String inFile = cin.next();

        try {
            BufferedReader fin = new BufferedReader(new FileReader(inFile));

        }
        catch(Exception E) {

        }
    }

}
