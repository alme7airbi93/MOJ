package com.mohammad.mojapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mohammad.mojapplication.MOJdatabase.MOJCursorWraper;
import com.mohammad.mojapplication.MOJdatabase.MOJDbHelper;
import com.mohammad.mojapplication.MOJdatabase.MOJDbSchema;
import com.mohammad.mojapplication.Objects.NIDCard;
import com.mohammad.mojapplication.Objects.User;

import java.util.List;

import static com.mohammad.mojapplication.MOJdatabase.MOJDbSchema.*;

/**
 * Created by user on 11/4/2015.
 */
public class MOJManager
{



    private  static MOJManager mojManager;
    private SQLiteDatabase database;
    private Context context;


    public MOJManager(Context context) {
        this.context = context.getApplicationContext();
        database = new MOJDbHelper(this.context).getWritableDatabase();
    }

    public static MOJManager getMOJManager(Context context)
    {

        if(mojManager == null) {
            mojManager = new MOJManager(context);

        }
        return mojManager;

    }
    // USER DATA TABLE ---------------------------------------------------------
  private MOJCursorWraper querryUserTable(String whereClause,String[] whereArgs) {
      Cursor cursor = database.query(
              UserTable.NAME,
              null,
              whereClause,
              whereArgs,
              null,
              null,
              null);
      return new MOJCursorWraper(cursor);

  }

    private static ContentValues getContentValues(User user) {
        ContentValues values = new ContentValues();
        values.put(UserTable.Cols.ID,user.getId());
        values.put(UserTable.Cols.NAME,user.getName());
        values.put(UserTable.Cols.MOBILE,user.getAddress());
        values.put(UserTable.Cols.ADDRESS,user.getAddress());
        values.put(UserTable.Cols.USER_NAME, user.getUserName());
        values.put(UserTable.Cols.PASS,user.getPass());

        return values;
    }

    public void addUser(User user) {
        ContentValues values = getContentValues(user);
        database.insert(UserTable.NAME, null, values);
    }

    public User findUserById(String  id) {
        MOJCursorWraper cursorWraper =
                querryUserTable(UserTable.Cols.ID + " = ?", new String[]{id.toString()});

        try
        {
            if(cursorWraper.getCount() == 0)
            {
                return null;
            }

            cursorWraper.moveToFirst();
            return cursorWraper.getUser();
        }
        finally {
            cursorWraper.close();
        }


    }

    public User findUserByUserName(String  userName) {
        MOJCursorWraper cursorWraper =
                querryUserTable(UserTable.Cols.USER_NAME + " = ?", new String[]{userName});

        try
        {
            if(cursorWraper.getCount() == 0)
            {
                return null;
            }

            cursorWraper.moveToFirst();
            return cursorWraper.getUser();
        }
        finally {
            cursorWraper.close();
        }


    }


    //  NATIONAL ID DATABASE -----------------------------------------------------------------------

    private MOJCursorWraper querryEmiratesIDTable(String whereClause,String[] whereArgs) {
        Cursor cursor = database.query(
                EmiratesIDTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);
        return new MOJCursorWraper(cursor);

    }

    private static ContentValues getContentValuesNID(NIDCard nidCard) {
        ContentValues values = new ContentValues();
        values.put(EmiratesIDTable.Cols.ID,nidCard.getId());
        values.put(EmiratesIDTable.Cols.NAME,nidCard.getName());
        values.put(EmiratesIDTable.Cols.ADDRESS,nidCard.getAddress());
        values.put(EmiratesIDTable.Cols.DOB,nidCard.getDob().getTime());
        values.put(EmiratesIDTable.Cols.MOBILE,nidCard.getMobile());
        return values;
    }

    public void addNIDCard(NIDCard nidCard) {
        ContentValues values = getContentValuesNID(nidCard);
        database.insert(EmiratesIDTable.NAME, null, values);
    }

    public NIDCard findNIDCardById(String  id) {
        MOJCursorWraper cursorWraper =
                querryEmiratesIDTable(EmiratesIDTable.Cols.ID + " = ?", new String[]{id.toString()});

        try
        {
            if(cursorWraper.getCount() == 0)
            {
                return null;
            }

            cursorWraper.moveToFirst();
            return cursorWraper.getNID();
        }
        finally {
            cursorWraper.close();
        }


    }






}
