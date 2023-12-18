package com.example.calculapagos


abstract class Empleado(sueldoBruto: Double) {

    val sueldo : Double
    init {
        this.sueldo = sueldoBruto
    }
    abstract fun calculaLiquido(): Double
}