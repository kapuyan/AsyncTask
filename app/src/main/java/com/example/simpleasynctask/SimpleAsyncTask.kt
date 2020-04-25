package com.example.simpleasynctask

import android.os.AsyncTask
import android.widget.TextView
import java.lang.ref.WeakReference
import java.util.*


class SimpleAsyncTask(mTextView: TextView?) : AsyncTask<Void, Void, String>() {
    private var mTextView: WeakReference<TextView>? = null


    fun SimpleAsyncTask(tv: TextView) {
        this@SimpleAsyncTask.mTextView = WeakReference(tv)
    }

    override fun doInBackground(vararg voids: Void?): String? {
       //generates a random value from 0 to 10
        val r = Random()
        val n: Int = r.nextInt(11)

        //time multiplier, as threads run in ms
        val s = n * 200

        //sleep for random amount of time
        try {
            Thread.sleep(s.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        // returns when thread is awake
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    override fun onPostExecute(result: String?) {
        mTextView!!.get()!!.text = result
    }
}