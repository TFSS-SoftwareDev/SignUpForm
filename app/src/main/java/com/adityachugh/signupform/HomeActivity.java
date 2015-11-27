package com.adityachugh.signupform;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HomeActivity extends Activity
{

    public static final String EXTRA_KEY = "Extra";

    private TextView welcomeText;

    EditText mAmountInput;
    Button m_DepositButton;
    Button mWithdrawButton;
    TextView mAmountDisplay;
    BankAccount mCurrentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        welcomeText = (TextView)findViewById(R.id.welcome_text);



        User currentUser = (User)getIntent().getSerializableExtra(EXTRA_KEY);
        String username = currentUser.getUsername();

//        welcomeText.setText("Balance: " + balance);
        Log.d("HomeActivity", username);


        mCurrentAccount = new CheckingAccount();
        mAmountDisplay = (TextView) findViewById(R.id.amount_display);
        mAmountInput = (EditText) findViewById(R.id.input_amount);
        m_DepositButton = (Button) findViewById(R.id.deposit_button);
        mWithdrawButton = (Button) findViewById(R.id.withdraw_button);

        mWithdrawButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String amount = mAmountInput.getText().toString();
                changeBalance(amount);
            }
        });


        m_DepositButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String amount = mAmountInput.getText().toString();
                changeBalance(amount);

            }
        });
    }

    private void changeBalance(String amount)
    {
        if ( Double.parseDouble(amount) != 0 )
        {
            mCurrentAccount.deposit(Double.parseDouble(amount));
            mAmountDisplay.setText("Balance is $" + mCurrentAccount.getBalance());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
