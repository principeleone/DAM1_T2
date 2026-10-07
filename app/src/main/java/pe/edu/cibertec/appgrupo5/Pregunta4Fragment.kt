package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo5.adapter.PostAdapter
import pe.edu.cibertec.appgrupo5.databinding.FragmentPregunta4Binding
import pe.edu.cibertec.appgrupo5.retrofit.ClientePostRetrofit
import pe.edu.cibertec.appgrupo5.retrofit.response.ResultPost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta4Fragment : Fragment() {

    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvPosts.layoutManager = LinearLayoutManager(requireContext())

        // Llamada al servicio Retrofit
        ClientePostRetrofit.retrofitPostService.getPosts().enqueue(object : Callback<ResultPost> {
            override fun onResponse(call: Call<ResultPost>, response: Response<ResultPost>) {
                if (response.isSuccessful) {
                    val posts = response.body()?.posts ?: emptyList()
                    binding.rvPosts.adapter = PostAdapter(posts)
                }
            }

            override fun onFailure(call: Call<ResultPost>, t: Throwable) {
                // Aquí puedes mostrar un Toast o loguear el error
                t.printStackTrace()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
