package za.co.avcustom.driverapplication.activities.registration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;

import za.co.avcustom.driverapplication.R;
import za.co.avcustom.driverapplication.domain.driver.Driver;

public class RegistrationActivity extends AppCompatActivity {

    private Button btnNext;
    private Button btnTakePhoto;
    private EditText txtName;
    private EditText txtSurname;
    private EditText txtCellNumber;
    private EditText txtEmail;
    private EditText txtPassword;
    private byte[] profilePhoto;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setControls();
    }

    public void onBtnNextVehicleDetailsClick(View view)
    {
        new RegisterDriver().execute();
    }

    public void onBtnTakePhotoClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if((requestCode == REQUEST_IMAGE_CAPTURE ) && (resultCode == RESULT_OK))
        {
            Bundle getImage = data.getExtras();
            Bitmap photo =  (Bitmap) getImage.get("data");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            if (photo != null) {
                photo.compress(Bitmap.CompressFormat.PNG,100,outputStream);
            }
            profilePhoto = outputStream.toByteArray();
        }
    }

    private void setControls()
    {
        btnNext = (Button)findViewById(R.id.btnNextVehicleDetails);
        btnTakePhoto = (Button)findViewById(R.id.btnTakePhoto);
        txtName = (EditText)findViewById(R.id.editDriverName);
        txtSurname = (EditText)findViewById(R.id.editDriverSurname);
        txtCellNumber = (EditText)findViewById(R.id.editDriverCellNumber);
        txtEmail = (EditText)findViewById(R.id.editDriverEmail);
        txtPassword = (EditText)findViewById(R.id.editDriverPassword);
    }

    private class RegisterDriver extends AsyncTask<Void,Void,Void>
    {
        Driver driver = new Driver();
        @Override
        protected void onPreExecute() {
            driver.setName(txtName.getText().toString()); // Save to DB as text
            driver.setSurname(txtSurname.getText().toString()); // Save to DB as text
            driver.setCellPhoneNumber(txtCellNumber.getText().toString()); // Save to DB as text
            driver.setEmail(txtEmail.getText().toString()); //Save as DB as text
            driver.setPassword(txtPassword.getText().toString()); // Save to DB as text
            driver.setProfilePhoto(profilePhoto); // Save to DB as BLOB
        }

        @Override
        protected Void doInBackground(Void... params) {
            return null;

            /**
             * TODO Add code to insert driver into database
             */
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent = new Intent(getApplicationContext(),VehicleRegistrationActivity.class);
            intent.putExtra("DriverName",driver.getName() + " " + driver.getSurname());
            startActivity(intent);
        }
    }

}
