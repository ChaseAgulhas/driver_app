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

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import za.co.avcustom.driverapplication.R;
import za.co.avcustom.driverapplication.activities.navigationmenu.MainMenuActivity;
import za.co.avcustom.driverapplication.activities.registration.RegistrationActivity;
import za.co.avcustom.driverapplication.domain.user.Impl.Login;
import za.co.avcustom.driverapplication.factories.user.LoginFactory;

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
        else{
            setControls();
            Login[] response = validateCredentials();
            if(response.length > 0)
            {
                Intent intent = new Intent(view.getContext(), MainMenuActivity.class);
                intent.putExtra("username", response[0].getUsername());
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Invalid login details.", Toast.LENGTH_LONG).show();
            }
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

    public Login[] validateCredentials(){
        Login[] response = new Login[0];
        try{
            response = new CheckLoginDetails().execute().get();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        catch(ExecutionException e){
            e.printStackTrace();
        }
        return response;
    }

    private class CheckLoginDetails extends AsyncTask<Void,Void,Login[]>
    {
        private String username;
        private String password;
        @Override
        protected void onPreExecute() {
            username = txtUsername.getText().toString();
            password = txtPassword.getText().toString();
        }

        @Override
        protected Login[] doInBackground(Void... params) {
            Login login = LoginFactory.getInstance(username, password);
            Login[] userLoggedIn = new Login[1];

            try{
                final String url = "http://0.0.0.0:8080/api/users/verify/{email}/{password}";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                HashMap<String, String> map = new HashMap<String, String>(2);
                map.put("username", username);
                map.put("password", password);
                ResponseEntity<Login> loginResponseEntity = restTemplate.postForEntity(url, null, Login.class, map);

                return restTemplate.getForObject(url, Login[].class, map);
            }
            catch (HttpClientErrorException loginError){
                System.out.println("SEND/RECEIVE ERROR: " + loginError);
            }
            catch (Exception e){
                System.out.println("ERROR: " + e);
            }
            userLoggedIn[0] = login;
            return userLoggedIn;
        }
    }
}
