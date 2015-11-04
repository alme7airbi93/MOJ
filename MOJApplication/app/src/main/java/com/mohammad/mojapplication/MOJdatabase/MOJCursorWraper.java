package com.mohammad.mojapplication.MOJdatabase;

import android.database.Cursor;
import android.database.CursorWrapper;


import com.mohammad.mojapplication.Objects.NIDCard;
import com.mohammad.mojapplication.Objects.User;

import java.util.Date;
import java.util.UUID;

/**
 * Created by user on 10/28/2015.
 */
public class MOJCursorWraper extends CursorWrapper {




    public MOJCursorWraper(Cursor cursor)
    {
        super(cursor);
    }

    public User getUser()
    {
        String id = getString(getColumnIndex(MOJDbSchema.UserTable.Cols.ID));
        String name = getString(getColumnIndex(MOJDbSchema.UserTable.Cols.NAME));
        String mobile = getString(getColumnIndex(MOJDbSchema.UserTable.Cols.MOBILE));
        String address = getString(getColumnIndex(MOJDbSchema.UserTable.Cols.ADDRESS));
        String username = getString(getColumnIndex(MOJDbSchema.UserTable.Cols.USER_NAME));
        String pass = getString(getColumnIndex(MOJDbSchema.UserTable.Cols.PASS));


        User user = new User(id,name,mobile,address,username,pass);


        return user;

    }

    public NIDCard getNID()
    {
        String id = getString(getColumnIndex(MOJDbSchema.EmiratesIDTable.Cols.ID));
        String name = getString(getColumnIndex(MOJDbSchema.EmiratesIDTable.Cols.NAME));
        String mobile = getString(getColumnIndex(MOJDbSchema.EmiratesIDTable.Cols.MOBILE));
        String address = getString(getColumnIndex(MOJDbSchema.EmiratesIDTable.Cols.ADDRESS));
        long dob = getLong(getColumnIndex(MOJDbSchema.EmiratesIDTable.Cols.DOB));



        NIDCard nidCard = new NIDCard(id,name,mobile,address,new Date(dob));


        return nidCard;

    }
}
