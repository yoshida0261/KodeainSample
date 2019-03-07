package jp.co.stah.kodeainsample

import android.app.Activity
import android.app.Application
import jp.co.stah.kodeainsample.coffee.Coffee
import jp.co.stah.kodeainsample.coffee.Kettle
import jp.co.stah.kodeainsample.coffee.electricHeaterModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.bindings.WeakContextScope
import org.kodein.di.generic.*

class MyApp : Application(), KodeinAware {

  //  private val logger by instance<Logger>()

    override var kodein = Kodein.lazy {
        //import(appModule(applicationContext))
        import(androidXModule(this@MyApp))

        bind() from instance(Logger())

        import(electricHeaterModule)

        bind<Coffee>() with provider { Coffee(instance()) }

        // this is bound in the scope of an activity so any retrieval using the same activity will return the same Kettle instance
        bind<Kettle<Coffee>>() with scoped(WeakContextScope.of<Activity>()).singleton { Kettle<Coffee>(instance(), instance(), instance(), provider()) }

    }

    override fun onCreate() {
        super.onCreate()
        val k = kodein
        println(k)
       // logger.log("tag", message = "messaggggggggggg")
    }
}