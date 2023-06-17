package com.cranaya.inc.navigation.screen.profile

import com.cranaya.inc.navigation.screen.auth.AuthScreen

sealed class ProfileScreen(val route: String) {
    object ProfileUpdate: ProfileScreen("profile/update")

}
