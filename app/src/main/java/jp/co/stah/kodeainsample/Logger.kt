package jp.co.stah.kodeainsample

class Logger {
  //  fun log(tag: String , message:String)
  var text: String = ""
      private set

    var callback: (() -> Unit)? = null

    fun log(msg: String) {
        text += "$msg\n"
        callback?.invoke()
    }

}