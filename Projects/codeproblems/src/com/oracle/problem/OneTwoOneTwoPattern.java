package com.oracle.problem;

public class OneTwoOneTwoPattern 
{
/**
 *  1    
   212   
  32123  
 4321234 
543212345
 * @param args
 */
	public static void main(String[] args) 
	{
		int n=5;
		for(int i=1;i<=n;i++)
		{
			int l=i;
			for(int j=n;j>=1;j--)
			{
				if(j<=n && j>i)
				{
					System.out.print(" ");
				}
				else
				{
				 System.out.print(l);
				 l--;
				}
			}
			
			for(int k=1;k<n;k++)
			{
				if(k<i)
				{
					System.out.print(k+1);
				}
				else
				{
				 System.out.print(" ");	
				}
			}
			System.out.print("\n");
		}
	}
}
