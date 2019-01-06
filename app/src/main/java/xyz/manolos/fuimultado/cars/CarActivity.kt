package xyz.manolos.fuimultado.cars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_car.*
import xyz.manolos.fuimultado.R

class CarActivity : AppCompatActivity() {

    private lateinit var presenter: CarPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)

        presenter = CarPresenter(this)

        addCarButton.setOnClickListener {
            //TODO: Chama popup
        }
    }
}
