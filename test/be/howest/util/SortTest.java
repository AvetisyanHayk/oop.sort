/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Hayk
 */
public class SortTest {
    private int[] numbers;
    private int[] hardSortedNumbers;
    
    @Before
    public void before() {
        numbers = new int[]{7, 5, 0, -44, 8, 240, 3, 1, 0, 5, -55, -79};
        hardSortedNumbers = new int[]{-79, -55, -44, 0, 0, 1, 3, 5, 5, 7, 8, 240};
    }
    
    @Test
    public void insertionSort_sorts_numbers_correctly() {
        assertArrayEquals(hardSortedNumbers, Sort.insertionSort(numbers));
    }
    
    @Test
    public void insertionSort_returns_null_if_input_array_is_null() {
        assertNull(Sort.insertionSort(null));
    }
    
    @Test
    public void selectionSort_sorts_numbers_correctly() {
        assertArrayEquals(hardSortedNumbers, Sort.selectionSort(numbers));
    }
    
    @Test
    public void selectionSort_returns_null_if_input_array_is_null() {
        assertNull(Sort.selectionSort(null));
    }
    
    @Test
    public void exchangeSort_sorts_numbers_correctly() {
        assertArrayEquals(hardSortedNumbers, Sort.exchangeSort(numbers));
    }
    
    @Test
    public void exchangeSort_returns_null_if_input_array_is_null() {
        assertNull(Sort.exchangeSort(null));
    }
}
