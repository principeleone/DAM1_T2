package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo5.adapter.PaisAdapter
import pe.edu.cibertec.appgrupo5.databinding.FragmentPregunta3Binding
import pe.edu.cibertec.appgrupo5.model.Pais

class Pregunta3Fragment : Fragment() {
    private var _binding: FragmentPregunta3Binding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPregunta3Binding.inflate(
            inflater,
            container,
            false
        )
        //return inflater.inflate(R.layout.fragment_pregunta2, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.rvPregunta5.layoutManager= LinearLayoutManager(view.context)
        binding.rvPregunta5.adapter= PaisAdapter(obtenerPais())
    }


    fun obtenerPais(): List<Pais>{
        return listOf(
            Pais("España", "https://picsum.photos/seed/espana/800/450"),
            Pais("Francia", "https://picsum.photos/seed/francia/800/450"),
            Pais("Italia", "https://picsum.photos/seed/italia/800/450"),
            Pais("Alemania", "https://picsum.photos/seed/alemania/800/450"),
            Pais("Portugal", "https://picsum.photos/seed/portugal/800/450"),
            Pais("Países Bajos", "https://picsum.photos/seed/paisesbajos/800/450"),
            Pais("Bélgica", "https://picsum.photos/seed/belgica/800/450"),
            Pais("Suiza", "https://picsum.photos/seed/suiza/800/450"),
            Pais("Austria", "https://picsum.photos/seed/austria/800/450"),
            Pais("Grecia", "https://picsum.photos/seed/grecia/800/450"),
            Pais("Suecia", "https://picsum.photos/seed/suecia/800/450"),
            Pais("Noruega", "https://picsum.photos/seed/noruega/800/450"),
            Pais("Finlandia", "https://picsum.photos/seed/finlandia/800/450"),
            Pais("Dinamarca", "https://picsum.photos/seed/dinamarca/800/450"),
            Pais("Polonia", "https://picsum.photos/seed/polonia/800/450"),
            Pais("Chequia", "https://picsum.photos/seed/chequia/800/450"),
            Pais("Irlanda", "https://picsum.photos/seed/irlanda/800/450"),
            Pais("Croacia", "https://picsum.photos/seed/croacia/800/450"),
            Pais("Islandia", "https://picsum.photos/seed/islandia/800/450"),
            Pais("Rumanía", "https://picsum.photos/seed/rumania/800/450"))
    }
}