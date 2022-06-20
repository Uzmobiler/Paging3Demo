package uz.mobiler.paging3demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.mobiler.paging3demo.screens.home.HomeScreen
import uz.mobiler.paging3demo.screens.search.SearchScreen

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navHostController = navHostController)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navHostController = navHostController)
        }
    }
}