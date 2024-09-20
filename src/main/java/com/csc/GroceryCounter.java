package com.csc;

public class GroceryCounter {
    private int tens;
    private int ones;
    private int tenths;
    private int hundredths;
    private int overflowCount;
    private final int maxCounter;  // Mark maxCounter as final

    // Constructor initializes the counter to 0000 and the overflow count to 0
    public GroceryCounter() {
        this.tens = 0;
        this.ones = 0;
        this.tenths = 0;
        this.hundredths = 0;
        this.overflowCount = 0;
        this.maxCounter = 9999; // Default max value
    }

    // Customized Increment method to increment the counter by an arbitrary value
    public void increment(int value) {
        // Calculate the current counter in hundredths
        int totalHundredths = (tens * 1000) + (ones * 100) + (tenths * 10) + hundredths;
        
        // Add the increment value
        totalHundredths += value;

        // Handle overflow
        while (totalHundredths > maxCounter) {
            overflowCount++;
            totalHundredths -= (maxCounter + 1); // Reset counter to zero after overflow
        }

        // Update digits based on the new total value
        tens = (totalHundredths / 1000) % 10;
        ones = (totalHundredths / 100) % 10;
        tenths = (totalHundredths / 10) % 10;
        hundredths = totalHundredths % 10;
    }

    // Method to return the total amount as a formatted string
    public String total() {
        return String.format("$%d%d.%d%d", tens, ones, tenths, hundredths);
    }

    // Method to return the number of overflows
    public int number_of_overflows() {
        return overflowCount;
    }

    // Method to clear the counter and reset the overflow count
    public void clear() {
        this.tens = 0;
        this.ones = 0;
        this.tenths = 0;
        this.hundredths = 0;
        this.overflowCount = 0;
    }
}