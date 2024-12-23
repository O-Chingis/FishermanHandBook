package com.example.kotlinfishermanhandbook.db
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDbHelper(context: Context) : SQLiteOpenHelper(
    context,
    MyDbNameClass.DATABASE_NAME,
    null,
    MyDbNameClass.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDbNameClass.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Здесь можно реализовать логику обновления базы данных
        db.execSQL("DROP TABLE IF EXISTS ${MyDbNameClass.TABLE_NAME}") // Удаляем старую таблицу
        onCreate(db) // Создаем новую таблицу
    }

}