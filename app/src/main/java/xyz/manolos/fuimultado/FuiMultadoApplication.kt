package xyz.manolos.fuimultado

import android.app.Activity
import android.app.Application
import xyz.manolos.fuimultado.di.DaggerApplicationComponent

class FuiMultadoApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent
            .builder()
            .applicationContext(applicationContext)
            .build()
    }
}

val Activity.injector get() = (application as FuiMultadoApplication).component
