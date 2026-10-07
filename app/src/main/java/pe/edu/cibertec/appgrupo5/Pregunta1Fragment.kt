package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import pe.edu.cibertec.appgrupo5.databinding.FragmentPregunta1Binding
import java.util.Locale

class Pregunta1Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPregunta1Binding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcularPreg3.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnCalcularPreg3 -> {
                calcularSobredimension()
            }
        }
    }

    fun calcularSobredimension() {

        val textoLongitud = binding.edtLongitud.text.toString().trim()

        if (textoLongitud.isBlank()) {
            Toast.makeText(
                requireContext(),
                "Ingrese la longitud de la carga",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val longitud = textoLongitud.toDoubleOrNull()

        if (longitud == null || longitud < 0) {
            Toast.makeText(
                requireContext(),
                "Ingrese una longitud válida",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        if (longitud <= 12) {
            binding.txtResultadoPreg3.text =
                "Carga dentro de las dimensiones permitidas."
        } else {

            val exceso = longitud - 12
            val sobrecargo = 400.00 + (exceso * 120.00)

            binding.txtResultadoPreg3.text = String.format(
                Locale.US,
                "Longitud ingresada: %.2f m\n" +
                        "Exceso de metros: %.2f m\n" +
                        "Sobrecargo total: S/ %.2f",
                longitud,
                exceso,
                sobrecargo
            )
        }
    }
}