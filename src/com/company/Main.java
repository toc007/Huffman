package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        HuffmanTree h = new HuffmanTree();
        int hist[] = new int[256];
        Random r = new Random();
        for(int i=0; i<256; i++)
            hist[i] = r.nextInt(10);
        h.build(hist);
        h.printTree();
    }
}
