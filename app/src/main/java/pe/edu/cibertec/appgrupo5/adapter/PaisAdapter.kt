package pe.edu.cibertec.appgrupo5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import pe.edu.cibertec.appgrupo5.databinding.ItemPaisBinding
import pe.edu.cibertec.appgrupo5.model.Pais

class PaisAdapter(private  var listaPais: List<Pais>): RecyclerView.Adapter<PaisAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemPaisBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemPaisBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        with(holder){
            with(listaPais[position]){
                binding.tvPaisPregunta5.text=nombre
                Glide.with((itemView.context))
                    .load(imagenUrl)
                    .into(binding.ivPaisPregunta5)
            }
        }
    }

    override fun getItemCount()= listaPais.size


}