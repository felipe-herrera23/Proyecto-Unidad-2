package mx.tecnm.examenunidad2

object Datos {
    val autos: ArrayList<Auto> = arrayListOf()
}

data class Auto(val marca: String, val Modelo: String, val año: Int, val precio: Double, val estado: String){
    val imagen = if(marca == "Audi")R.drawable.audi else if (marca == "Aston Martin")R.drawable.aston else if(marca == "Chevrolet") R.drawable.chevrolet else if(marca == "Dodge")R.drawable.dodge else if (marca == "Ford")R.drawable.ford else if (marca == "GMC")R.drawable.gmc else if(marca == "Hyundai")R.drawable.hyundai else if(marca == "Honda")R.drawable.honda else if(marca == "KIA")R.drawable.kia else if(marca == "Mazda")R.drawable.mazda else if (marca == "Mercedes")R.drawable.mercedes else if(marca == "Nissan")R.drawable.nissan else R.drawable.toyota
}