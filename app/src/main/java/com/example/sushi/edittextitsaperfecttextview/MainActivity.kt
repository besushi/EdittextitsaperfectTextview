package com.example.sushi.edittextitsaperfecttextview

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


var itsTV: Boolean = true
var mytext: String = ""


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val originalDrawable = ET1.getBackground()


        BTN.setOnClickListener {
            var list = listOf<EditText>(ET1,ET2,ET3)
            when (itsTV) {
                true -> ToTextview(list)
                false -> ToEditText(list, originalDrawable)
            }
            mytext = ET1.text.toString()
        }


    }

    private fun ToEditText(X: List<EditText>, originalDrawable: Drawable) {
        X.forEach {
            it.isFocusable = true
            it.isCursorVisible = true
            it.isLongClickable = true
            it.isClickable = true
            it.isEnabled = true
            it.setTextColor(getColor(R.color.BLACK))
            it.inputType = InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE
            it.showSoftInputOnFocus = true
            it.isFocusableInTouchMode = true
            it.background = originalDrawable
        }

        itsTV = true
    }

    private fun ToTextview(X: List<EditText>) {
        X.forEach {
            it.isFocusable = false
            it.isCursorVisible = false
            it.isLongClickable = false
            it.isEnabled = false
            it.setTextColor(getColor(R.color.BLACK))
            it.isClickable = false
            it.background = null
        }
        itsTV = false
    }



}
