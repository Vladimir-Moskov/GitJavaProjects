package concurrency.synchronization;

public class Main {
	
	
	public static void main(String[] args) {
		Cinema cinema=new Cinema();
		
		TicketOffice1 ticketOffice1=new TicketOffice1(cinema);
		Thread thread1 = new Thread(ticketOffice1,"TicketOffice1");
		
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2,"TicketOffice2");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
		System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
	}
	
	public static void main_1(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		System.out.printf("Account : Initial Balance: %f\n", account.getBalance());

		companyThread.start();
		bankThread.start();
		
		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account : Final Balance: %f\n", account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
