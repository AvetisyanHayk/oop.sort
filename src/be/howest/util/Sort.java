package be.howest.util;

/**
 *
 * @author Hayk
 */
public final class Sort {

    private Sort() {
    }

    // <editor-fold desc="Insertion Sort" defaultstate="collapsed">
    public static void insertionSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            for (int currentIndex = 1; currentIndex < numbers.length; currentIndex++) {
                int refIndex = lowestIndexOfGreaterThanOrEqualNumber(numbers, currentIndex);
                if (refIndex >= 0) {
                    insertInto(numbers, currentIndex, refIndex);
                }
            }
        }
    }

    private static int lowestIndexOfGreaterThanOrEqualNumber(int[] numbers, int currentIndex) {
        for (int lowerIndex = 0; lowerIndex < currentIndex; lowerIndex++) {
            if (numbers[currentIndex] <= numbers[lowerIndex]) {
                return lowerIndex;
            }
        }
        return -1;
    }

    private static void insertInto(int[] numbers, int currentIndex, int refIndex) {
        int current = numbers[currentIndex];
        for (int i = currentIndex; i > refIndex; i--) {
            swap(numbers, i - 1, i);
        }
        numbers[refIndex] = current;
    }
    // </editor-fold>

    // <editor-fold desc="Selection Sort" defaultstate="collapsed">
    public static void selectionSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            for (int currentIndex = 0; currentIndex < numbers.length - 1; currentIndex++) {
                int refIndex = higherIndexOfSmallestOrEqualNumber(numbers, currentIndex);
                if (currentIndex != refIndex) {
                    swap(numbers, currentIndex, refIndex);
                }
            }
        }
    }

    private static int higherIndexOfSmallestOrEqualNumber(int[] numbers, int startAtIndex) {
        int refIndex = startAtIndex;
        for (int i = startAtIndex + 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[refIndex]) {
                refIndex = i;
            }
        }
        return refIndex;
    }
    // </editor-fold>

    // <editor-fold desc="Exchange Sort" defaultstate="collapsed">
    public static void exchangeSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            for (int currentIndex = 0; currentIndex < numbers.length - 1; currentIndex++) {
                for (int higherIndex = currentIndex + 1; higherIndex < numbers.length; higherIndex++) {
                    if (numbers[currentIndex] > numbers[higherIndex]) {
                        swap(numbers, currentIndex, higherIndex);
                    }
                }
            }
        }
    }
    // </editor-fold>

    // <editor-fold desc="Bubble Sort" defaultstate="collapsed">
    public static void bubbleSort(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int currentIndex = 0; currentIndex < numbers.length - 1; currentIndex++) {
                    if (numbers[currentIndex] > numbers[currentIndex + 1]) {
                        swap(numbers, currentIndex, currentIndex + 1);
                        swapped = true;
                    }
                }
            }
        }
    }
    // </editor-fold>

    // <editor-fold desc="Quick Sort" defaultstate="collapsed">
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
    // </editor-fold>

    private static void swap(int[] numbers, int currentIndex, int refIndex) {
        if (currentIndex != refIndex) {
            int current = numbers[currentIndex];
            numbers[currentIndex] = numbers[refIndex];
            numbers[refIndex] = current;
        }
    }
}
