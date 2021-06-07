package mx.tecnm.examenunidad2

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    //Felipe Joaquín Herrera Serrano
    //17100237
    lateinit var recycler: RecyclerView
    lateinit var adaptador: AutosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        /* findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/

        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        adaptador = AutosAdapter { m ->
            Snackbar.make(recycler, "Este auto está a la venta.", Snackbar.LENGTH_LONG).setAction("COMPARTIR", View.OnClickListener {
                compartir(m)
            }).show()
        }

        recycler.adapter = adaptador
    }

    override fun onResume() {
        super.onResume()
        adaptador.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //Menú.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.agregar_auto -> {
                abrirActivity2()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Intent Explícita
    fun abrirActivity2() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)

    }

    //Intent Implícita
    fun compartir(m: Auto) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "¡Nuevo auto ${m.marca} ${m.Modelo} ${m.año} en venta!")
            type = "text/plain"
        }
        // Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        }
    }
}