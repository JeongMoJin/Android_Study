package kr.jeongmo.a0520sqlitedatebase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper (context:Context, name: String, version:Int):
    SQLiteOpenHelper(context, name, null, version){
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE `memo` (`num` INTEGER PRIMARY KEY, " +
                "`content` TEXT, `datetime` INTEGER)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val create = "CREATE TABLE memo (" +
                "num integer primary key, " +
                "content text, " +
                "datetime integer" +
                ")"
        db?.execSQL(create)
    }

}

data class Memo(var num: Long?, var content: String, var datetime: Long)