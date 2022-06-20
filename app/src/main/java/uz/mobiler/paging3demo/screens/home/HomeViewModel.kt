package uz.mobiler.paging3demo.screens.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.mobiler.paging3demo.data.repository.Repository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: Repository) :ViewModel(){

    val getAllImages = repository.getAllImages()
}