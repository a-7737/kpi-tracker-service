package com.ibs.kpitrackerservice.service;

public enum Events {
    OPERATION_SUCCESSFUL( 101,"Operation was successful!"),
    OPERATION_FAILED( 102,"Operation was failed!"),
    USER_SAVE_EXCEPTION(103, "Exception occurred while trying to add new user"),
    USER_UPDATE_EXCEPTION(104, "Exception occurred while trying to update an user"),
    USER_DELETE_EXCEPTION(105, "Exception occurred while trying to delete an existing user"),
    USER_EXCEPTION(105, "Exception occurred while trying to fetch an existing user"),
    NOT_FOUND(106, "Couldn't able to find the User"),
    TEAM_NOT_FOUND(107, "Team not found"),
    KPI_NOT_FOUND(108, "Kpi not found")
    ;

    private final Integer errorCode;
    private final String message;

    Events(int errorCode, String message) {
       this.errorCode = errorCode;
       this.message = message;
    }

    public static String getMessage(Events event) {
        return event.message;
    }

    public static Integer getErrorCode(Events event) {
        return event.errorCode;
    }

}
