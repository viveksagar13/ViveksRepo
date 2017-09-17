package com.coursera.dc;

public class WeightedQuickUnion {

	private int[] weightedQuickUnionArr;
	private int[] quickUnionSizeArr;

	public WeightedQuickUnion(int n)
	{
		weightedQuickUnionArr= new int[n];
		quickUnionSizeArr = new int[n];
		for(int i=0;i<n;i++)
		{
			weightedQuickUnionArr[i] = i;
			quickUnionSizeArr[i] = 1;
		}
	}
	
	public void printArr()
	{
		System.out.println("Printing arr:");
		for(int i=0;i<weightedQuickUnionArr.length;i++)
		{
			System.out.println(weightedQuickUnionArr[i]);
		}
	}
	
	public boolean isConnected(int x, int y) 
	{
		return root(x) == root(y);
	}

	public int root(int i) 
	{
		while (i != getWeightedQuickUnionArr()[i]) 
		{
			i = getWeightedQuickUnionArr()[i];
		}
		return i;
	}

	public void connect(int x, int y) 
 {
		int i = root(x);
		int j = root(y);

		if (quickUnionSizeArr[i] > quickUnionSizeArr[j]) 
		{
			getWeightedQuickUnionArr()[j] = i;
			quickUnionSizeArr[i] = quickUnionSizeArr[i] + quickUnionSizeArr[j];
		} 
		else 
		{
			getWeightedQuickUnionArr()[i] = j;
			quickUnionSizeArr[j] = quickUnionSizeArr[j] + quickUnionSizeArr[i];
		}
	}
	
	public static void main(String[] args) 
	{/*
		WeightedQuickUnion quickUnionObj = new WeightedQuickUnion();
		quickUnionObj.connect(0, 2); 
		quickUnionObj.connect(2, 4);
		quickUnionObj.connect(1, 5);
		quickUnionObj.connect(6, 9);
		for(int i=0;i<quickUnionObj.weightedQuickUnionArr.length;i++)
		{
			System.out.println(quickUnionObj.weightedQuickUnionArr[i]);
		}
		System.out.println(quickUnionObj.isConnected(0, 4));
		System.out.println(quickUnionObj.isConnected(0, 6));
		System.out.println(quickUnionObj.root(4));*/
	}

	private int[] getWeightedQuickUnionArr() {
		return weightedQuickUnionArr;
	}


}
