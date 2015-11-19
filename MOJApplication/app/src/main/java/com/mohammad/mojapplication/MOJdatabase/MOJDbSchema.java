package com.mohammad.mojapplication.MOJdatabase;

/**
 * Created by user on 10/28/2015.
 */
public class MOJDbSchema {

    public static final class UserTable
    {
        public static final String NAME = "user";
        public static final class Cols
        {
            public static final String ID = "id";
            public static final String NAME = "TITLE";
            public static final String MOBILE = "mobile";
            public static final String ADDRESS = "address";
            public static final String USER_NAME = "userName";
            public static final String PASS = "password";
            public static final String SERVICEPASS = "servicepass";
        }
    }

    public static final class EmiratesIDTable
    {
        public static final String NAME = "IDTable";
        public static final class Cols
        {
            public static final String ID = "id";
            public static final String NAME = "TITLE";
            public static final String MOBILE = "mobile";
            public static final String ADDRESS = "address";
            public static final String DOB = "userName";

        }
    }

    public static final class ServiceTable
    {
        public static final String NAME = "serviceTable";
        public static final class Cols
        {
            public static final String USERID = "id";
            public static final String TYPE = "type";
            public static final String SERVICEID = "serviceid";
            public static final String DATE = "date";
            public static final String SERVICESTATUS = "servicestatus";

        }
    }
}
