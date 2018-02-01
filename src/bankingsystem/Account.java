/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 *
 * @author 123
 */
public class Account {
    int accountId;
    int memberId;    
    String accountType;
    double balance;
    
    public Account() {
        accountId = 0;
        memberId = 0;        
        accountType = "";
        balance = 0.00;
    }

    public Account(int accountId, int memberId, String accountType, double balance) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }   

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", memberId=" + memberId + ", accountType=" + accountType + ", balance=" + balance + '}';
    }
}
