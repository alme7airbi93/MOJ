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
}
