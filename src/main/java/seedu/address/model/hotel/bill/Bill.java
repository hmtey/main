package seedu.address.model.hotel.bill;

import java.util.ArrayList;

import seedu.address.model.hotel.room.Room;
import seedu.address.model.ids.RoomId;

/**
 * Contains a list of chargeable objects that a guest has requested for a specific room.
 */
public class Bill {
    private RoomId roomId;
    private ArrayList<Chargeable> charges;

    /**
     * Creates an empty {@code bill}.
     */
    public Bill(RoomId roomId) {
        this.roomId = roomId;
        this.charges = new ArrayList<>();
    }

    /**
     * Adds {@code chargeable} to the stored list of chargeable objects.
     */
    public void addChargeable(Chargeable chargeable) {
        charges.add(chargeable);
    }

    /**
     * Returns true if there is no chargeable objects in the bill.
     */
    public boolean isEmpty() {
        return charges.isEmpty();
    }

    public RoomId getRoomId() {
        return  roomId;
    }
}
