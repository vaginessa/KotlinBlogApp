package blogapp.bittupatel.`in`.kotlinblogapp.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase


class Manager(private val context: Context) {

    private var dbHelper: Helper? = null
    private var database: SQLiteDatabase? = null

    @Throws(SQLException::class)
    fun open(): Manager {
        dbHelper = Helper(context)
        database = dbHelper!!.writableDatabase
        return this
    }

    fun close() {
        dbHelper!!.close()
    }

    fun insert(id: Int, title: String, date: String, author: String, thumbnail: String, content: String, isChecked: String) {

        val contentValue = ContentValues()

        contentValue.put(Helper.POST_ID, id)
        contentValue.put(Helper.POST_TITLE, title)
        contentValue.put(Helper.POST_DATE, date)
        contentValue.put(Helper.POST_AUTHOR, author)
        contentValue.put(Helper.POST_THUMBNAIL, thumbnail)
        contentValue.put(Helper.POST_CONTENT, content)
        contentValue.put(Helper.FAV_CHECK, isChecked)

        database!!.insert(Helper.TABLE_NAME, null, contentValue)
    }

    fun fetch(title: String): Cursor? {
        val columns = arrayOf(Helper.POST_DATE, Helper.POST_AUTHOR, Helper.POST_THUMBNAIL, Helper.POST_CONTENT, Helper.FAV_CHECK)

        val cursor = database!!.query(Helper.TABLE_NAME, columns, "title=?", arrayOf(title), null, null, null, null)

        cursor?.moveToFirst()
        return cursor
    }

    fun delete(title: String) {
        database!!.delete(Helper.TABLE_NAME, Helper.POST_TITLE + "='" + title + "'", null)
    }

    fun getAllPost(): Cursor? {
        val columns = arrayOf(Helper.POST_ID, Helper.POST_TIMESTAMP, Helper.POST_TITLE, Helper.POST_DATE, Helper.POST_AUTHOR, Helper.POST_THUMBNAIL, Helper.POST_CONTENT)

        val cursor = database!!.query(Helper.TABLE_NAME, columns, null, null, null, null, Helper.POST_TIMESTAMP + " DESC")

        cursor?.moveToFirst()
        return cursor
    }


}
