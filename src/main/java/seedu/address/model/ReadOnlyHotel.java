package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.hotel.Stay;
import seedu.address.model.hotel.bill.AvailableService;
import seedu.address.model.hotel.booking.Booking;
import seedu.address.model.hotel.room.Room;
import seedu.address.model.hotel.room.Tier;

import java.util.Collection;

/**
 * Unmodifiable hotel
 */
public interface ReadOnlyHotel {
    /**
     * return list of rooms.
     */
    ObservableList<Room> getRoomList();
    /**
     * @return a list of tiers;
     */
    ObservableList<Tier> getTierList();
    /**
     * @return list of bookings
     */
    ObservableList<Booking> getBookingList();

    /**
     * @return list of available services
     */
    ObservableList<AvailableService> getAvailableServiceList();

    /**
     * @return list of available stays
     */
    ObservableList<Stay> getStayList();
}
