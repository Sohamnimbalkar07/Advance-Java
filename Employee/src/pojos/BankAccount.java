package pojos;

public class BankAccount {

	private int accId;
	private String name;
	private String acType;
	private double balance;
	
	public BankAccount(int accId, String name, String acType, double balance) {
		super();
		this.accId = accId;
		this.name = name;
		this.acType = acType;
		this.balance = balance;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accId=" + accId + ", name=" + name + ", acType=" + acType + ", balance=" + balance + "]";
	}
	
	
	
}
