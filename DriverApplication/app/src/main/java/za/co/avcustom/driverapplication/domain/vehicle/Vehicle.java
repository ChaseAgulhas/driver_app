package za.co.avcustom.driverapplication.domain.vehicle;

import java.io.Serializable;

/**
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso
 * Description:
 */

public class Vehicle implements Serializable
{
    private long id;
    private String make;
    private String model;
    private String year;
    private String registrationNumber;
    private String owner;

    public Vehicle() {
    }
    public Vehicle(Builder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.registrationNumber = builder.registrationNumber;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static class Builder
    {
        private String make;
        private String model;
        private String year;
        private String registrationNumber;

        public  Builder make(String value)
        {
            this.make = value;
            return this;
        }

        public  Builder model(String value)
        {
            this.model = value;
            return this;
        }

        public  Builder year(String value)
        {
            this.year = value;
            return this;
        }

        public  Builder registrationNumber(String value)
        {
            this.registrationNumber = value;
            return this;
        }

        public Builder copy(Vehicle value)
        {
            this.make = value.make;
            this.model = value.model;
            this.year = value.year;
            this.registrationNumber = value.registrationNumber;
            return this;
        }

        public Vehicle build()
        {
            return new Vehicle();
        }
    }
}
