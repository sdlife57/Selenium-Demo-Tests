// Java program to find the smallest 
// positive missing number 


public class Solution
	{public int solution(int[] A) {
		return 0;
	}

	/* Utility function that puts all non-positive 
	(0 and negative) numbers on left side of 
	arr[] and return count of such numbers */
	static int segregate (int A[], int size) 
	{ 
		int j = 0, i; 
		for(i = 0; i < size; i++) 
			System.out.println("i  equals "+ i);
		{ 
		/* reset i to avoid an out of bounds condition */
		if (i == size)
			i--;
					
			if (A[i] <= 0) 
			
		{ 
			int temp; 
			temp = A[i];
			System.out.println("temp equals "+ temp);
			A[i] = A[j]; 
			A[j] = temp; 
			// increment count of non-positive 
			// integers 
			j++; 
		} 
	}	
	
		return j; 
	} 
	
	/* Find the smallest positive missing 
	number in an array that contains 
	all positive integers */
	static int findMissingPositive(int A[], int size) 
	{ 
	int i; 
	
	// Mark A[i] as visited by making 
	// A[A[i] - 1] negative. Note that 
	// 1 is subtracted because index starts 
	// from 0 and positive numbers start from 1 
	for(i = 0; i < size; i++) 
	{ 
		int x = Math.abs(A[i]); 
		if(x - 1 < size && A[x - 1] > 0) 
		A[x - 1] = -A[x - 1]; 
	} 
	
	// Return the first index value at which i
	// is positive 
	for(i = 0; i < size; i++) 
	{
	    if (A[i] > 0) 
	    
		return i; // 1 is added because indexes 
					// start from 0 
	    System.out.println("A[i] equals "+ A[i]);	
	return size+1; 
	}
	System.out.println("i equals "+ i);
	return i; 
	}
	
	/* Find the smallest positive missing 
	number in an array that contains 
	both positive and negative integers */
	static int findMissing(int A[], int size) 
	{ 
	// First separate positive and 
	// negative numbers 
	int shift = segregate(A, size); 
	
	int A2[] = new int[size-shift]; 
	int j=0; 
	for(int i=shift;i<size;i++) 
		{ 
			A2[j] = A[i]; 
			j++; 
		}	 
	// Shift the array and call 
	// findMissingPositive for 
	// positive part 
	
	System.out.println("j  equals "+ j);
	return findMissingPositive(A2, j); 
	
	} 
	// main function 
	public static void main (String[] args) 
	{ 
		int A[] = {1,3,6,4,1,2}; 
		int A_size = A.length; 
		System.out.println("The size of array A is "+ A_size);
		int missing = findMissing(A, A_size); 
		int result = (new Solution()).solution ( A );
		System.out.println("The smallest positive missing number is "+ missing); 
		System.out.println("result  "+ result);
	} 
	}

	
	
