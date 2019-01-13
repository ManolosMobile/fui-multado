package xyz.manolos.fuimultado.cars

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import xyz.manolos.fuimultado.service.CarService

class CarPresenter(
    private val view: CarView,
    private val carService: CarService
) {

    private val disposables = CompositeDisposable()

    fun fetchCar(plate: String, renavam: String) {
        carService.fetch(plate, renavam)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    view.addCar(it)
                },
                onError = {
                    view.showError()
                }
            )
            .addTo(disposables)
    }

    fun disposeResources() {
        disposables.dispose()
    }
}
