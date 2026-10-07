package pe.edu.cibertec.appgrupo5.retrofit.response

data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val views: Int,
    val userId: Int
)