package com.nkechinnaji.rxjavatutorial.chores.service

import com.nkechinnaji.rxjavatutorial.data.Tasks2
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Nkechi Nnaji on 4/22/21.
 * Description:
 */

interface ApiService {
    @GET("/db")
    fun getTasks() : Observable<Tasks2>
}