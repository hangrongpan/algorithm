package coursera.week1;

import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class CountInversionNaive {

    private int countInv(int[] A) {

        if (A.length == 0 || A.length == 1) {
            return 0;
        }

        int leftInv = countInv(copyOfRange(A, 0, A.length / 2));
        int rightInv = countInv(copyOfRange(A, A.length/2 + 1, A.length));
        int splitInv = splitCountInv(A);

        return leftInv + rightInv + splitInv;
    }

    private int splitCountInv(int[] A) {
        // refer to ConntInversion.java
        return -1;
    }
}
