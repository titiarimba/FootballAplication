package com.titiarimba.kotlinsubmission1.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.titiarimba.kotlinsubmission1.Layout.FootballLayout
import com.titiarimba.kotlinsubmission1.MainActivity
import com.titiarimba.kotlinsubmission1.Model.Football
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.image
import org.jetbrains.anko.wrapContent

class FootballAdapter(val list: ArrayList<Football>, var listener: (Football) -> Unit) :
        RecyclerView.Adapter<FootballAdapter.FootballViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FootballViewHolder {
        return FootballViewHolder(FootballLayout().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: FootballViewHolder, p1: Int) {
        p0.bindItem(list[p1], listener)
    }

    inner class FootballViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imageView : ImageView
        var textView : TextView

        init {
            imageView = itemView.findViewById(FootballLayout.imgFootbal)
            textView = itemView.findViewById(FootballLayout.tvTitle)
        }

        fun bindItem(football: Football, listener: (Football) -> Unit) {
            textView.text = football.name
            Glide.with(itemView.context).load(football.image).into(imageView)
            itemView.setOnClickListener{
                listener(football)
            }
        }

    }
}
