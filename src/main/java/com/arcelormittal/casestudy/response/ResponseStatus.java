package com.arcelormittal.casestudy.response;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseStatus {

    FAILURE, SUCCESS, WARNING;

    @JsonValue
    public final String getValue() {
        return toString().toLowerCase();
    }

}
