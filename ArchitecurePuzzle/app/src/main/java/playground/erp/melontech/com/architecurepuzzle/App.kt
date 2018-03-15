package playground.erp.melontech.com.architecurepuzzle

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.util.Log
import id.kotlin.room.extensions.objectOf


/**
 * Created by vmanev on 3/9/2018.
 */
class App : Application() {

    companion object db {
       public lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        Log.e("App", "Application started")
        database = Room.databaseBuilder(this, AppDatabase::class.java, "room_sample.db").build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
//        MultiDex.install(this)
    }
}