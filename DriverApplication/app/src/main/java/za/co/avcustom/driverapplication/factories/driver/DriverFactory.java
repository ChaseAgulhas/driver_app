package za.co.avcustom.driverapplication.factories.driver;

import za.co.avcustom.driverapplication.domain.driver.Driver;

/**
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso
 * Description:
 */

public class DriverFactory
{
    public static Driver getDriver(long id, String name,String surname,String cellphoneNumber,String email, String password, byte[] profile, boolean loggedIn)
    {
        Driver driver = new Driver.Builder()
                .id(id)
                .name(name)
                .surname(surname)
                .cellPhoneNumber(cellphoneNumber)
                .email(email)
                .password(password)
                .profilePhoto(profile)
                .loggedIn(loggedIn)
                .build();

        return driver;
    }
}
