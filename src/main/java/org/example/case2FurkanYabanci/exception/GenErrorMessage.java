package org.example.case2FurkanYabanci.exception;

public enum GenErrorMessage implements BaseErrorMessage{
    ITEM_NOT_FOUND("Item not found!"),
    ADDRESS_NOT_FOUND("Address not found!"),
    CITY_NOT_FOUND("City not found!"),
    COUNTRY_NOT_FOUND("Country not found!"),
    DISTRICT_NOT_FOUND("District not found!"),
    NEIGHBORHOOD_NOT_FOUND("Neighborhood not found!"),
    STREET_NOT_FOUND("Street not found!")
    ;

    private String message;
    GenErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
