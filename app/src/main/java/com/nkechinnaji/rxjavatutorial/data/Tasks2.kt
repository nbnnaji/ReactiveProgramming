package com.nkechinnaji.rxjavatutorial.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Nkechi Nnaji on 4/22/21.
 * Description:
 */

class Tasks2 {
    @SerializedName("tasks")
    var tasks : ArrayList<Tasks> = ArrayList()
    @SerializedName("priority")
    var priority : ArrayList<Priority> = ArrayList()
    @SerializedName("lowPriority")
    var lowPriority : ArrayList<LowPriority> = ArrayList()
}

data class Tasks(
    @SerializedName("bed")
    var bed : String,
    @SerializedName("dog")
    var dog : String,
    @SerializedName("trash")
    var trash : String,
    @SerializedName("dishes")
    var dishes : String,
    @SerializedName("dinner")
    var dinner : String
)

data class Priority(
    @SerializedName("room")
    var room : String,
    @SerializedName("pets")
    var pets : String,
    @SerializedName("kitchen")
    var kitchen : String,
    @SerializedName("kitchendishes")
    var kitchendishes : String,
    @SerializedName("cooking")
    var cooking : String
)

data class LowPriority(
    @SerializedName("play")
    var play : Int,
    @SerializedName("friends")
    var friends : Int,
    @SerializedName("shopping")
    var shopping : Int,
    @SerializedName("dating")
    var dating : Int,
    var laundry : Int
)