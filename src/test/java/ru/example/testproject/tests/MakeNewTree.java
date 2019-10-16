package ru.example.testproject.tests;

import org.testng.annotations.Test;

public class MakeNewTree {

    @Test(description = "Тест, который рисует ёлочку")
    public void testMakeNewTree(){
        makeTree(4, "tree.txt");
    }

    private void makeTree(int florNumber, String fileName){
        int flors = florNumber + 2;

        for (int i = 0; i <= flors; i++) {
            if (i == 0){
                for (int j = 0; j < flors - i; j++)
                    System.out.print(" ");
                for (int k = 0; k < (2 * i + 1); k++)
                    System.out.print("W");
                System.out.println();
            }
            if (i > 0 && i < (flors - 1)){
                if (i%2 == 0){
                    for (int j = 0; j < flors - i; j++)
                        System.out.print(" ");
                    for (int k = 0; k < (2 * i + 1); k++)
                        System.out.print("*");
                    System.out.print("@");
                    System.out.println();
                } else {
                    for (int j = 0; j < flors - i; j++)
                        System.out.print(" ");
                    System.out.print("@");
                    for (int k = 0; k < (2 * i + 1); k++)
                        System.out.print("*");
                    System.out.println();
                }

            }
            if (i == flors){
                for (int j = 0; j < flors - 2; j++)
                    System.out.print(" ");
                for (int k = 0; k < (2 * 1); k++)
                    System.out.print("TT");
                System.out.println();
            }
        }

    }

}
