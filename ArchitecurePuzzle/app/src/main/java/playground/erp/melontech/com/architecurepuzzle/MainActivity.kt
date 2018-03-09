package playground.erp.melontech.com.architecurepuzzle

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

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


        var database = AppDatabase.getInstance(this)

        val userrepo = database.UserDao();

        userrepo.insertAll(User().apply { firstName = "Viktor"; lastName = "Manev" });
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
