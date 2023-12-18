package com.example.calculapagos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculapagos.ui.theme.CalculaPagosTheme

class EmpleadoHonorarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            pantallaHonorarios()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun pantallaHonorarios() {
    var sueldo by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    val contexto = LocalContext.current as ComponentActivity

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sueldo Honorarios",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            placeholder = { Text("Ingresa el sueldo") },
            value = sueldo,
            onValueChange = {sueldo = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            try {
                val sueldoCalculado = EmpleadoHonorarios(sueldo.toDouble()).calculaLiquido()
                resultado = "El sueldo es: $sueldoCalculado"
            } catch (e: NumberFormatException) {
                resultado = "Error: Ingresa un valor numérico válido."
            }
        }) {
            Text(text = "Calcular Sueldo Honorarios")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("$resultado")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { contexto.finish() }) {
            Text(text = "Volver")
        }
    }
}

