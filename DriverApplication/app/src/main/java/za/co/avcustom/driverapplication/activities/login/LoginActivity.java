package za.co.avcustom.driverapplication.activities.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import za.co.avcustom.driverapplication.R;
import za.co.avcustom.driverapplication.activities.registration.RegistrationActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText txtUsername;
    private EditText txtPassword;
    private Button login;
    private Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setControls();
        getLoginDetails();
    }

    public void onBtnLoginClick(View view) {
        if((txtUsername.getText().toString().equalsIgnoreCase("")) || (txtPassword.getText().toString().equalsIgnoreCase("")))
        {
            Toast.makeText(this,"Username and password may not be blank",Toast.LENGTH_LONG).show();
        }
        saveLoginInfo();
    }

    public void onBtnSignUpClick(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    private void setControls()
    {
        txtUsername = (EditText)findViewById(R.id.editTextEmail);
        txtPassword = (EditText)findViewById(R.id.editTextPassword);
        login = (Button)findViewById(R.id.btnLogin);
        signup = (Button)findViewById(R.id.btnSignUp);
    }

    private void saveLoginInfo()
    {
        SharedPreferences preferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username",txtUsername.getText().toString());
        editor.apply();
    }

    private void getLoginDetails()
    {
        SharedPreferences preferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String username = preferences.getString("username","");
        txtUsername.setText(username);
    }

    private class CheckLoginDetails extends AsyncTask<Void,Void,Void>
    {
        private String username;
        private String password;
        @Override
        protected void onPreExecute() {
            username = txtUsername.getText().toString();
            password = txtPassword.getText().toString();
        }

        @Override
        protected Void doInBackground(Void... params) {
            return null;
            /**
             * TODO Add code to check login details
             */
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            /**
             * TODO if login successful go to main menu
             */
        }
    }
}
