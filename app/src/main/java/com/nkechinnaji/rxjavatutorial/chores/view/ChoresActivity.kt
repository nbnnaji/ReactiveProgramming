package com.nkechinnaji.rxjavatutorial.chores.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nkechinnaji.rxjavatutorial.R
import com.nkechinnaji.rxjavatutorial.data.Tasks2
import com.nkechinnaji.rxjavatutorial.chores.service.ApiServiceImpl
import com.nkechinnaji.rxjavatutorial.chores.service.ChoresAdapter
import kotlinx.android.synthetic.main.activity_chores.*

class ChoresActivity : AppCompatActivity() {
    private val textView : TextView? = null
    var linearLayoutManager: LinearLayoutManager? = null
    private var adapter: ChoresAdapter? = null

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chores)
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyler_view.layoutManager = linearLayoutManager
        recyler_view.adapter = adapter
        val button = findViewById<AppCompatButton>(R.id.play_button)
        button.setOnClickListener{
            var service = ApiServiceImpl
            service.apiData(object: ApiServiceImpl.Response{
                override fun data(data : Tasks2) {
                    recyler_view.visibility = View.VISIBLE
                    getChoresData(data)
                }

            })
        }
    }

    private fun getChoresData(data : Tasks2) {
        data.let {
            adapter =
                ChoresAdapter(it.tasks)
            val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
            recyler_view.layoutManager = layoutManager
            recyler_view.adapter = adapter
        }
    }

}