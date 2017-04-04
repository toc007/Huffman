package com.company;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * Created by tommy on 3/24/2017.
 */
public class HuffmanTree {
    private HuffmanNode root;
    private HuffmanNode leaves[] = new HuffmanNode[256];

    public void build(int freq[]) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>();

        // create and add characters with non-zero frequencies
        for(char c=0; c<256; c++) {
            if(freq[c] != 0) {
                HuffmanNode newNode = new HuffmanNode(c, freq[c]);
                pq.add(newNode);
                leaves[c] = newNode;
            }
        }

        while(pq.size() > 1) {
            // pop out the 2 largest HuffmanNodes in the pq
            HuffmanNode n0 = pq.poll();
            HuffmanNode n1 = pq.poll();

            // get max character and the sum of the frequencies of n0 and n1 for the new node
            char maxChar = (n0.getCharacter() > n1.getCharacter()) ? n0.getCharacter():n1.getCharacter();
            int sumfreq = n0.getFrequency()+n1.getFrequency();

            HuffmanNode newNode = new HuffmanNode(maxChar, sumfreq, null, n0, n1);

            n0.setPar(newNode);
            n1.setPar(newNode);
            pq.add(newNode);
        }

        while(!pq.isEmpty())
            root = pq.poll();
    }

    public String encodeChar(char c) {
        // StringBuffer to prepend the results
        StringBuffer res = new StringBuffer();

        if(leaves[c] == null) {
            System.err.println("Character " + c + " not found!!");
            return "";
        }

        // var to traverse the tree from bottom up
        HuffmanNode iter = leaves[c];
        while(iter.getPar() != null) {
            HuffmanNode temp = iter.getPar();
            iter = iter.getPar();
            res.insert(0, (temp.getChild0() == iter)?'0':'1');
        }
        return res.toString();
    }

    public void printTree() {
        if(root == null)
            return;
        printTreeHelp(root);
    }

    private void printTreeHelp(HuffmanNode n) {
        if(n == null)
            return;
        System.out.println(n);
        printTreeHelp(n.getChild0());
        printTreeHelp(n.getChild1());
    }
}


