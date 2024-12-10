package com.example.taskapp.ui.navigation


sealed class NavRoute(val path: String) {

    data object Login : NavRoute("login")


    data object Home : NavRoute("home") {
        val userName: String = "userName"
    }


    // build navigation path (for screen navigation)
    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    // build and setup route format (in navigation graph)
    fun withArgsFormat(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }
}

