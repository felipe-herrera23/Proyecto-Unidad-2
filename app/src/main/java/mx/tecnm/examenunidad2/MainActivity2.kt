package mx.tecnm.examenunidad2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    //Felipe Joaquín Herrera Serrano
    //17100237
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val spinner: Spinner = findViewById(R.id.spinnerMarcas)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
                R.array.marcas_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner.isSelected = false
            spinner.setSelection(0, true)
            spinner.onItemSelectedListener = this

            val spinnerAño: Spinner = findViewById(R.id.spinnerAños)
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter.createFromResource(
                    this,
                    R.array.años_array,
                    android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinnerAño.adapter = adapter
                spinnerAño.isSelected = false
                spinnerAño.setSelection(0, true)
                spinnerAño.onItemSelectedListener = this
            }
        }

        btnPublicar.setOnClickListener {
                AlertDialog.Builder(this).apply {
                    setTitle("Confirmación")
                    setMessage("¿Seguro que deseas guardar?")
                    setPositiveButton("Aceptar") { _: DialogInterface, _: Int ->
                        Clear()

                        Snackbar.make(btnPublicar, "Tu información se guardó con éxito", Snackbar.LENGTH_LONG).setAction("VOLVER", View.OnClickListener {
                            cerrarActivity()
                            Toast.makeText(applicationContext,"¡Tu auto fue publicado!",Toast.LENGTH_LONG).show()
                        }).show()
                    }
                    setNegativeButton("Cancelar", null)
                }.show()
                val marca = (spinnerMarcas.getSelectedItem().toString())
                val modelo = txtmodelo.text.toString()
                val año = (spinnerAños.getSelectedItem().toString()).toInt()
                var precio = editPrecio.text.toString().toDouble()
                var estado = if (chEstado.isChecked) "Nuevo" else "Usado"
                Datos.autos.add(Auto(marca, modelo, año, precio, estado))
            }
        }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //Toast.makeText(this,"No se permiten campos vacíos", Toast.LENGTH_LONG).show()
    }

    fun Clear()
    {
        spinnerMarcas.setSelection(0)
        txtmodelo.setText("")
        editPrecio.setText("")
        spinnerAños.setSelection(0)
        chEstado.isChecked = false
    }

    fun cerrarActivity(){
        //Intent Explícita
        val intent = Intent(this, MainActivity::class.java)
        finish()

    }
}