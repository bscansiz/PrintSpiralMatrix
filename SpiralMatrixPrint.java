package com.company;

import java.util.*;

public class SpiralMatrixPrint {

    /**
     * Prints the spiral traversed matrix
     * @param matrix
     * @return
     */
    public static String printSprialMatrix(Integer[][] matrix) {
        return traverseSprialMatrix(matrix).toString()
                .replace("[", "")
                .replace("]", "");
    }

    /**
     * This method traverses the given matrix as spiral order
     * and define internal matrix and recursively call itself for internal matrix
     * @param matrix
     * @return spiral order of given matrix
     */
    private static Set<Integer> traverseSprialMatrix(Integer[][] matrix) {

        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        ArrayList<Integer> lastRow = new ArrayList<Integer>();
        ArrayList<Integer> lastColumn = new ArrayList<Integer>();
        ArrayList<Integer> firstColumn = new ArrayList<Integer>();
        Set<Integer> spiralOrderSet = new LinkedHashSet<Integer>();
        int rowLength = matrix.length - 1;
        int counter = 0;

        //Define an internal matrix
        Integer[][] internalMatrix =  null;
        if (rowLength > 0) {
            internalMatrix = new Integer[rowLength-1][];
        }

        for (Integer[] row : matrix) {
            //For each row, collect the data
            if (row.length > 0) {
                int columnLength = row.length - 1;

                //Collect first row items
                if (counter == 0)
                    firstRow.addAll(Arrays.asList(row));

                //Collect the last column items
                if (columnLength > 0)
                    lastColumn.add(row[columnLength]);

                //Collect the first column items for each row
                firstColumn.add(row[0]);

                //Collect last row items
                if (counter == rowLength)
                    lastRow.addAll(Arrays.asList(row));

                //All the other items will be collected as internal matrix
                if (counter != 0 && counter != rowLength) {
                    if (internalMatrix != null) {
                        internalMatrix[counter - 1] = Arrays.copyOfRange(row, 1, columnLength);
                    }
                }
                counter++;
            }
        }

        //Reverse order for firstColum and lastRow
        Collections.reverse(firstColumn);
        Collections.reverse(lastRow);

        //Merge all the collected items in firstRow list
        firstRow.addAll(lastColumn);
        firstRow.addAll(lastRow);
        firstRow.addAll(firstColumn);

        //To eliminate the same items, collect items in a set
        spiralOrderSet.addAll(firstRow);


        if ((internalMatrix != null &&
                Arrays.deepEquals(internalMatrix, new Integer[rowLength-1][]))
            || internalMatrix == null) {
            //If there is no item to be traversed anymore, return the collected set
            return spiralOrderSet;
        } else {
            //For internal matrix, call the method itself
            spiralOrderSet.addAll(traverseSprialMatrix(internalMatrix));
        }

        return spiralOrderSet;
    }
}
