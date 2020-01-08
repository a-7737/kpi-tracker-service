package com.ibs.kpitrackerservice.service;

public enum Events {
    OPERATION_SUCCESSFUL( 100,"Operation was successful!"),
    OPERATION_FAILED( 101,"Operation was failed!"),
    ;

    private final Integer statusCode;
    private final String message;

    Events(int statusCode, String message) {
       this.statusCode = statusCode;
       this.message = message;
    }

    public static String getMessage(Events event) {
        return event.message;
    }

    public static Integer getErrorCode(Events event) {
        return event.statusCode;
    }

    public enum Error {
        USER_SAVE_EXCEPTION(103, "Exception occurred while trying to add new user"),
        USER_UPDATE_EXCEPTION(104, "Exception occurred while trying to update an user"),
        USER_DELETE_EXCEPTION(105, "Exception occurred while trying to delete an existing user"),
        USER_EXCEPTION(105, "Exception occurred while trying to fetch an existing user"),
        USER_NOT_FOUND(106, "Couldn't able to find the User"),
        TEAM_NOT_FOUND(107, "Team not found"),
        KPI_NOT_FOUND(108, "Kpi not found"),
        ;

        private final Integer errorCode;
        private final String message;

        Error(int errorCode, String message) {
            this.errorCode = errorCode;
            this.message = message;
        }

        public static Integer getErrorCode(Error error) {
            return error.errorCode;
        }

        public static String getMessage(Error error) {
            return error.message;
        }
    }

}
