package hr.ferit.tumiljanovic.bdayreminder.model

data class Group(
        val id : String,
        val groupName : String,
        val administratorId : String,
        val requests : List<String> = ArrayList()
        )