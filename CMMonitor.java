package question2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.BufferOverflowException;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class CMMonitor {
	private int[] array;
	private final int ARRAY_SIZE;
	private int length = 0;
	
	
	public CMMonitor(int arraySize) {
		ARRAY_SIZE = arraySize;
		array = new int[arraySize];
	}
	
	public String toString() {
		return super.toString() + " Size: " + ARRAY_SIZE;
	}
	
	public void addReading(int reading) throws RuntimeException {
		if (this.length == ARRAY_SIZE) {
			throw new RuntimeException("Array is full.");
		}
		
		this.array[this.length] = reading;
		this.length = this.length + 1;
	}
	
	public int getReadingAt(int index) {
		if (index > this.length) {
			throw new IndexOutOfBoundsException();
		}
		
		return this.array[index];
	}
	
	public int sumArray() {
		int sum = 0;
		for(int i = 0; i < this.length; i++) {
			sum = sum + this.array[i];
		}
		return sum;
	}
	
	public boolean isCompliant(int[] euArray) {
		if(this.array.length != euArray.length)
			throw new ValueException("The arrays have different lengths.");
		
		for(int i = 0; i < this.array.length; i++) {
			if(this.array[i] > euArray[i])
				return false;
		}
		
		return true;
	}
	
	public void recordCMReading(String filename) throws IOException {
		Writer writer = new FileWriter(filename);
		
		String string = "";
		for(int i = 0; i < this.length; i++) {
			string = string + this.array[i] + " ";
		}
		string = string.trim();
		
		writer.write(string);
		writer.flush();
		writer.close();
	}
	
	public void loadCMData(String filename) throws IOException, FileNotFoundException, BufferOverflowException, ValueException {
		FileReader reader = new FileReader(filename);
		String string = "";
		
		int c = -1;
		while((c = reader.read()) != -1) {
			string = string + (char)c;
		}
		reader.close();
		
		String[] parts = string.split(" ");
		
		if(parts.length > this.ARRAY_SIZE) {
			throw new ValueException("Too many readings in file for this CMMonitor.");
		}
		
		this.array = new int[ARRAY_SIZE];
		this.length = 0;
		
		for(int i = 0; i < parts.length; i++) {
			this.addReading(Integer.parseInt(parts[i]));
		}
	}
	
}
