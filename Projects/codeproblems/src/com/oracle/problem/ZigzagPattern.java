package com.oracle.problem;

public class ZigzagPattern {

	private static int[][] twoDArr;

	public static void main(String[] args) {
		fillPattern(10, 10);
		printZigZag(10, 10);
	}

	public static void fillPattern(int m, int n) {
		int j = 0;
		int cnt = 0;
		twoDArr = new int[m][n];
		while (cnt <= m * n) {
			for (int i = 0; i < n; i++) {
				twoDArr[j][i] = ++cnt;
				System.out.println("(" + j + "," + i + ") " + twoDArr[j][i]
						+ " ");
			}
			j++;
			if(cnt == m*n)
				break;
		}
	}

	public static void printZigZag(int m, int n) {
		int size = m * n;
		int printed = 0;
		int x = 0;
		System.out.println("ZIGZAG");
		
		while (printed < size) {
			for (int i = 0; i < n; i++) {
				System.out.println(twoDArr[x][i] + " ");
				printed++;
				if (i == n - 1) {
					if (printed == size) {
						break;
					}
					System.out.println(twoDArr[x + 1][i] + " ");
					printed = printed + n;
					x = x + 2;
				}
			}

			if (printed == size) {
				break;
			}

			for (int j = n - 1; j >= 0; j--) {
				System.out.println(twoDArr[x][j]);
				printed++;
				if (j == 0) {
					if (printed == size) {
						break;
					}
					System.out.println(twoDArr[x + 1][j] + " ");
					printed = printed + n;
					x = x + 2;
				}
			}
		}
	}
  }
