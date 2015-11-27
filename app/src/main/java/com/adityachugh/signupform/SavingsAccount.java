package com.adityachugh.signupform;// Created on 2015-11-27.

public class SavingsAccount
        extends BankAccount
{
    @Override
    public void withdraw(double amount)
    {
        if ( numberOfWithdrawals() >= 3 )
        {
            return;
        }
        super.withdraw(amount);
    }
}

