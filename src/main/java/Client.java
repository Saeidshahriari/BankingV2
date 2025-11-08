import java.util.ArrayList;
import java.util.List;

public class Client {
    private int age;
    private String name;
    private int IDnumber;
    private String address;
    private List<BankAccount> accounts;

    private int bankID;

    private int pin;

    public Client(String name, int age, int IDnumber, String address){
        /***
         Constructor
         ***/
        this.name = name;
        this.age = age;
        this.IDnumber = IDnumber;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount){
        /***
         Add an account to the user
         ***/
        if (bankAccount == null)
            return;
        if (!this.accounts.contains(bankAccount)) {
            this.accounts.add(bankAccount);
        }
    }

    public void removeAccount(BankAccount selectedAccount){
        /***
         Remove an account from the user, think of edge cases. Can you always remove an account?
         ***/
        if (selectedAccount == null)
            return;
        this.accounts.remove(selectedAccount);
    }

    public int getAge() {
        /***
         Getter
         ***/
        return this.age;
    }

    public String getName() {
        /***
         Getter
         ***/
        return this.name;
    }

    public List<BankAccount> getAccounts(){
        /***
         Getter
         ***/
        return this.accounts;
    }

    public void addBankID(int bankID) {
        /***
         Setter
         ***/
        this.bankID = bankID;
    }

    public int getBankID(){
        /***
         Getter
         ***/
        return this.bankID;
    }

    public void setPin(int pin){
        /***
         Setter
         ***/
        this.pin = pin;
    }

    public int getPin(){
        /***
         Getter
         ***/
        return this.pin;
    }
}
