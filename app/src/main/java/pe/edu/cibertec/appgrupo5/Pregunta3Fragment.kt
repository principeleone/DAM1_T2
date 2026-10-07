package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo5.databinding.FragmentPregunta3Binding

class Pregunta3Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    private lateinit var listenerPregunta5: View.OnClickListener

    private val listaPaisesPregunta5 = listOf(
        PaisPregunta5("España", "https://picsum.photos/seed/espana/800/450"),
        PaisPregunta5("Francia", "https://picsum.photos/seed/francia/800/450"),
        PaisPregunta5("Italia", "https://picsum.photos/seed/italia/800/450"),
        PaisPregunta5("Alemania", "https://picsum.photos/seed/alemania/800/450"),
        PaisPregunta5("Portugal", "https://picsum.photos/seed/portugal/800/450"),
        PaisPregunta5("Países Bajos", "https://picsum.photos/seed/paisesbajos/800/450"),
        PaisPregunta5("Bélgica", "https://picsum.photos/seed/belgica/800/450"),
        PaisPregunta5("Suiza", "https://picsum.photos/seed/suiza/800/450"),
        PaisPregunta5("Austria", "https://picsum.photos/seed/austria/800/450"),
        PaisPregunta5("Grecia", "https://picsum.photos/seed/grecia/800/450"),
        PaisPregunta5("Suecia", "https://picsum.photos/seed/suecia/800/450"),
        PaisPregunta5("Noruega", "https://picsum.photos/seed/noruega/800/450"),
        PaisPregunta5("Finlandia", "https://picsum.photos/seed/finlandia/800/450"),
        PaisPregunta5("Dinamarca", "https://picsum.photos/seed/dinamarca/800/450"),
        PaisPregunta5("Polonia", "https://picsum.photos/seed/polonia/800/450"),
        PaisPregunta5("Chequia", "https://picsum.photos/seed/chequia/800/450"),
        PaisPregunta5("Irlanda", "https://picsum.photos/seed/irlanda/800/450"),
        PaisPregunta5("Croacia", "https://picsum.photos/seed/croacia/800/450"),
        PaisPregunta5("Islandia", "https://picsum.photos/seed/islandia/800/450"),
        PaisPregunta5("Rumanía", "https://picsum.photos/seed/rumania/800/450")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listenerPregunta5 = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvPregunta5.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPregunta5.adapter = PaisAdapterPregunta5(
            listaPaisesPregunta5,
            listenerPregunta5
        )
    }

    override fun onClick(v: View?) {
        val pais = v?.tag as? PaisPregunta5 ?: return
        Toast.makeText(requireContext(), pais.nombre, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}