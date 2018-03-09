package playground.erp.melontech.com.architecurepuzzle

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableCreate

/**
 * Created by vmanev on 2/20/2018.
 */
class MainViewModel(val service: IDataModel = DataModel()) : ViewModel() {

    lateinit var person: Observable<UserViewModel>
    var person2: MutableLiveData<UserViewModel> = MutableLiveData<UserViewModel>()


    fun init() {

        service.getDataObs().subscribe({ handleUser(it) });
    }

    fun handleUser(userViewModel: UserViewModel) {
        person2.postValue(userViewModel)
    }

    init {
        Log.e("invoked", "invoker init")
    }


    override fun onCleared() {
        super.onCleared()
    }
}

interface IDataModel {
    fun getData(): UserViewModel

    fun getDataObs(): io.reactivex.Observable<UserViewModel>

    fun getDataLive(): LiveData<UserViewModel>
}

class DataModel : IDataModel {
    override fun getDataLive(): LiveData<UserViewModel> {

        var p1: LiveData<UserViewModel> = LiveDataReactiveStreams.fromPublisher { getDataObs() }
        Log.e("reactive steam", p1.toString())
        return LiveDataReactiveStreams.fromPublisher { getDataObs() }
    }

    override fun getDataObs(): Observable<UserViewModel> {
        return ObservableCreate.fromCallable({ createUser() }).doOnNext { Log.e("\n DoOnNext", "\n Do on next returned") }.doAfterNext { Log.e("\n DoAfterNext", "\n Do  after next returned") }.doOnComplete({ Log.e("\n DoOnComplete", "\n Do on complete return") }).doAfterTerminate({ Log.e("\n doafterTerminate", "\n Do after teminate returned") }).doFinally { Log.e("\n Do on Finally", "\n Do on finnally") }.doOnEach { Log.e("\n DoOnEach", "\n Do on each returned") }
    }

    override fun getData(): UserViewModel {
        return createUser()
    }

    fun createUser(): UserViewModel {
        return UserViewModel("viktor", "mano")
    }
}


data class UserViewModel(var name: String, var lastname: String) {


}