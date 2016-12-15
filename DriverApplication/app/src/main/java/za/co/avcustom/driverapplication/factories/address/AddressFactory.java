package za.co.avcustom.driverapplication.factories.address;

import za.co.avcustom.driverapplication.domain.address.Impl.Address;

/**
 * Created by cfebruary on 2016/12/10.
 */
public class AddressFactory {
    public static Address getInstance(Long id, String streetNumber, String streetName, String suburb, String city, String postCode)
    {
        Address address = new Address.Builder()
                .id(id)
                .streetNumber(streetNumber)
                .streetName(streetName)
                .suburb(suburb)
                .city(city)
                .postCode(postCode)
                .build();

        return address;
    }
}
