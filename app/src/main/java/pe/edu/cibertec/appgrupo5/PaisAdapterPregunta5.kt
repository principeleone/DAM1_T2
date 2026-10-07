package pe.edu.cibertec.appgrupo5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.appgrupo5.databinding.ItemPaisPregunta5Binding

class PaisAdapterPregunta5(
    private val listaPaisesPregunta5: List<PaisPregunta5>,
    private val listenerPregunta5: View.OnClickListener
) : RecyclerView.Adapter<PaisAdapterPregunta5.PaisViewHolder>() {

    inner class PaisViewHolder(
        private val binding: ItemPaisPregunta5Binding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun enlazar(pais: PaisPregunta5) {
            binding.tvPaisPregunta5.text = pais.nombre

            binding.cardPaisPregunta5.tag = pais
            binding.cardPaisPregunta5.setOnClickListener(listenerPregunta5)

            Glide.with(binding.ivPaisPregunta5)
                .load(pais.imagenUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .centerCrop()
                .into(binding.ivPaisPregunta5)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisViewHolder {
        val binding = ItemPaisPregunta5Binding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PaisViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaisViewHolder, position: Int) {
        holder.enlazar(listaPaisesPregunta5[position])
    }

    override fun getItemCount(): Int = listaPaisesPregunta5.size
}