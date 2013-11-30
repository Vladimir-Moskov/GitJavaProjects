package concurrency;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PrimeGenerator extends Thread {

	public PrimeGenerator(){
		super();
	}
	 
	@Override
	public void run() {
		long number=1L;

		try {
			FileWriter file = new FileWriter("log_Demo.txt");
			PrintWriter pw = new PrintWriter(file);
			
			while (true) {
				if (isPrime(number)) {
					System.out.printf("Number %d is Prime \n", number);
					pw.printf("Number %d is Prime \n", number);
				}
				if (isInterrupted()) {
					System.out.printf("The Prime Generator has been	Interrupted \n");
					pw.printf("The Prime Generator has been	Interrupted \n");
					pw.close();
					return;
				}
					number++;
			}
			
		}
		catch(Exception error){
			System.out.println(error);
		}
	}
	
	private boolean isPrime(long number) {
		if (number <=2) {
			return true;
		}
		for (long i=2; i<number; i++){
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
