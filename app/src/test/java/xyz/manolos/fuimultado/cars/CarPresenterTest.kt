package xyz.manolos.fuimultado.cars

import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import xyz.manolos.fuimultado.model.Car
import xyz.manolos.fuimultado.service.CarService

@RunWith(MockitoJUnitRunner::class)
class CarPresenterTest {

    @Mock private lateinit var view: CarView

    @Mock private lateinit var carService: CarService

    @InjectMocks private lateinit var presenter: CarPresenter

    @Before fun `set up`() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test fun `should show error when service fails`() {
        given(carService.fetch(anyString(), anyString())).willReturn(Single.error(Throwable()))

        presenter.fetchCar("placa", "renavam")

        verify(view).showError()
    }

    @Test fun `should add carr when car is fetched`() {
        val car = Car("car")
        given(carService.fetch(anyString(), anyString())).willReturn(Single.just(car))

        presenter.fetchCar("placa", "renavam")

        verify(view).addCar(car)
    }
}
