package com.titiarimba.kotlinsubmission1.Layout

import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.titiarimba.kotlinsubmission1.R
import org.jetbrains.anko.*

class FootballLayout : AnkoComponent<ViewGroup> {

    companion object {
        val tvTitle= 1
        val imgFootbal = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        linearLayout{
            orientation = LinearLayout.HORIZONTAL
            backgroundResource = R.drawable.background
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView {
                id = imgFootbal
                imageResource = R.drawable.img_arsenal
                layoutParams = LinearLayout.LayoutParams(150, 150)
            }
//                    .lparams(dip(50), dip(50))

            textView{
                id = tvTitle
                text = "Test"
                textSize = 16f
            }.lparams(matchParent, wrapContent){
                margin = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }
        }
    }
}