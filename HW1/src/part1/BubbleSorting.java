package HW1.src.part1;

import java.util.Arrays;

public class BubbleSorting {
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int[] sort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i-1]) {
                    swap(array, i, i - 1);
                    isSorted = false;
                }
            }
        }

        return array;
    }
    public static void main(String[] args) {
        int[] array = {12, 65, 45, 153, 178 , 1, 12789, 78, 0};
        int[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
