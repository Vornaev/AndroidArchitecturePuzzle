package playground.erp.melontech.com.architecurepuzzle

import android.app.Application
import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.*
import android.content.Context

/**
 * Created by vmanev on 2/28/2018.
 */

@Database(entities = arrayOf(User::class), version = 1)
    abstract class  AppDatabase() : RoomDatabase() {

    abstract fun UserDao(): UserDao
}