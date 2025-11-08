public class BankAccount {

    private int uniqueID;
    private double balance;

    public BankAccount(int uniqueID, double amount){
        /***
        Constructor
        ***/
        this.balance = amount;
        this.uniqueID = uniqueID;
    }

    public void addToBalance(double amount){
        /***
         Add to an account
         ***/
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean canBeRemovedFromBalance(double amount){
        /***
         Check if the balance can be removed from an account
         ***/
        if(amount <=0)
            return false;
        return this.balance >= amount;
    }

    public void removeFromBalance(double amount){
        /***
         Remove from an account if the conditions are valid
         ***/
        if(canBeRemovedFromBalance(amount)){
            this.balance -= amount;
        }
    }

    public double getBalance() {
        /***
         Getter
         ***/
        return this.balance;
    }

    public int getID() {
        /***
         Getter
         ***/
        return this.uniqueID;
    }
}
