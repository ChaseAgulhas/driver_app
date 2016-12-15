package za.co.avcustom.driverapplication.factories.deliveries;

import za.co.avcustom.driverapplication.domain.deliveries.impl.DeliveriesImpl;

/**
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso
 * Description:
 */

public class DeliveryFactory
{
    public static DeliveriesImpl getDelivery(String[] destinations, String[] descriptions, String[] dueDates, String[] recipients , double totalDistance)
    {
        DeliveriesImpl deliveries = new DeliveriesImpl.Builder()
                .destinations(destinations)
                .description(descriptions)
                .recipients(recipients)
                .dueDates(dueDates)
                .totalDistance(totalDistance)
                .build();
        return deliveries;
    }
}
