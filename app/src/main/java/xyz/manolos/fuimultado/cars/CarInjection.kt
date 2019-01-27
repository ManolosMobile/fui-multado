package xyz.manolos.fuimultado.cars

import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [CarModule::class])
interface CarComponent {

    fun inject(activity: CarActivity)
}

@Module
class CarModule(private val carView: CarView) {

    @Provides
    fun provideCarView() = carView
}
