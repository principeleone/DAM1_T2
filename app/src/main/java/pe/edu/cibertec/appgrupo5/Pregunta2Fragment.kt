package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import pe.edu.cibertec.appgrupo5.databinding.FragmentPregunta2Binding
import java.util.Locale
import kotlin.toString

class Pregunta2Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta2Binding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPregunta2Binding.inflate(
            inflater,
            container,
            false
        )
        //return inflater.inflate(R.layout.fragment_pregunta2, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcularPreg4.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnCalcularPreg4 -> {
                calcularDemurrage()
            }
        }
    }

    fun calcularDemurrage() {

        val textoDias = binding.edtDias.text.toString().trim()

        if (textoDias.isBlank()) {
            Toast.makeText(
                requireContext(),
                "Ingrese los días transcurridos",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val dias = textoDias.toIntOrNull()

        if (dias == null || dias < 0) {
            Toast.makeText(
                requireContext(),
                "Ingrese una cantidad de días válida",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        if (dias <= 7) {
            binding.txtResultadoPreg4.text =
                "Contenedor retornado dentro de los días libres."
        } else {

            val diasMora = dias - 7
            val demurrage = 200.00 + (diasMora * 75.00)
            binding.txtResultadoPreg4.text = String.format(
                Locale.US,
                "Días totales transcurridos: %d\n" +
                        "Días de mora: %d\n" +
                        "Monto de demurrage liquidado: S/ %.2f",
                dias,
                diasMora,
                demurrage
            )
        }
    }

}