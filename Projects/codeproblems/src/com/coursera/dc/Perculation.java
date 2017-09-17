package com.coursera.dc;
/*
 * Perculation Problem Solution
 * You can use perculates() method to find if the system percualtes or not
 * Use open to open a grid with coordinates i and j. i and j starts with 1
 * 
 */
public class Perculation {
	
	private WeightedQuickUnion perculationImpl;
	private boolean[] isOpenedArr;
	private int matrixN;
	private int totalLocation;
	
	public Perculation(int N)
	{
		totalLocation = N*N;
		perculationImpl = new WeightedQuickUnion(totalLocation+1);
		isOpenedArr = new boolean[totalLocation+1];
		matrixN = N;
	}
	
	public void open(int i, int j)
	{
		int curLoc = findArrayLocation(i,j);
		
		if(!isOpenedArr[curLoc])
		{
			if(i>0 && i<=totalLocation)
			{
			 	int nextLoc = findArrayLocation(i, j+1);
			 	int prevLoc = findArrayLocation(i, j-1);
				if(( curLoc % matrixN !=0) && nextLoc<=totalLocation && isOpenedArr[nextLoc])
				{
					perculationImpl.connect(curLoc, nextLoc);	
				}
				if((curLoc % matrixN != 1) && prevLoc>=1 && isOpenedArr[prevLoc])
				{
					perculationImpl.connect(curLoc, prevLoc);
				}
			}
			else
			{
				System.out.println("Invalid input:"+i);
			}
		     
			
			if(j>0 && j<=totalLocation)
			{
				int downLoc = findArrayLocation(i+1, j);
			 	int upLoc = findArrayLocation(i-1, j);
			 	if(downLoc<=totalLocation && isOpenedArr[downLoc])
				{
					perculationImpl.connect(curLoc, downLoc);	
				}
				if(upLoc>=1 && isOpenedArr[upLoc])
				{
					perculationImpl.connect(curLoc, upLoc);
				}
			}
			else
			{
				System.out.println("Invalid input:"+j);
			}
			
			isOpenedArr[curLoc] = true; 
			
		}
		else
		{
			System.out.println("The location "+i+","+j+" is already open.");
		}
		
	}
	
	private int findArrayLocation(int i, int j) {
		return (matrixN*(i-1) + j) ;
	}

	public boolean isFilled(int i , int j)
	{
		int arrLoc = findArrayLocation(i,j);
		for(int y=1;y<=matrixN;y++)
		{
			if(perculationImpl.isConnected(arrLoc, y))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean doesPerculates()
	{
        for(int i=1;i<=matrixN;i++)
        {    
        	if(isFilled(matrixN,i))
            {
        		System.out.println("System perculates");
        	   return true;	
            }
        }
        System.out.println("System does not perculates");
		return false;
	}
	
	public static void main(String[] args) {
		Perculation perculation = new Perculation(3);
		perculation.perculationImpl.printArr();
		perculation.doesPerculates();
		perculation.open(1, 2);
		perculation.open(2, 2);
		perculation.open(3, 3);
		perculation.open(2, 3);
		perculation.doesPerculates();
		
	}
}
