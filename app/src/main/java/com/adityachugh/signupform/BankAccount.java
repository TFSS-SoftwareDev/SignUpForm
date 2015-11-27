package com.adityachugh.signupform;// Created on 2015-11-27.

import java.util.ArrayList;

public class BankAccount
{
    private ArrayList<Double> mTransactions;
    public static final double OVERDRAFT_FEE = 30;

    BankAccount()
    {
        mTransactions = new ArrayList<>();
    }

    public int numberOfWithdrawals()
    {
        int counter = 0;
        for ( int i = 0; i < mTransactions.size(); i++ )
        {
            if ( mTransactions.get(i) < 0 )
            {
                counter++;
            }
        }
        return counter;
    }

    public void withdraw(double amount)
    {

        mTransactions.add(-amount);
        if ( getBalance() < 0 )
        {
            mTransactions.add(-OVERDRAFT_FEE);
        }
    }

    public void deposit(double amount)
    {
        mTransactions.add(amount);
    }

    public double getBalance()
    {
        double total = 0;
        for ( int i = 0; i < mTransactions.size(); i++ )
        {
            total += mTransactions.get(i);
        }
        return total;
    }
}
