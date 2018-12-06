/*
 * Created by Titi Arimba on 10/19/18 3:43 PM
 * Last Modified on 10/19/18 3:43 PM
 * (c) 2018
 */

/*
 * Created by Titi Arimba on 10/19/18 3:43 PM
 * Last Modified on 10/19/18 3:43 PM
 * (c) 2018
 */

package com.titiarimba.kotlinsubmission1

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.ColorInt
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.constraint.ConstraintLayout.LayoutParams.START
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.titiarimba.kotlinsubmission1.Layout.FootballLayout
import com.titiarimba.kotlinsubmission1.Model.Football
import com.titiarimba.kotlinsubmission1.R.id.*
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout



class DetailActivity : AppCompatActivity() {

    companion object {
        val keteranganID = 3
        val POSITIONEXTRA = "position_extra"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val list = intent.getParcelableExtra<Football>(POSITIONEXTRA)

        DetailActivityUI(list).setContentView(this)
    }

    inner class DetailActivityUI(var list: Football) : AnkoComponent<DetailActivity>{

        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            var position = 0
            constraintLayout {

                imageView {
                    id = R.id.img_football
                    Glide.with(this).load(list.image).into(this)
                    padding = dip(10)
                }.lparams(dip(100), dip(100)){
                    leftMargin = dip(8)
                    topMargin = dip(8)
                    endToEnd = PARENT_ID
                    startToStart = PARENT_ID
                    topToTop = PARENT_ID
                }

                textView {
                    id = R.id.tvName
                    text = list.name
                    textSize = 18f
                    textColor = Color.BLACK
                }.lparams(width= wrapContent, height = wrapContent){
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                    topToBottom = R.id.img_football
                    topMargin = dip(16)
                    leftMargin = dip(8)
                    rightMargin = dip(8)
                }

                textView {
                    id = R.id.tvDesc
                    text = list.keterangan
                    textColor = Color.BLACK
                    gravity = center_horizontal;center_vertical;center
                }.lparams(width= wrapContent, height = wrapContent){
                    startToStart = PARENT_ID
                    rightToRight = PARENT_ID
                    endToEnd = PARENT_ID
                    topToBottom = R.id.tvName
                    topMargin = dip(8)
                    leftMargin = dip(8)
                    rightMargin = dip(8)
                }
            }
        }

    }
}