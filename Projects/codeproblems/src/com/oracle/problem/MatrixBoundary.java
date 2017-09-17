package com.oracle.problem;

import java.util.Scanner;

/**
 * Needs to be tested
 * @author vivek sagar
 *
 */
public class MatrixBoundary {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter the number of rows:");
			int row = scanner.nextInt();
			System.out.println("\nEnter the number of rows:");
			int column = scanner.nextInt();

			int[][] orignalArr = new int[row][column];
			int[][] traceArr = new int[row][column];
			int sumOfZero = 0;
			int sumOfOne = 0;
			for(int i=0;i<row;i++){
				for(int j=0;j<column;j++){
				 System.out.println("Enter the value for Matrix["+i+"]["+j+"]:");
				 orignalArr[i][j] = scanner.nextInt();
				 traceArr[i][j]=0;
				}
			}
			
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {

					if (traceArr[i][j] == 0) {
						if (orignalArr[i][j] == 0) {
							sumOfZero = sumOfZero
									+ countValidSides(i, j, orignalArr,
											traceArr, row, column);
						} else if (orignalArr[i][j] == 1) {
							sumOfOne = sumOfOne
									+ countValidSides(i, j, orignalArr,
											traceArr, row, column);
						}
					}
				}
			}
			System.out.println("Sum of all zeros: " + sumOfZero);
			System.out.println("Sum of all Ones:" + sumOfOne);
		}
		catch(Exception ex)
		{
			
		}
	}

	static int countValidSides(int rowNum, int colNum, int[][] originalArr,int[][] traceArr, int m, int n) {
		int sum = 0;
		if (traceArr[rowNum][colNum] == 1) {
			return 0;
		}

		traceArr[rowNum][colNum] = 1;

		if (colNum + 1 >= n)
			sum = sum + 1;
		if (rowNum + 1 >= m)
			sum = sum + 1;
		if (colNum - 1 < 0)
			sum = sum + 1;
		if (rowNum - 1 < 0)
			sum = sum + 1;
		
		if (       colNum + 1 < n
				&& rowNum < m
				&& colNum < n
				&& rowNum + 1 <m
				&& originalArr[rowNum][colNum] == originalArr[rowNum][colNum + 1]
				&& originalArr[rowNum][colNum] == originalArr[rowNum + 1][colNum]
				&& colNum - 1 >= 0
				&& rowNum - 1 >= 0
				&& colNum > 0
				&& rowNum > 0
				&& originalArr[rowNum][colNum] == originalArr[rowNum - 1][colNum]
				&& originalArr[rowNum][colNum] == originalArr[rowNum][colNum - 1]) {
			sum = sum + countValidSides(rowNum - 1, colNum, originalArr,traceArr, m, n)
					  + countValidSides(rowNum, colNum - 1, originalArr,traceArr, m, n)
					  + countValidSides(rowNum + 1, colNum, originalArr,traceArr, m, n)
					  + countValidSides(rowNum, colNum + 1, originalArr,traceArr, m, n);
		}
		if (colNum + 1 < n) {
			if (originalArr[rowNum][colNum] != originalArr[rowNum][colNum + 1]) {
				sum = sum + 1;
			} else {
				sum = sum+countValidSides(rowNum, colNum + 1, originalArr, traceArr, m, n);
			}
		}

		if (rowNum + 1 < m) {
			if (originalArr[rowNum][colNum] != originalArr[rowNum + 1][colNum]) {
				sum = sum + 1;
			} else {
				sum = sum+countValidSides(rowNum + 1, colNum, originalArr, traceArr, m, n);
			}
		}

		if (colNum - 1 >= 0
				&& originalArr[rowNum][colNum] != originalArr[rowNum][colNum - 1]) {
			if (originalArr[rowNum][colNum] != originalArr[rowNum][colNum - 1]) {
				sum = sum + 1;
			} else {
				sum = sum+countValidSides(rowNum, colNum - 1, originalArr, traceArr, m, n);
			}
		}

		if (rowNum - 1 >= 0) {
			if (originalArr[rowNum][colNum] != originalArr[rowNum - 1][colNum]) {
				sum = sum + 1;
			} else {
				sum = sum+countValidSides(rowNum - 1, colNum, originalArr, traceArr, m, n);
			}
		}
		return sum;
	}
}
