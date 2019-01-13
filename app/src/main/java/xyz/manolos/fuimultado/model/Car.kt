package xyz.manolos.fuimultado.model

data class Car(
    val name: String,
    val plate: String = "a",
    val renavam: String = "b",
    val fines: List<Fine> = emptyList()
)
