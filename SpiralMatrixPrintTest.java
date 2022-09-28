package test;

import com.company.SpiralMatrixPrint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixPrintTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testPrintSprialMatrix1() {
        Integer[][] matrix = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
        String expectedString = "1, 2, 3, 4, 5, 6, 12, 18, 24, 30, 29, 28, 27, 26, 25, 19, 13, 7, 8, 9, 10, 11, 17, 23, 22, 21, 20, 14, 15, 16";

        assertEquals(expectedString, SpiralMatrixPrint.printSprialMatrix(matrix));
    }

    @Test
    void testPrintSprialMatrix2() {
        Integer[][] matrix = {{1,2},{7,8},{13,14},{19,20}};
        String expectedString = "1, 2, 8, 14, 20, 19, 13, 7";

        assertEquals(expectedString, SpiralMatrixPrint.printSprialMatrix(matrix));
    }
}
