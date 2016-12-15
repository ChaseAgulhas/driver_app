package za.co.avcustom.driverapplication.factories.user;

import za.co.avcustom.driverapplication.domain.user.Impl.Customer;

/**
 * Created by cfebruary on 2016/12/10.
 */
public class CustomerFactory {
    public static Customer getInstance(Long customerId, String name, String surname, String email, String phoneNumber)
    {
        Customer customer = new Customer.Builder()
                .customerId(customerId)
                .name(name)
                .surname(surname)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
        return customer;
    }
}
