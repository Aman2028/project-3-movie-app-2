package com.android.aman.movieapp.Databse;



import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.aman.movieapp.DAO.MovieDao;
import com.android.aman.movieapp.Models.Favourite;

@Database(entities = {Favourite.class},version = 3,exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase
{
    private static final String LOG_TAG = MovieDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "movieslist";
    private static MovieDatabase sInstance;

    public static MovieDatabase getsInstance(Context context)
    {
        if (sInstance==null)
        {
            synchronized (LOCK)
            {
                sInstance= Room.databaseBuilder(context.getApplicationContext(),MovieDatabase.class,MovieDatabase.DATABASE_NAME)
                        .build();
            }
        }
        return sInstance;
    }
    public abstract MovieDao movieDao();

}
