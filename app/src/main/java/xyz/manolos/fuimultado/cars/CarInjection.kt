package xyz.manolos.fuimultado.cars

import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [CarModule::class])
interface CarComponent {

    val presenter: CarPresenter
}

@Module
class CarModule(@get:Provides val carView: CarView)
