package bankingapplication;
import java.util.*;
public class BankAccount {
	String accountNumber;
	String accountHolderName;
	double balance;


	BankAccount(String accountNumber,String accountHolderName,double balance){
		this.accountNumber=accountNumber;
		this.accountHolderName=accountHolderName;
		this.balance=balance;
	}
	void deposit(double amount) {
		balance+=amount;
		System.out.println("The amount add is "+ amount);
		System.out.println("The new balance is "+ balance);
		
	}
	void withdraw(double amount) {
		if(amount<=balance) {
			balance-=amount;
			System.out.println("The withdraw amount is"+ amount);
			System.out.println("The new balance is " + balance);
		}
		else {
			System.out.println("Insufficent balance!");
		}
	}
	void displayAccountInfo() {
		System.out.println("AccountNumber :"+ accountNumber);
		System.out.println("Account Holder Name :" + accountHolderName);
		System.out.println("Balance :"+ balance);
	}
	
}

class Bank{
	ArrayList<BankAccount> accounts;
	
	Bank(){
		accounts = new ArrayList<>(); 
	}
	
	void addAccount(BankAccount account) {
		accounts.add(account);
		System.out.println("The account is added for : "+account.accountHolderName);
	}
	
	BankAccount findAccount(String accountNumber) {
		for(BankAccount account :accounts) {
			if(account.accountNumber.equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}
	
	void displayAllAccounts() {
		for(BankAccount account:accounts) {
			account.displayAccountInfo();
		}
	}
	
	
	class main{
		public static void main(String args[]) {
			Scanner sc=new Scanner(System.in);
			Bank bank=new Bank();
			while(true) {
				System.out.println("Welcome to A-star bank");
				System.out.println("1. Add Account");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Display all Accounts");
				System.out.println("5. Exit");
				
				int  choice=sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter the account number");
					String accountNumber=sc.nextLine();
					sc.nextLine(); 
					System.out.println("Enter the account holder name");
					String accountHolderName=sc.nextLine();
					System.out.println("Enter the initial Balance");
					double balance=sc.nextDouble();
					sc.nextLine();
					BankAccount newAccount=new BankAccount(accountNumber,accountHolderName,balance);
					bank.addAccount(newAccount);
					break;
					
				case 2:
					System.out.println("Enter the account number ");
					accountNumber=sc.nextLine();
					 sc.nextLine(); 
					BankAccount account=bank.findAccount(accountNumber);
					if(account!=null) {
						System.out.println("Enter amount to Deposit");
						double depositAmount=sc.nextDouble();
						sc.nextLine();
						account.deposit(depositAmount);
					}
					else {
						System.out.println("Account  not found!");
					}
					break;
					
				case 3:
					System.out.println("Enter the account number");
					accountNumber=sc.nextLine();
					 sc.nextLine(); 
					account=bank.findAccount(accountNumber);
					if(account!=null) {
						System.out.println("Enter the amount to withdraw");
						double withdrawAmount=sc.nextDouble();
						sc.hasNextLine();
						account.withdraw(withdrawAmount);
					}
					else {
						System.out.println("Account not found!");
					}
					break;
					
				case 4:
					bank.displayAllAccounts();
					break;
				
				case 5:
					System.out.println("Exiting.............");
					sc.close();
					return;
					
					default:
						System.out.println("Invalid choice!!!!!!!!!!");
				
				}
					
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}