package za.co.avcustom.driverapplication.domain.driver;

import java.io.Serializable;

/**
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso
 * Description:
 */

public class Driver implements Serializable
{
    private long id;
    private String name;
    private String surname;
    private String cellPhoneNumber;
    private String email;
    private String password;
    private byte[] profilePhoto;
    private boolean loggedIn; //Maybe, depending how we validate if a user is logged in or not

    public Driver() {
    }

    public Driver(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.cellPhoneNumber = builder.cellPhoneNumber;
        this.email = builder.email;
        this.password = builder.password;
        this.profilePhoto = builder.profilePhoto;
        this.loggedIn = builder.loggedIn;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public byte[] getProfilePhoto()
    {
        return profilePhoto;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    public static class Builder
    {
        private long id;
        private String name;
        private String surname;
        private String cellPhoneNumber;
        private String email;
        private String password;
        private byte[] profilePhoto;
        private boolean loggedIn;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }

        public Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder surname(String value)
        {
            this.surname = value;
            return this;
        }

        public Builder cellPhoneNumber(String value)
        {
            this.cellPhoneNumber = value;
            return this;
        }

        public Builder email(String value)
        {
            this.email = value;
            return this;
        }

        public Builder password(String value)
        {
            this.password = value;
            return this;
        }

        public Builder profilePhoto(byte[] value)
        {
            this.profilePhoto = value;
            return this;
        }

        public Builder loggedIn(boolean value)
        {
            this.loggedIn = value;
            return this;
        }

        public Builder copy(Driver value)
        {
            this.id = value.id;
            this.name = value.name;
            this.surname = value.surname;
            this.cellPhoneNumber = value.cellPhoneNumber;
            this.email = value.email;
            this.password = value.password;
            this.profilePhoto = value.profilePhoto;
            this.loggedIn = value.loggedIn;
            return this;
        }

        public Driver build()
        {
            return new Driver(this);
        }
    }
}
