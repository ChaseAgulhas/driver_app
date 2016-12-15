package za.co.avcustom.driverapplication.activities.registration;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import za.co.avcustom.driverapplication.R;
import za.co.avcustom.driverapplication.activities.login.LoginActivity;
import za.co.avcustom.driverapplication.domain.vehicle.Vehicle;

public class VehicleRegistrationActivity extends AppCompatActivity {

    private Button signUp;
    private EditText txtVehicleMake;
    private EditText txtVehicleModel;
    private EditText txtVehicleYear;
    private EditText txtVehicleRegistration;
    private String driverName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_registration);
        setControls();
        Bundle bundle = getIntent().getExtras();
        if(bundle == null)
        {
            return;
        }
        driverName = bundle.getString("DriverName");
    }

    public void onBtnCompleteSignUpClick(View view)
    {
        new RegisterVehicle().execute();
    }

    private void setControls()
    {
        signUp = (Button)findViewById(R.id.btnCompleteSignUp);
        txtVehicleMake = (EditText)findViewById(R.id.editVehicleMake);
        txtVehicleModel = (EditText)findViewById(R.id.editVehicleModel);
        txtVehicleYear = (EditText)findViewById(R.id.editVehicleYear);
        txtVehicleRegistration = (EditText)findViewById(R.id.editVehicleRegistration);
    }

    private class RegisterVehicle extends AsyncTask<Void,Void,Vehicle>
    {
        Vehicle vehicle = new Vehicle();
        @Override
        protected void onPreExecute() {
            vehicle.setMake(txtVehicleMake.getText().toString());
            vehicle.setModel(txtVehicleModel.getText().toString());
            vehicle.setYear(txtVehicleYear.getText().toString());
            vehicle.setRegistrationNumber(txtVehicleRegistration.getText().toString());
            vehicle.setOwner(driverName);
        }

        @Override
        protected Vehicle doInBackground(Void... params) {
            try{
                final String url = "http://0.0.0.0:8080/api/vehicles";
                RestTemplate restTemplate = new RestTemplate();

                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                HttpEntity<Vehicle> request = new HttpEntity<>(vehicle);

                return restTemplate.postForObject(url, request, Vehicle.class);
            }
            catch (HttpClientErrorException vehicleRegistrationError){
                System.out.println("SEND OR RECEIVE ERROR: " + vehicleRegistrationError);
            }
            catch(Exception e){
                System.out.println("OTHER ERROR: " + e);
            }

            return vehicle;
        }

        @Override
        protected void onPostExecute(Vehicle vehicle) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
