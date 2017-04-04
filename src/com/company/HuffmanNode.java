package com.company;

import java.util.Comparator;

/**
 * Created by tommy on 3/24/2017.
 */
public class HuffmanNode implements Comparable {
    private char character;
    private int frequency;
    private HuffmanNode par = null;
    private HuffmanNode child0 = null;
    private HuffmanNode child1 = null;

    // create
    public HuffmanNode(char c, int freq) {
        character = c;
        frequency = freq;
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
    public void setPar(HuffmanNode p) {
        par = p;
    }

    public void setChild0(HuffmanNode c0) {
        child0 = c0;
    }

    public void setChild1(HuffmanNode c1) {
        child1 = c1;
    }

    // overloaded toString
    public String toString() {
        return "[" + character + ", " + frequency + "]";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof HuffmanNode) {
            if(this.frequency != ((HuffmanNode) o).frequency)
                return ((HuffmanNode) o).frequency - this.frequency;
            else
                return this.character - ((HuffmanNode) o).character;
        }
        else {
            System.err.println("Comparing incompatable objects!!");
            throw new IllegalArgumentException();
        }
    }
}
