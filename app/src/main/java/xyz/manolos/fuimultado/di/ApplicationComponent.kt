package xyz.manolos.fuimultado.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import xyz.manolos.fuimultado.cars.CarComponent
import xyz.manolos.fuimultado.cars.CarModule
import javax.inject.Singleton

@Component(modules = [ServiceModule::class])
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun applicationContext(context: Context): Builder
        fun build(): ApplicationComponent
    }

    fun plus(carModule: CarModule): CarComponent
}
