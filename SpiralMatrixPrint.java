package com.company;

import java.util.*;

public class SpiralMatrixPrint {

    public static void main(String[] args) {
	// write your code here

        Integer[][] matrix = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};

        System.out.print(printSprialMatrix(matrix).toString());

    }

    public static String printSprialMatrix(Integer[][] matrix) {
        return traverseSprialMatrix(matrix).toString()
                .replace("[", "")
                .replace("]", "");
    }

    private static Set<Integer> traverseSprialMatrix(Integer[][] matrix) {

        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        ArrayList<Integer> lastRow = new ArrayList<Integer>();
        ArrayList<Integer> lastColumn = new ArrayList<Integer>();
        ArrayList<Integer> firstColumn = new ArrayList<Integer>();
        Set<Integer> set = new LinkedHashSet<Integer>();
        int rowLength = matrix.length - 1;
        Integer[][] internalMatrix =  null;
        if (rowLength > 0) {
            internalMatrix = new Integer[rowLength-1][];
        }


            int counter = 0;
            for (Integer[] row : matrix) {
                int columnLength = row.length - 1;
                if (counter == 0)
                    firstRow.addAll(Arrays.asList(row));

                lastColumn.add(row[columnLength]);
                firstColumn.add(row[0]);

                if (counter == rowLength)
                    lastRow.addAll(Arrays.asList(row));

                if (counter != 0 && counter != rowLength) {
                    if (internalMatrix != null) {
                        internalMatrix[counter - 1] = Arrays.copyOfRange(row, 1 , columnLength);
                    }
                }
                counter++;

            }

            Collections.reverse(firstColumn);
            Collections.reverse(lastRow);

            firstRow.addAll(lastColumn);
            firstRow.addAll(lastRow);
            firstRow.addAll(firstColumn);

            set.addAll(firstRow);


            if (internalMatrix!= null &&
                    Arrays.deepEquals(internalMatrix, new Integer[rowLength-1][])) {
                return set;
            } else {
                if (internalMatrix == null) {
                    return set;
                } else {
                    set.addAll(traverseSprialMatrix(internalMatrix));
                }
            }

            return set;
    }


}
