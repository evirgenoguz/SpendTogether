package com.evirgenoguz.model

data class User(
    var uid: String,
    var nickName: String,
    var email: String,
    var imagePath: String = ""
)