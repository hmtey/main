package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROOMNUMBER;

import java.util.Optional;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.hotel.bill.Service;
import seedu.address.model.hotel.person.Person;
import seedu.address.model.hotel.room.Room;
import seedu.address.model.ids.PersonId;
import seedu.address.model.ids.RoomId;

public class ServiceCommand extends Command {

    public static final String COMMAND_WORD = "service";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a service to the guest's bill. "
            + "Parameters: "
            + PREFIX_ID + "ID "
            + PREFIX_ROOMNUMBER + "ROOM_NUMBER "
            + PREFIX_DESCRIPTION + "DESCRIPTION "
            + PREFIX_COST + "COST\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_ID + "G1231231X "
            + PREFIX_ROOMNUMBER + "101 "
            + PREFIX_DESCRIPTION + "massage "
            + PREFIX_COST + "20.00";

    public static final String MESSAGE_SUCCESS = "Added %1 to the bill of guest %2s for room %3s.";
    public static final String MESSAGE_GUEST_NONEXISTENT = "Guest %1s does not exist in the system.";
    public static final String MESSAGE_ROOM_NONEXISTENT = "Room %1$s does not exist in the system.";

    private final PersonId personId;
    private final RoomId roomId;
    private final Service service;

    /**
     * @param personId to add bill to
     * @param roomId that the bill is for
     * @param service service to add
     */
    public ServiceCommand(PersonId personId, RoomId roomId, Service service) {
        requireAllNonNull(personId, roomId, service);
        this.personId = personId;
        this.roomId = roomId;
        this.service = service;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Optional<Person> person = model.findPersonWithId(personId);
        Optional<Room> room = model.findRoom(roomId);

        if (person.isEmpty()) {
            throw new CommandException(MESSAGE_GUEST_NONEXISTENT);
        }

        if (person.isEmpty()) {
            throw new CommandException(MESSAGE_GUEST_NONEXISTENT);
        }

        model.addService(personId, roomId, service);
        return new CommandResult(String.format(MESSAGE_SUCCESS, service, personId, roomId));
    }
}