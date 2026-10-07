package pe.edu.cibertec.appgrupo5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.appgrupo5.retrofit.response.Post
import pe.edu.cibertec.appgrupo5.databinding.ItemPostBinding


class PostAdapter(private val lista: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = lista[position]
        holder.binding.tvTitle.text = post.title
        holder.binding.tvBody.text = post.body
        holder.binding.tvViews.text = "Views: ${post.views}"
        holder.binding.tvUserId.text = "User: ${post.userId}"

        // Imagen random para cada post
        Glide.with(holder.itemView.context)
            .load("https://picsum.photos/200/300?random=${post.id}")
            .into(holder.binding.ivPost)
    }

    override fun getItemCount(): Int = lista.size
}