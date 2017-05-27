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
                swap(numbers, currentIndex, refIndex);
            }
        }
    }

    public static void exchangeSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
                for (int higherIndex = currentIndex + 1; higherIndex < numbers.length; higherIndex++) {
                    if (numbers[currentIndex] > numbers[higherIndex]) {
                        swap(numbers, currentIndex, higherIndex);
                    }
                }
            }
        }
    }

    public static void bubbleSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            for (int stopAtIndex = numbers.length - 1; stopAtIndex > 0; stopAtIndex--) {
                for (int currentIndex = 0; currentIndex < stopAtIndex; currentIndex++) {
                    if (numbers[currentIndex] > numbers[currentIndex + 1]) {
                        swap(numbers, currentIndex, currentIndex + 1);
                    }
                }
            }
        }
    }

    public static void quickSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            quickSort(numbers, 0, numbers.length - 1);
        }
    }

    private static void quickSort(int[] numbers, final int startAtIndex, final int stopAtIndex) {
        if (startAtIndex < stopAtIndex) {
            int pivotIndex = orderNumbersTowardsPivotAndReturnPivotIndex(
                    numbers, startAtIndex, stopAtIndex);
            quickSort(numbers, startAtIndex, pivotIndex - 1);
            quickSort(numbers, pivotIndex + 1, stopAtIndex);
        }
    }
    
    private static int orderNumbersTowardsPivotAndReturnPivotIndex(int[] numbers, final int startAtIndex, final int stopAtIndex) {
        int pivot = numbers[stopAtIndex];
        int refIndex = startAtIndex;
        for (int i = startAtIndex; i < stopAtIndex; i++) {
            if (numbers[i] <= pivot) {
                swap(numbers, i, refIndex);
                refIndex++;
            }
        }
        swap(numbers, refIndex, stopAtIndex);
        return refIndex;
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
            swap(numbers, i - 1, i);
        }
        numbers[refIndex] = current;
    }

    private static void swap(int[] numbers, int currentIndex, int refIndex) {
        if (currentIndex != refIndex) {
            int current = numbers[currentIndex];
            numbers[currentIndex] = numbers[refIndex];
            numbers[refIndex] = current;
        }
    }
}
