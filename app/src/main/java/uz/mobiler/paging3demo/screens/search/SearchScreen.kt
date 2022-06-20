package uz.mobiler.paging3demo.screens.search

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import uz.mobiler.paging3demo.screens.common.ListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navHostController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery
    val searchedImages = searchViewModel.searchedImages.collectAsLazyPagingItems()

    Scaffold(topBar = {
        SearchWidget(text = searchQuery, onTextChange = {
            searchViewModel.updateSearchQuery(query = it)
        }, onSearchClicked = {
            searchViewModel.searchHeroes(query = it)
        }) {
            navHostController.popBackStack()
        }
    }, content = {
        ListContent(items = searchedImages)
    })
}