package jp.co.stah.kodeainsample

import android.util.Log


class DiLogger : Logger {
    override fun log(tag: String, message: String) {
        Log.d(tag, message)
    }
}