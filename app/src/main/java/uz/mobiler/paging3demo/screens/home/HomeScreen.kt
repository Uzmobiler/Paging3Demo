package uz.mobiler.paging3demo.screens.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import uz.mobiler.paging3demo.navigation.Screen
import uz.mobiler.paging3demo.screens.common.ListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()

    Scaffold(topBar = {
        HomeTopBar {
            navHostController.navigate(Screen.Search.route)
        }
    }, content = {
        ListContent(items = getAllImages)
    })
}