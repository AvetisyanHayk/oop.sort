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
                int refIndex = lowerIndexOfGreaterThanOrEqualNumber(numbers, currentIndex);
                if (refIndex >= 0) {
                    insertInto(numbers, currentIndex, refIndex);
                }
            }
        }
    }

    public static void selectionSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
                int refIndex = firstIndexOfSmallestNumber(numbers, currentIndex);
                exchange(numbers, currentIndex, refIndex);
            }
        }
    }

    public static void exchangeSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
                for (int higherIndex = currentIndex + 1; higherIndex < numbers.length; higherIndex++) {
                    if (numbers[currentIndex] > numbers[higherIndex]) {
                        exchange(numbers, currentIndex, higherIndex);
                    }
                }
            }
        }
    }
    
    public static void bubbleSort(int[] numbers) {
        throw new UnsupportedOperationException();
    }

    private static int firstIndexOfSmallestNumber(int[] numbers, int startAtIndex) {
        int refIndex = startAtIndex;
        for (int i = startAtIndex; i < numbers.length; i++) {
            if (numbers[refIndex] > numbers[i]) {
                refIndex = i;
            }
        }
        return refIndex;
    }

    private static int lowerIndexOfGreaterThanOrEqualNumber(int[] numbers, int currentIndex) {
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
        if (currentIndex != refIndex) {
            int current = numbers[currentIndex];
            numbers[currentIndex] = numbers[refIndex];
            numbers[refIndex] = current;
        }
    }
}
