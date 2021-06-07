package mx.tecnm.examenunidad2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AutosAdapter(private val listener: (Auto) -> Unit):RecyclerView.Adapter<AutosAdapter.ViewHolder> (){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imagen: ImageView = view.findViewById(R.id.imgAuto)
        val marca: TextView = view.findViewById(R.id.txtMarca)
        val modelo: TextView = view.findViewById(R.id.txtModelo)
        val año: TextView = view.findViewById(R.id.txtAño)
        val precio: TextView = view.findViewById(R.id.txtPrecio)
        val estado: TextView = view.findViewById(R.id.txtEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.auto_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Datos.autos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.marca.text = "Marca: ${Datos.autos.get(position).marca}"
        holder.modelo.text = "Modelo: ${Datos.autos.get(position).Modelo}"
        holder.año.text = "Año: ${Datos.autos.get(position).año}"
        holder.precio.text = "Precio: ${Datos.autos.get(position).precio}"
        holder.imagen.setImageResource(Datos.autos.get(position).imagen)
        holder.estado.text = Datos.autos.get(position).estado

        holder.itemView.setOnClickListener {
            listener(Datos.autos.get(position))
        }
    }
}