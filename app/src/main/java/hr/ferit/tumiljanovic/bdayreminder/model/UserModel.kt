package hr.ferit.tumiljanovic.bdayreminder.model


import com.google.firebase.database.IgnoreExtraProperties

data class UserResponse(val id: String = "",
                        val username: String = "",
                        val email: String = "")

@IgnoreExtraProperties
data class User(val id: String = "",
                val firstName: String = "",
                val lastName: String = "",
                val email: String = "",
                val birthDate: String = "",
                val password: String = "",
                var image: String = "",
                var color: String = "Purple",
                var idPresent: Map<String, String> = HashMap(),
                var idNotification: Map<String, Boolean> = HashMap(),
                var myGroups: List<Group> = ArrayList(),
                var joinedGroups: List<Group> = ArrayList()
)

