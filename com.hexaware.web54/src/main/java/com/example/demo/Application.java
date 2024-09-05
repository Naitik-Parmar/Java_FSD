package com.example.demo;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.BankRepo.BankRepository;
import com.example.demo.Entities.Bank;

@SpringBootApplication
public class Application {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ApplicationContext  context = SpringApplication.run(Application.class, args);
		
		BankRepository repo = context.getBean(BankRepository.class);
		
		
		Application app = new Application();
		
    	while(true) {
    		System.out.println("1. To Open Account");
    		System.out.println("2. To Deposit");
    		System.out.println("3. To Withdraw");
    		System.out.println("4. To Search Account");
    		System.out.println("5. To Close Account");
    		System.out.println("6. Show All Accounts");
    		System.out.println("7. To Tranfer Amount");
    		System.out.println("0. To Exit");
    		int ch = sc.nextInt();
    		if(ch==1) {
    			app.openAccount(repo);;
    		}
    		else if(ch==2) {
    			app.deposit(repo);
    		}
    		else if(ch==3) {
    			app.withdraw(repo);
    		}
    		else if(ch==4) {
    			app.search(repo);
    		}
    		else if(ch==5) {
    			app.closeAccount(repo);
    		}
    		else if(ch==6) {
    			app.showAll(repo);
    		}
    		else if(ch==7) {
    			app.transferAmount(repo);
    		}
    		else if(ch==0){
    			break;
    		}
        System.out.println( "Welcome" );
    }
		
		System.out.println("Thank You For Using Banking System...");
	}
	
	public void openAccount(BankRepository repo) {
		 Bank bank = new Bank();
		    
		    System.out.println("Enter Account Number");
		    int accNo = sc.nextInt();
		    bank.setAccNo(accNo);
		    
		    sc.nextLine(); 
		    
		    System.out.println("Enter Full Name:");
		    String name = sc.nextLine();
		    bank.setName(name);
		    
		    System.out.println("Enter Balance (Minimum 1000)");
		    double balance = sc.nextDouble();
		    
		    if (balance >= 1000) {
		        bank.setBalance(balance);
		        
		        sc.nextLine(); 
		        
		        System.out.println("Enter Email:");
		        String email = sc.nextLine();
		        bank.setEmail(email);
		        
		        repo.save(bank);
		        System.out.println("Account Saved Successfully");
		    } else {
		        System.out.println("Balance Cannot be less than 1000");
		    }
	}

	public void deposit(BankRepository repo) {
		System.out.println("Enter Account for Deposit :: ");
		int accNo = sc.nextInt();
		Optional<Bank> b = repo.findById(accNo);
		if(b.isPresent()) {
			Bank temp = b.get();
			System.out.println("Enter Amount to deposit");
			double balance = sc.nextDouble();
			temp.setBalance(balance+temp.getBalance());
			repo.save(temp);
			System.out.println("Deposit Successfull !!");
		}
		else {
			System.out.println("Bank Account Not Found !!");
		}
	}
	
	public void withdraw(BankRepository repo) {
		System.out.println("Enter Account to Withdraw :: ");
		int accNo = sc.nextInt();
		Optional<Bank> b = repo.findById(accNo);
		if(b.isPresent()) {
			Bank temp = b.get();
			if(temp.getBalance()>0) {
				System.out.println("Enter Amount to withdraw");
				double balance=sc.nextDouble();
				if(temp.getBalance()>balance) {
					temp.setBalance(temp.getBalance()-balance);
					repo.save(temp);
					System.out.println("Withdraw Successfull !!");
				}
				else {
					System.out.println("Not Sufficient Balance");
				}
			}
		}else {
			System.out.println("Bank Account Not Found !!");
		}
	}
	
	public void search(BankRepository repo) {
		System.out.println("Enter AccountNo to Search :: ");
		int accNo = sc.nextInt();
		Optional<Bank> b = repo.findById(accNo);
		if(b.isPresent()) {
			Bank temp = b.get();
			System.out.println(temp.toString());
		}
		else {
			System.out.println("Bank Account Not Found !!");
		}
	}
	
	public void closeAccount(BankRepository repo) {
		System.out.println("Enter AccountNo to Close :: ");
		int accNo = sc.nextInt();
		Optional<Bank> b = repo.findById(accNo);
		if(b.isPresent()) {
			repo.deleteById(accNo);
			System.out.println("Account Closed");
		}
		else {
			System.out.println("Bank Account Not Exist !!");
		}
	}
	public void showAll(BankRepository repo) {
		Iterable<Bank> b = repo.findAll();
		b.forEach((t) -> System.out.println(t.toString()));
	}
	
	public void transferAmount(BankRepository repo) {

	    System.out.println("Enter Sender Account Number:");
	    int senderAccNo = sc.nextInt();
	    Optional<Bank> senderResult = repo.findById(senderAccNo);

	    if (senderResult.isPresent()) {
	        Bank sender = senderResult.get();

	        System.out.println("Enter Receiver Account Number:");
	        int receiverAccNo = sc.nextInt();
	        Optional<Bank> receiverResult = repo.findById(receiverAccNo);

	        if (receiverResult.isPresent()) {
	            Bank receiver = receiverResult.get();

	            System.out.println("Enter Amount to Transfer:");
	            double amount = sc.nextDouble();

	            if (sender.getBalance() >= amount) {
	                sender.setBalance(sender.getBalance() - amount);
	                receiver.setBalance(receiver.getBalance() + amount);

	                repo.save(sender);
	                repo.save(receiver);

	                System.out.println("Transfer successful.... Updated Balances:");
	                System.out.println("Sender Balance: " + sender.getBalance());
	                System.out.println("Receiver Balance: " + receiver.getBalance());
	            } else {
	                System.out.println("Insufficient balance in the sender's account.");
	            }
	        } else {
	            System.out.println("Receiver Account Not Found!");
	        }
	    } else {
	        System.out.println("Sender Account Not Found!");
	    }
	}
}
