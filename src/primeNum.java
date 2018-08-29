
public class primeNum {

	public static void main(String[] args)
	{
		System.out.println("Your number is: " + randPrime(0, 100));
	}
	
	public static int randPrime(int start, int end)
	{
		int randPrime = (int)(Math.random() * (end-start) + start);
		return randPrime;
	}
}
