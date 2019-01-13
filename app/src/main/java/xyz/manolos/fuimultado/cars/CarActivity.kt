package xyz.manolos.fuimultado.cars

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_car.*
import kotlinx.android.synthetic.main.add_car_dialog.*
import xyz.manolos.fuimultado.R
import xyz.manolos.fuimultado.model.Car
import xyz.manolos.fuimultado.service.CarServiceCreator

class CarActivity : AppCompatActivity() {

    private lateinit var presenter: CarPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)

        presenter = CarPresenter(this, CarServiceCreator.carService)

        addCarButton.setOnClickListener {
            AlertDialog
                .Builder(this)
                .setTitle(R.string.add_car_dialog_title)
                .setView(R.layout.add_car_dialog)
                .setPositiveButton(android.R.string.ok) { dialog, _ ->
                    val plate = (dialog as AlertDialog).plateEditText.text.toString()
                    val renavam = dialog.renavamEditText.text.toString()

                    presenter.fetchCar(plate, renavam)
                }
                .setNegativeButton(android.R.string.cancel) { _, _ -> }
                .show()
        }
    }

    fun addCar(car: Car) {
        Toast.makeText(this, "${car.name}", Toast.LENGTH_LONG).show()
        // add car into the recyclerview
    }

    fun showError() {
        // show toast or snackbar
    }
}
