/*
 * Created by Titi Arimba on 10/19/18 3:43 PM
 * Last Modified on 10/19/18 3:43 PM
 * (c) 2018
 */

package com.titiarimba.kotlinsubmission1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.titiarimba.kotlinsubmission1.Model.Football
import com.titiarimba.kotlinsubmission1.adapter.FootballAdapter
//import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainActivity : AppCompatActivity() {

    private var footballItem : ArrayList<Football> = arrayListOf()
    private lateinit var listTeam: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        initData()

//        recycler_view.layoutManager = LinearLayoutManager(this)
        relativeLayout {
            lparams(width = matchParent, height = wrapContent)
            listTeam = recyclerView{
                lparams(width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(ctx)
            }
        }

        listTeam.adapter = FootballAdapter(footballItem){
            startActivity<DetailActivity>(DetailActivity.POSITIONEXTRA to it)
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val keterangan = resources.getStringArray(R.array.club_info)

        footballItem.clear()

        for (i in name.indices){
            footballItem.add(Football(name[i], image.getResourceId(i, 0), keterangan[i]))
        }

        image.recycle()
    }


}
