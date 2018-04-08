package blogapp.bittupatel.`in`.kotlinblogapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Helper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(sqLiteDatabase)
    }

    companion object {

        // Database Information
        internal const val DB_NAME = "FAV.DB"

        // Table Name
        const val TABLE_NAME = "favourite"

        // Table columns
        const val POST_ID = "id"
        const val POST_TIMESTAMP = "timestamp"
        const val POST_TITLE = "title"
        const val POST_DATE = "date"
        const val POST_AUTHOR = "author"
        const val POST_THUMBNAIL = "thumbnail"
        const val POST_CONTENT = "content"
        const val FAV_CHECK = "isChecked"

        // database version
        internal const val DB_VERSION = 1

        // Creating table query
        private const val CREATE_TABLE = ("create table " + TABLE_NAME + "(" +
                POST_ID + " INT NOT NULL, " +
                POST_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                POST_TITLE + " TEXT, " +
                POST_DATE + " TEXT ," +
                POST_AUTHOR + " TEXT, " +
                POST_THUMBNAIL + " TEXT," +
                POST_CONTENT + " TEXT," +
                FAV_CHECK + " TEXT)")
    }
}
