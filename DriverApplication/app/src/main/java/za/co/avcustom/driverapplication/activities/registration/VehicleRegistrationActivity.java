package za.co.avcustom.driverapplication.activities.registration;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    private class RegisterVehicle extends AsyncTask<Void,Void,Void>
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
        protected Void doInBackground(Void... params) {
            /**
             * TODO Add code to insert driver into database
             */
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
