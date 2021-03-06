package seedu.address.model.hotel.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MatchNamePredicateTest {

    @Test
    void test() {
        Person alice = ALICE;
        List<Name> nameList = new ArrayList<>();

        nameList.add(BENSON.getName());
        MatchNamePredicate pred1 = new MatchNamePredicate(nameList);

        nameList.add(alice.getName());

        MatchNamePredicate pred2 = new MatchNamePredicate(nameList);

        assertFalse(pred1.test(alice.getName()));
        assertTrue(pred1.test(BENSON.getName()));
        assertTrue(pred2.test(alice.getName()));
    }
}
