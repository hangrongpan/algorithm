package coursera.week1;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CountInversion {

    public ArrayCount sortAndCountInv (int[] A) {
        int len = A.length;
        if (len == 0 || len == 1) {
            return new ArrayCount(A, 0);
        }
        ArrayCount leftArrayCount = sortAndCountInv(Arrays.copyOfRange(A, 0, len/2));
        ArrayCount rightArrayCount = sortAndCountInv(Arrays.copyOfRange(A, len/2, len));
        ArrayCount mergedCount = mergeAndCountInv(leftArrayCount.resultArray, rightArrayCount.resultArray);

        return new ArrayCount(mergedCount.resultArray,leftArrayCount.invCount + rightArrayCount.invCount + mergedCount.invCount);
    }

    public ArrayCount mergeAndCountInv(int[] C, int[] D) {
        int[] B = new int[C.length + D.length];
        int i = 0, j = 0, k = 0;
        int invCount = 0;
        while (i < C.length && j < D.length) {
            if (C[i] < D[j]) {
                B[k++] = C[i++];
            } else {
                B[k++] = D[j++];
                invCount += (C.length - i);
            }
        }
        while (i < C.length) {
            B[k++] = C[i++];
        }
        while (j < D.length) {
            B[k++] = D[j++];
        }
        return new ArrayCount(B,invCount);
    }


    class ArrayCount {
        int[] resultArray;
        int invCount;

        public ArrayCount(int[] A, int count) {
            resultArray = A;
            invCount = count;
        }
    }

    @Test
    public void testCountInversion() {
        int[] case1 = {1,3,5,2,4,6};
        int count1 = sortAndCountInv(case1).invCount;
        assertEquals("Comparing case1 inversion count: ",3, count1);

        int[] case2 = {1,5,3,2,4};
        int count2 = sortAndCountInv(case2).invCount;
        assertEquals(4, count2);

        int[] case3 = {5,4,3,2,1};
        int count3 = sortAndCountInv(case3).invCount;
        assertEquals(10, count3);

        int[] case4 = {1,6,3,2,4,5};
        int count4 = sortAndCountInv(case4).invCount;
        assertEquals(5, count4);

        int[] case5 = { 9, 12, 3, 1, 6, 8, 2, 5, 14, 13, 11, 7, 10, 4, 0 };
        int count5 = sortAndCountInv(case5).invCount;
        assertEquals(56, count5);

        int[] case6 = { 37, 7, 2, 14, 35, 47, 10, 24, 44, 17, 34, 11, 16, 48, 1, 39, 6, 33, 43, 26, 40, 4, 28, 5, 38, 41, 42, 12, 13, 21, 29, 18, 3, 19, 0, 32, 46, 27, 31, 25, 15, 36, 20, 8, 9, 49, 22, 23, 30, 45 };
        int count6 = sortAndCountInv(case6).invCount;
        assertEquals(590, count6);
    }
}
