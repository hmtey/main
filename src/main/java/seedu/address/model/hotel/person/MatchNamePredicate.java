package seedu.address.model.hotel.person;

import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

/**
 * Check if the person name is in a predetermine list.
 */
public class MatchNamePredicate implements Predicate<Name> {
    private final HashSet<Name> nameList;

    /**
     * Create predicate with nameList
     * @param nameList
     */
    public MatchNamePredicate(HashSet<Name> nameList) {
        ///nameList may change later on
        this.nameList = nameList;
    }

    /**
     * Altenative constructor.
     * @param nameList
     */
    public MatchNamePredicate(List<Name> nameList) {
        this.nameList = new HashSet<>(nameList);
    }

    /**
     * Evaluates this predicate on the given argument.
     *
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    @Override
    public boolean test(Name name) {
        return nameList.contains(name);
    }
    @Override
    public boolean equals(Object oth) {
        if (this == oth) {
            return true;
        }
        if (!(oth instanceof MatchNamePredicate)) {
            return false;
        }
        MatchNamePredicate othPred = (MatchNamePredicate) oth;
        return othPred.nameList.equals(nameList);
    }

}
