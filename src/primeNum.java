/*
 * Note: recursion inside randPrime() function would cause stack overflow
 * so I had to go with something a bit messier. It works though.
 */

public class primeNum {

	public static void main(String[] args)
	{
		while(true)
		{
		try
			{
				System.out.println("Your number is: " + randPrime(0, 100));
				break;
			}
			catch (Exception e)
			{
				//do nothing lmao
			}
		}
	}
	
	public static int randPrime(int start, int end) throws Exception
	{
		
		boolean isPrime = true;
		int rand = (int)(Math.random() * (end-start) + start);
		
		//iterate through all numbers from 2 to the generated number
		for(int i = 2; i < rand; i++)
		{
			//if rand has a remainder of 0 when divided by any number, it is not prime
			if(rand % i == 0)
			{	
				isPrime = false;
			}
		}
		
		if(isPrime && rand >= 2)
		{
			return rand;
		}
		else
		{
			throw new Exception();
		}
	}
}
