package com.example.a08

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a08.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os elementos da interface
        val temperatureInput = findViewById<EditText>(R.id.temperatureInput)
        val conversionGroup = findViewById<RadioGroup>(R.id.conversionGroup)
        val celsiusToFahrenheit = findViewById<RadioButton>(R.id.celsiusToFahrenheit)
        val fahrenheitToCelsius = findViewById<RadioButton>(R.id.fahrenheitToCelsius)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        convertButton.setOnClickListener {
            val temperatureText = temperatureInput.text.toString()

            if (temperatureText.isNotEmpty()) {
                val temperature = temperatureText.toDoubleOrNull()

                if (temperature != null) {
                    val result = when (conversionGroup.checkedRadioButtonId) {
                        R.id.celsiusToFahrenheit -> (temperature * 9/5) + 32
                        R.id.fahrenheitToCelsius -> (temperature - 32) * 5/9
                        else -> null
                    }

                    if (result != null) {
                        resultText.text = "Resultado: %.2f".format(result)
                    } else {
                        resultText.text = "Selecione uma opção de conversão."
                    }
                } else {
                    resultText.text = "Por favor, insira uma temperatura válida."
                }
            } else {
                resultText.text = "Por favor, insira um valor."
            }
        }
    }
}
