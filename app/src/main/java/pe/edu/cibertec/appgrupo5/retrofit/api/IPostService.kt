package pe.edu.cibertec.appgrupo5.retrofit.api

import pe.edu.cibertec.appgrupo5.retrofit.response.ResultPost
import retrofit2.Call
import retrofit2.http.GET

interface IPostService {
    @GET("posts")
    fun getPosts(): Call<ResultPost>
}