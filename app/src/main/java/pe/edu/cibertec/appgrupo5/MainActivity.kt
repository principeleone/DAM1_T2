package pe.edu.cibertec.appgrupo5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo5.databinding.ActivityMainBinding
import pe.edu.cibertec.appgrupo5.model.Usuario

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private val listaUsuarios = listOf(
        Usuario("202506387", "46839109")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnLoginIngresar.setOnClickListener (this)
    }
    private fun login(){
        val usuario = binding.etUsuario.text.toString().trim()
        val clave = binding.etClave.text.toString().trim()

        if(usuario.isEmpty() || clave.isEmpty()){
            Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show()
            return
        }



        if (loginCoincidencia(usuario,clave)){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        } else{
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }

    }

    private fun loginCoincidencia(usuario: String,clave: String): Boolean{
        return listaUsuarios.any{
            it.codigo == usuario && it.dni == clave
        }
    }

    override fun onClick(v: View?) {
        login()
    }
}