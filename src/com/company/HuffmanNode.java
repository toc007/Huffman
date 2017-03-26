package com.company;

/**
 * Created by tommy on 3/24/2017.
 */
public class HuffmanNode {
    private char character;
    private int frequency;
    private HuffmanNode par;
    private HuffmanNode child0;
    private HuffmanNode child1;

    // create
    public HuffmanNode(char c, int freq) {
        character = c;
        frequency = freq;
        par = null;
        child0 = null;
        child1 = null;
    }

    public HuffmanNode(char c, int freq, HuffmanNode p, HuffmanNode c0, HuffmanNode c1) {
        character = c;
        frequency = freq;
        par = p;
        child0 = c0;
        child1 = c1;
    }
    // read
    public char getCharacter() {
        return character;
    }

    public int getFrequency() {
        return frequency;
    }

    public HuffmanNode getPar() {
        return par;
    }

    public HuffmanNode getChild0() {
        return child0;
    }

    public HuffmanNode getChild1() {
        return child1;
    }

    // update
    // delete
}
