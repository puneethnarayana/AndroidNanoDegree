package com.example.bill.movies2;

import android.content.Context;
import android.database.Cursor;
import com.example.bill.movies2.persistence.MovieStruct;

/**
 * Created by bill on 4/16/16.
 */
public class HouseKeeping {

    public static int isItFav(Context context, int id) {
        Cursor cursor = context.getContentResolver().query(
                MovieStruct.MovieEntry.CONTENT_URI,
                null,
                MovieStruct.MovieEntry.COLUMN_MOVIE_ID + " = ?",
                new String[]{Integer.toString(id)},
                null
        );
        int numRows = cursor.getCount();
        cursor.close();
        return numRows;
    }

    public static String buildImageUrl(int width, String fileName) {
        return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
    }

    public static final String API_KEY = "abc7a0e8dc7f0b0d4f88c38f73a3fcb3";
}