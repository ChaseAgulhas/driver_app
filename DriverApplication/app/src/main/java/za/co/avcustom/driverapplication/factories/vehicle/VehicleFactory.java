package za.co.avcustom.driverapplication.factories.vehicle;

import za.co.avcustom.driverapplication.domain.vehicle.Vehicle;
import za.co.avcustom.driverapplication.domain.vehicle.Vehicle.Builder;

/**
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso
 * Description:
 */

public class VehicleFactory
{
    public static Vehicle getVehicle(String make,String model,String year,String registrationNumber)
    {
        Vehicle vehicle = new Builder()
                .make(make)
                .model(model)
                .year(year)
                .registrationNumber(registrationNumber)
                .build();
        return vehicle;
    }
}
