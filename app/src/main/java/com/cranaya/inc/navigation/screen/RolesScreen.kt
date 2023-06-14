package com.cranaya.inc.navigation.screen

sealed class RolesScreen(val route: String) {
    object Roles: AuthScreen("roles")

}
