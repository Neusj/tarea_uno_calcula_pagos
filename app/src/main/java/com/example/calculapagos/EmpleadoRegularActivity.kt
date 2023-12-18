package com.example.calculapagos

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class EmpleadoRegularActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ R.layout.activity_empleado_regular)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            val resultado = findViewById<TextView>(R.id.tvResultado)
            val sueldo = findViewById<EditText>(R.id.etSueldo)
            val sueldoInt = sueldo.text.toString().toDouble()

            val sueldoCalculado = EmpleadoRegular(sueldoInt).calculaLiquido()
            resultado.text = "El sueldo es: ${sueldoCalculado}"
        }
    }

    fun volverAtras(view: View) {
        finish()
    }
}
