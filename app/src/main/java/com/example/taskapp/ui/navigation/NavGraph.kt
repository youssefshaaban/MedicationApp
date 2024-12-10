package com.example.taskapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.taskapp.ui.screens.home.HomeScreen
import com.example.taskapp.ui.screens.login.LoginScreen


@Composable
fun NavGraph(modifier: Modifier=Modifier,navController: NavHostController) {
    NavHost(modifier =modifier,
        navController = navController,
        startDestination = NavRoute.Login.path
    ) {
        addLoginScreen(navController, this)

        addHomeScreen(navController, this)
    }
}

fun addHomeScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavRoute.Home.withArgsFormat(NavRoute.Home.userName)) { navBackStackEntry->
        val charactersId = navBackStackEntry.arguments?.getString(NavRoute.Home.userName,"")
        /* We check if it's not null */
        charactersId?.let { userName->
            HomeScreen(userName)
        }

    }
}

fun addLoginScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route =NavRoute.Home.path ) {
        LoginScreen {
            userName->
            navController.navigate(NavRoute.Home.withArgs(userName))
        }
    }

}
