package pe.edu.cibertec.appgrupo5.retrofit
import okhttp3.OkHttpClient
import pe.edu.cibertec.appgrupo5.retrofit.api.IPostService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ClientePostRetrofit {

    // Configuración de OkHttpClient con timeouts
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    // Construcción de Retrofit
    private fun buildRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/") // Base URL de la API
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Servicio de Posts
    val retrofitPostService: IPostService by lazy {
        buildRetrofit().create(IPostService::class.java)
    }
}