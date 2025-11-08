import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int uniqueIDAccounts = 0;
    private int uniqueIDClient = 0;
    private List<Client> clients;
    private Client currentClient = null;

    public Bank() {
	/***
	Constructor
	***/
	this.clients = new ArrayList<>();
    }

    public void addNewClient(Client client, int pin) {
	/***
	Add clients to the bank. What do you do when a client has already been added to the bank?
	***/
		if (client == null)
			return;
		int newId = ++uniqueIDClient;
		client.addBankID(newId);
		client.setPin(pin);
		this.clients.add(client);
    }

    public void logOut() {
    	/***
    	Log the current user out of the bank
    	***/
		this.currentClient = null;
    }

    public void logIn(int id, int pin) {
        /***
    	Log the current user in to the bank. What happens is someone is already logged in?
    	How do you validate if the user is indeed who they claim to be?
    	If the user is unable to provide the correct information, the following sentence should be displayed: 
    	"This user is not know to the bank, please check if you gave the correct ID and PIN!"
    	***/
		if (this.currentClient != null
				&& this.currentClient.getBankID() == id
				&& this.currentClient.getPin() == pin) {
			return;
		}
		if (currentClient == null) {
			logOut();
		}
		for (Client client : clients) {
			if (client.getBankID() == id && client.getPin() == pin){
				currentClient = client;
				return;
			}
		}
		System.out.print("This user is not know to the bank, please check if you gave the correct ID and PIN!");
    }

    public void addAccount(Client client, double amount) {
        /***
    	Add an account, if all input valid in this method?
    	***/
		if (client == null)
			return;
		if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <0)
			return;
		int newAccountId = ++uniqueIDAccounts;
		BankAccount acc = new BankAccount(newAccountId, amount);
		client.addAccount(acc);
    }

    public void removeAccount(BankAccount toRemove, BankAccount transferAccount) {
        /***
    	Remove an account, the user can transfer the money in the 'toRemove' account to the 'transferAccount'.
    	***/
		if (toRemove == null)
			return;

		if (transferAccount != null) {
			double remaining = toRemove.getBalance();
			if (remaining > 0) {
				transfer(toRemove, transferAccount, remaining);
			}
		}
		for (Client client : clients) {
			if (client.getAccounts().contains(toRemove)) {
				client.removeAccount(toRemove);
				break;
			}
		}
    }


    public void transfer(BankAccount transferFrom, BankAccount transferTo, double amount) {
        /***
    	Transfer from 'transferFrom' to 'TransferTo' with a given ammount?
    	Can anyone transfer, what with people that are not part of the bank?
    	***/
		if (transferFrom == null || transferTo == null)
			return;
		if (transferFrom == transferTo)
			return;
		if (amount <= 0)
			return;
		boolean fromInBank = false, toInBank = false;
		for (Client c : clients) {
			if (!fromInBank && c.getAccounts().contains(transferFrom)) fromInBank = true;
			if (!toInBank   && c.getAccounts().contains(transferTo))   toInBank = true;
			if (fromInBank && toInBank) break;
		}
		if (!fromInBank || !toInBank) {
			return;
		}
		if (transferFrom.canBeRemovedFromBalance(amount)) {
			transferFrom.removeFromBalance(amount);
			transferTo.addToBalance(amount);
		}
    }

    public void displayAccounts() {
        /***
    	Give a display to the user what accounts are associated with them.
    	Give info abouth the index (for easy access), the ID and the amount.
    	***/
		if (currentClient == null)
			return;
		System.out.println(currentClient.getAccounts());
		for (BankAccount acc : currentClient.getAccounts()) {
			System.out.println("ID=" + acc.getID() + ", balance=" + acc.getBalance());
		}
    }

    public int maxIDClient(){
        /***
    	Getter
    	***/
		int max = 0;
		for (Client client : clients) {
			if (client.getBankID() > max)
				max = client.getBankID();
		}
		return max;
    }

    public Client getCurrentClient(){
        /***
    	Getter
    	***/
		return currentClient;
    }

    public List<Client> getClients() {
        /***
	Getter    	
    	***/
		return clients;
    }

}
