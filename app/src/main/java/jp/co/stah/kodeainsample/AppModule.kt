package jp.co.stah.kodeainsample

import android.content.Context
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider


fun appModule(appContext: Context)= Kodein.Module{
    bind<Logger>(overrides = true) with provider { DiLogger() }
}