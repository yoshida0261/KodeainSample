package jp.co.stah.kodeainsample

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MyApp : Application(), KodeinAware {

    private val logger by instance<Logger>()

    override var kodein = Kodein.lazy {
        import(appModule(applicationContext))
    }

    override fun onCreate() {
        super.onCreate()
        logger.log("tag", message = "messaggggggggggg")
    }
}