package com.company;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    private static void inputArrays(int n,int interconnectingLines,int h[][],int v[][]){
        char bufferInputChar;
        int bufferInputI,bufferInputJ;
        System.out.println("Enter  interconnecting lines : ");
        while (interconnectingLines!=0){
            bufferInputChar = input.next().charAt(0);
            bufferInputI = input.nextInt()-1;
            bufferInputJ = input.nextInt()-1;
            if((bufferInputI>n-1||bufferInputI<0)||(bufferInputJ>n-2||bufferInputJ<0)){
                System.out.println("Wrong input !! try again");
            }
            else switch (bufferInputChar){
                case 'H':{
                    if(h[bufferInputI][bufferInputJ]==1){
                        System.out.println("the horizontal is found , try again");
                    }
                    else {
                        h[bufferInputI][bufferInputJ]=1;
                        interconnectingLines--;
                    }
                    break;
                }
                case 'V':{
                    if(v[bufferInputJ][bufferInputI]==1){
                        System.out.println("the vertical is found , try again");
                    }
                    else {
                        v[bufferInputJ][bufferInputI]=1;
                        interconnectingLines--;
                    }
                    break;
                }
                default: {
                    System.out.println("Char wrong!! Try again");

                }
            }
        }
    }
    private static int[] findNumberSquares(int n,int h[][],int v[][]){
        int numSizeSquare[]=new int[n];
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-1;j++){
                int f=(i>j?i : j);
                for (int k=0;k<n-1-f;k++){
                    int sum = 0;
                    for (int l=0;l<k+1;l++){
                        sum += h[i][j+l] + h[i+k+1][j+l] + v[i+l][j] + v[i+l][j+k+1];
                    }
                    if(sum/4==k+1){
                        numSizeSquare[k]++;
                    }
                }
            }
        }
        return numSizeSquare;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	    int n=4,m=16;
        int[][]  horizontal, vertical;
        int numSizeSquare[];
        while (true){
            System.out.print("Enter size of array : ");
            n=input.nextInt();
            if(n>1&&n<9) break;
            System.out.println("Wrong!! will be n range [2,9]");
        }
        while (true){
            System.out.print("Enter m : ");
            m=input.nextInt();
            if(m>=0) break;
            System.out.println("Wrong!! will be m is positive");
        }
        horizontal = new int[n][n-1];
        vertical = new int[n-1][n];
        inputArrays(n,m, horizontal, vertical);
       /* horizontal =new int[][] {
                {1,0,1},{1,1,1},{0,1,0},{0,1,1}
        };
        vertical =new int[][] {
                {1,1,0,1},{0,1,1,1},{0,1,0,1}
        };*/
        numSizeSquare=findNumberSquares(n, horizontal,vertical);
        boolean flag =  false;
        System.out.println("problem #1 \n");
            for(int i=0;i<n-1;i++){
                if(numSizeSquare[i]>0){
                    System.out.println(numSizeSquare[i]+" square (s) of size "+(i+1) );
                    flag = true;
                }

            }
        if (!flag){
            System.out.println("No completed squares can be found.");
        }

    }
}
