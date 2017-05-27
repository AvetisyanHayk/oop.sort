package be.howest.util;

/**
 *
 * @author Hayk
 */
public final class Sort {

    private Sort() {
    }

    public static void insertionSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            for (int currentIndex = 1; currentIndex < numbers.length; currentIndex++) {
                int refIndex = getRefIndexForInsertionSort(numbers, currentIndex);
                if (refIndex >= 0) {
                    insertInto(numbers, currentIndex, refIndex);
                }
            }
        }
    }

    private static int getRefIndexForInsertionSort(int[] numbers, int currentIndex) {
        int refIndex = -1;
        for (int lowerIndex = currentIndex - 1; lowerIndex >= 0; lowerIndex--) {
            if (numbers[currentIndex] <= numbers[lowerIndex]) {
                refIndex = lowerIndex;
            }
        }
        return refIndex;
    }

    private static void insertInto(int[] numbers, int currentIndex, int refIndex) {
        int current = numbers[currentIndex];
        for (int i = currentIndex; i > refIndex; i--) {
            exchange(numbers, i - 1, i);
        }
        numbers[refIndex] = current;
    }

    private static void exchange(int[] numbers, int currentIndex, int refIndex) {
        int current = numbers[currentIndex];
        numbers[currentIndex] = numbers[refIndex];
        numbers[refIndex] = current;
    }

    public static void selectionSort(int[] numbers) {
        throw new UnsupportedOperationException();
    }

    public static void exchangeSort(int[] numbers) {
        throw new UnsupportedOperationException();
    }
}
