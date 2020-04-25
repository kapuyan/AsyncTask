package com.example.simpleasynctask

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var mTextView: TextView? = null
    private val TEXT_STATE = "currentText"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextView = findViewById(R.id.textview1)
        // Restore TextView if there is a savedInstanceState
        if (savedInstanceState != null) {
            mTextView!!.text = savedInstanceState.getString(TEXT_STATE);


        }
    }

    fun startTask(view: View) {
        mTextView!!.setText(R.string.napping)
        SimpleAsyncTask(mTextView).execute()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_STATE,
            mTextView?.text.toString())
    }
}
