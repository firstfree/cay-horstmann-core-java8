package ch05.exercise.problem04;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FloatingPointReader {
	
	public enum ResultCode {
		SUCCESS,
		INVALID_FILE,
		INVALID_FORMAT
	}
	
	public ResultCode readValues(String filename, ArrayList<Double> values) {
		try (Scanner in = new Scanner(Paths.get(filename))) {
			while (in.hasNext()) {
				values.add(in.nextDouble());
			}
		} catch (IOException e) {
			return ResultCode.INVALID_FILE;
		} catch (InputMismatchException e) {
			return ResultCode.INVALID_FORMAT;
		}
		
		return ResultCode.SUCCESS;
	}
	
	public ResultCode sumOfValues(String filename, ArrayList<Double> values) {
		ResultCode resultCode = readValues(filename, values);
		if (resultCode != ResultCode.SUCCESS) {
			return resultCode;
		}
		
		double sum = 0;
		for (double value : values) {
			sum += value;
		}

		values.add(sum);
		
		return resultCode;
	}
	
	public static void main(String[] args) {
		FloatingPointReader in = new FloatingPointReader();
		ArrayList<Double> values = new ArrayList<>();
		ResultCode resultCode = in.sumOfValues("floatingpoint.txt", values);
		if (resultCode == ResultCode.SUCCESS) {
			System.out.println(values.get(values.size() - 1));
		} else {
			System.out.println(resultCode);
		}
	}
}
