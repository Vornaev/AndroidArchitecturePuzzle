package playground.erp.melontech.com.architecurepuzzle

import android.app.Application
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.internal.operators.observable.ObservableCreate
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.Callable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var viewModel: MainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.init()

        viewModel.person2.observe(this, Observer {

            Log.e("UserViewModel Data", it?.name)
           // txtView.setText(it?.name)
        })


       val db = App.database.UserDao();

      // val s = db.findByName("Viktor","Manev");



        //Observable.just(db).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe{ t: UserDao ->  db.insertAll(User().apply { uid =2  ; firstName = "Viktor"; lastName = "Manev" })  }

        Observable.just(db).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe{ t: UserDao -> Log.e("Database Operation", t.findByName("Viktor", "Manev").lastName) }
    }



    override fun onResume() {
        super.onResume()
    }

    companion object Vice {

        fun getIstance() {

            Log.e("get Instace", "getIstance")
        }

        init {
            Log.e("hello", "Hello from init");
        }
    }


}
