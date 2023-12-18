package com.example.calculapagos

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {

    override fun calculaLiquido(): Double {
        val porcentajeDescuento = 0.20
        val sueldoLiquido = sueldo - (sueldo * porcentajeDescuento)
        return sueldoLiquido
    }
}