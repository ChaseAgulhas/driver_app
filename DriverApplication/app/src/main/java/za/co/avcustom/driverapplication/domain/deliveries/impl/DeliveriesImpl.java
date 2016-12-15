package za.co.avcustom.driverapplication.domain.deliveries.impl;

import java.io.Serializable;

import za.co.avcustom.driverapplication.domain.deliveries.IDeliveries;

/**
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso
 * Description:
 */
public class DeliveriesImpl implements IDeliveries, Serializable {

    private long id;
    private String[] destinations;
    private String[] descriptions;
    private String[] recipients;
    private String[] dueDates;
    private double totalDistance = 0.0;

    public DeliveriesImpl()
    {
    }

    public DeliveriesImpl(Builder builder) {
        this.descriptions = builder.descriptions;
        this.destinations = builder.destinations;
        this.totalDistance = builder.totalDistance;
        this.recipients = builder.recipients;
        this.dueDates = builder.dueDates;
    }


    public String[] getDestinations() {
        return destinations;
    }

    public void setDestinations(String[] destinations) {
        this.destinations = destinations;
    }

    public String[] getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String[] descriptions) {
        this.descriptions = descriptions;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    @Override
    public double calculateTotalCost(double totalDistance) {
        double pricePerKm = 10.50;
        return totalDistance * pricePerKm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public void setRecipients(String[] recipients) {
        this.recipients = recipients;
    }

    public String[] getDueDates() {
        return dueDates;
    }

    public void setDueDates(String[] dueDates) {
        this.dueDates = dueDates;
    }

    public static class Builder
    {
        private String[] destinations;
        private String[] descriptions;
        private String[] recipients;
        private String[] dueDates;
        private double totalDistance = 0.0;

        public Builder destinations(String[] values)
        {
            this.destinations = values;
            return this;
        }

        public Builder description(String[] values)
        {
            this.descriptions = values;
            return this;
        }

        public Builder totalDistance(double value)
        {
            this.totalDistance = value;
            return this;
        }

        public  Builder recipients(String[] values)
        {
            this.recipients = values;
            return this;
        }

        public Builder dueDates(String[] values)
        {
            this.dueDates = values;
            return this;
        }



        public Builder copy(DeliveriesImpl value)
        {
            this.destinations = value.destinations;
            this.descriptions = value.descriptions;
            this.totalDistance = value.totalDistance;
            this.dueDates = value.dueDates;
            this.recipients = value.recipients;
            return this;
        }

        public DeliveriesImpl build()
        {
            return new DeliveriesImpl(this);
        }
    }
}
