package com.example.taskapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.domain.entity.MedicationEntity
import com.example.taskapp.ui.screens.detail.MedicationDetails
import com.example.taskapp.ui.screens.detail.MedicationEntityUi
import com.example.taskapp.ui.screens.home.HomeScreen
import com.example.taskapp.ui.screens.login.LoginScreen


@Composable
fun NavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoute.Login.path
    ) {
        addLoginScreen(navController, this)

        addHomeScreen(navController, this)

        addMedicationScreen(navController, this)
    }
}

fun addMedicationScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(NavRoute.Detail.path) {
        val result: MedicationEntityUi? = navController.previousBackStackEntry?.savedStateHandle?.get<MedicationEntityUi>(NavRoute.Detail.detailItem)
        result?.let {
            MedicationDetails(it)
        }
    }
}

fun addHomeScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavRoute.Home.withArgsFormat(NavRoute.Home.userName)) { navBackStackEntry ->
        val charactersId = navBackStackEntry.arguments?.getString(NavRoute.Home.userName, "")
        /* We check if it's not null */
        charactersId?.let { userName ->
            HomeScreen(userName) { medication ->
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    NavRoute.Detail.detailItem,
                    medication
                )
                navController.navigate(NavRoute.Detail.path)
            }
        }

    }
}

fun addLoginScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavRoute.Login.path) {
        LoginScreen { userName ->
            navController.navigate(NavRoute.Home.withArgs(userName)) {
                popUpTo(NavRoute.Login.path) {
                    inclusive = true
                }
            }

        }
    }

}
