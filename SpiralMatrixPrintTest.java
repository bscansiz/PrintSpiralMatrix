package com.company;


import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralMatrixPrintTest {
    public static void main(String[] args) {
        // write your code here

        Integer[][] matrix = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
        String expectedResult = "1, 2, 3, 4, 5, 6, 12, 18, 24, 30, 29, 28, 27, 26, 25, 19, 13, 7, 8, 9, 10, 11, 17, 23, 22, 21, 20, 14, 15, 16";
        assertEquals (expectedResult, SpiralMatrixPrint.printSprialMatrix(matrix).toString());

    }
}