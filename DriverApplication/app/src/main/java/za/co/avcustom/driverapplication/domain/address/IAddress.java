package za.co.avcustom.driverapplication.domain.address;

/**
 * Created by cfebruary on 2016/11/26.
 */
public interface IAddress {
    Long getId();
    String getStreetNumber();
    String getStreetName();
    String getSuburb();
    String getCity();
    String getPostCode();
    String toString();
}
