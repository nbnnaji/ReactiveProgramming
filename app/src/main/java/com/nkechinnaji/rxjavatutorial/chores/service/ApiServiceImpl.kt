package com.nkechinnaji.rxjavatutorial.chores.service

import com.nkechinnaji.rxjavatutorial.data.Tasks2
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by Nkechi Nnaji on 4/22/21.
 * Description:
 */
public class ApiServiceImpl {

    companion object {
        val api by lazy { RetrofitClientInstance.callApi() }
        var disposable: Disposable? = null
        fun apiData(callBack: Response) {
            disposable = api.getTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    callBack.data(result)
                }, { error ->
                    error.printStackTrace()
                })

        }
    }

    interface Response {
        fun data(data: Tasks2)

    }
}
//json-server db.json