package com.example.calculapagos


class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {

    override fun calculaLiquido(): Double {
        val porcentajeDescuento = 0.13
        val sueldoLiquido = sueldo - (sueldo * porcentajeDescuento)
        return sueldoLiquido
    }
}