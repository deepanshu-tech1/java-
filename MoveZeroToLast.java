import java.util.Arrays;

public class MoveZeroToLast {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        int index = 0; // non-zero elements ka index

        // non-zero elements ko aage lao
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // baaki jagah zero daal do
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }

        System.out.println(Arrays.toString(arr));
    }
}
