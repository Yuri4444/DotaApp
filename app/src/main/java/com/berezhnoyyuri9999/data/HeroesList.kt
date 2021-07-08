package com.berezhnoyyuri9999.data

import com.google.gson.annotations.SerializedName

class HeroesList {
    @SerializedName("id")
    var id : Int? = 0
    @SerializedName("localized_name")
    var name: String? = ""
}
