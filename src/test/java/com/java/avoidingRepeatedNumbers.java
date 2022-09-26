package com.java;

import java.util.ArrayList;

import org.bouncycastle.util.Integers;

public class avoidingRepeatedNumbers {
    public static void main(String[] args) {
        
        int temp;
        int c[];
        int[] a = {4,5,5,5,4,6,6,9,4};
        ArrayList<Integers>ab = new ArrayList<Integers>();
        for(int i = 0; i<a.length; i++){
            if(!ab.contains(a[i])){
                ab.add(a[i]);

                
            }
        }
    }
}
