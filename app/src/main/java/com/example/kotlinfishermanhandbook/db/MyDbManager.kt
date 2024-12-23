package com.example.kotlinfishermanhandbook.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.compose.ui.input.key.Key
import android.database.Cursor
import android.database.sqlite.SQLiteOpenHelper

class MyDbManager(val context: Context) {
    val MyDbHelper = MyDbHelper(context)
    var db:SQLiteDatabase? =null

    fun openDb(){
        db=MyDbHelper.writableDatabase
    }
    fun insertToDb(title:String, content:String){
        val values=ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)

        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }
    fun readDbData(): ArrayList<String> {
        val dataList = ArrayList<String>()
        if (db == null) {
            throw IllegalStateException("Database is not open.")
        }

        val cursor: Cursor? = db?.query(MyDbNameClass.TABLE_NAME, null, null, null, null, null, null)

        cursor?.use {
            while (it.moveToNext()) {
                val dataText = it.getString(it.getColumnIndexOrThrow(MyDbNameClass.COLUMN_NAME_TITLE))
                dataList.add(dataText)
            }
        }

        return dataList

    }
    fun closeDb() {
        db?.close()
    }


}