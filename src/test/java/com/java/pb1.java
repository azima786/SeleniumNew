package com.java;

public class pb1 {
    static int k=3;
    public static void main(String[] args) {
    //    for(int i =0; i<4; i++){
        
    //     for (int j = 1; j <=4-i; j++) {
    //         System.out.print(k);
    //        System.out.print("\t");
    //         k++;
    //    }

    //    System.out.println("");
    // }

    // for(int i =0; i<4; i++){
        
    //     for (int j = 1; j <=1+i; j++) {
    //         System.out.print(k);
    //        System.out.print("\t");
    //         k++;
    //    }

    //    System.out.println("");
    // }

    // for(int i =0; i<4; i++){
       
    //     for (int j = 1; j <=1+i; j++) {
    //         System.out.print(j);
    //    }

    //    System.out.println("");
    // }

    //prints 3,6,9,12,15,18
    for(int i =3; i<=10; i+=3){
   
        for (int j = 3; j <=1+i; j+=3) {
            System.out.print(k);
            System.out.print("\t");
            k+=3;
       }

       System.out.println("");
    }
    }
}