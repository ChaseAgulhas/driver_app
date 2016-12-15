package za.co.avcustom.driverapplication.domain.user;

/**
 * Created by cfebruary on 2016/09/29.
 */
public interface IPerson {
    Long getCustomerId();
    String getName();
    String getSurname();
    String getEmail();
    String getPhoneNumber();
}
