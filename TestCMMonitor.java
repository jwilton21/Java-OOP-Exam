package question2;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class TestCMMonitor {

	public static void main(String[] args) throws Exception {
		
		// Test constructor and toString.
		CMMonitor cmm1 = new CMMonitor(5);
		System.out.println(cmm1);
		
		// Test addReading.
		for(int i = 0; i < 5; i++) {
			System.out.println("Adding value " + (i+1) + " to CMMonitor.");
			cmm1.addReading(i+1);
		}
		System.out.println("Successfully added 5 numbers to CMMonitor which can only hold 5.");
		
		try {
			cmm1.addReading(6);
		}
		catch (RuntimeException e) {
			System.out.println("Adding 6th caused exception. Success.");
		}
		
		// Testing getReadingAt.
		for(int i = 0; i < 5; i++) {
			System.out.println(String.format("At index %d, expect %d . Actual value is %d.", i, i+1, cmm1.getReadingAt(i)));
		}
		
		// Testing sum.
		int answer = 1 + 2 + 3 + 4 + 5;
		System.out.println(String.format("Expected sum: %d Actual sum: %d", answer, cmm1.sumArray()));
		
		// Testing compliant.
		int[] eu_low = new int[]{1, 1, 1, 1, 1};
		int[] eu_mid = new int[]{4, 4, 4, 4, 4};
		int[] eu_high = new int[]{5, 5, 5, 5, 5};
		
		System.out.println(String.format("EU Low  - Expected: false Actual: %b",cmm1.isCompliant(eu_low)));
		System.out.println(String.format("EU Mid  - Expected: false Actual: %b",cmm1.isCompliant(eu_mid)));
		System.out.println(String.format("EU High - Expected: true  Actual: %b",cmm1.isCompliant(eu_high)));
		
		// Test recording and loading.
		cmm1.recordCMReading("cmm1_data.txt");
		
		CMMonitor cmm2 = new CMMonitor(5);
		cmm2.loadCMData("cmm1_data.txt");
		
		for(int i = 0; i < 5; i++) {
			if(cmm1.getReadingAt(i) != cmm2.getReadingAt(i)) {
				System.out.println("FAILED: loaded CMMonitor is different than recorded.");
			}
		}
		System.out.println("Recording and loading was successful.");
		
		try {
			CMMonitor cmm3 = new CMMonitor(3);
			cmm3.loadCMData("cmm1_data.txt");
		}catch (ValueException e) {
			System.out.println(e.getMessage());
			System.out.println("Success as exception thrown as expected when loading data into an object which cannot store it all.");
		}

	}

}
