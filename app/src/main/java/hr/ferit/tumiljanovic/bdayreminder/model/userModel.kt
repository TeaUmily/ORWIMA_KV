package hr.ferit.tumiljanovic.bdayreminder.model

data class UserResponse(val id: String = "",
                        val username: String = "",
                        val email: String = "")

data class User(val id: String,
                val firstName: String,
                val lastName: String,
                val email: String,
                val birthDate: String ="",
                val password: String = "",
                var image: String="",
                var color: String="Purple"
                )