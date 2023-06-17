package com.cranaya.inc.screens.profile.update

import android.media.Image

data class ProfileUpdateState(
    val name: String = "",
    val lastname: String = "",
    val phone: String = "",
    val image: String? = null
)
