package com.cranaya.inc.navigation.screen.roles


sealed class RolesScreen(val route: String) {
    object Roles: RolesScreen("roles")

}
