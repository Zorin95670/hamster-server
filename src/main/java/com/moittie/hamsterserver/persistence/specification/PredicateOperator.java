package com.moittie.hamsterserver.persistence.specification;

import java.util.Arrays;
import java.util.Optional;

public enum PredicateOperator {
    EQUALS("eq_"),
    INFERIOR("lt_"),
    SUPERIOR("gt_"),
    BETWEEN("bt_"),
    NULL("null"),
    LIKE("lk_");

    private final String value;

    PredicateOperator(final String value) {
        this.value = value;
    }

    public static boolean isValid(final String operator) {
        return Arrays.stream(PredicateOperator.values()).anyMatch(o -> o.getValue().equalsIgnoreCase(operator));
    }

    public static Optional<PredicateOperator> get(final String operator) {
        return Arrays.stream(PredicateOperator.values())
                .filter(o -> o.getValue().equalsIgnoreCase(operator)).findAny();
    }

    public String getValue() {
        return this.value;
    }
}