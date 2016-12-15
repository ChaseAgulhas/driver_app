package za.co.avcustom.driverapplication.domain.user;

import junit.framework.Assert;

import org.junit.Test;

import za.co.avcustom.driverapplication.domain.user.Impl.Customer;

/**
 * Created by cfebruary on 2016/12/11.
 */
public class CustomerTest {
    @Test
    public void testCustomer()
    {
        IPerson customerTest = new Customer.Builder()
                .name("Name")
                .surname("Surname")
                .email("Email")
                .phoneNumber("Phone number")
                .build();

        Assert.assertNotNull(customerTest);
        Assert.assertEquals("Name", customerTest.getName());
        Assert.assertEquals("Surname", customerTest.getSurname());
        Assert.assertEquals("Email", customerTest.getEmail());
        Assert.assertEquals("Phone Number", customerTest.getPhoneNumber());
    }
}
