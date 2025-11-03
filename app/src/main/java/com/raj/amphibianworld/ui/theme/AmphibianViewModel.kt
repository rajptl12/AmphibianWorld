package com.raj.amphibianworld.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raj.amphibianworld.data.AmphibianModel
import com.raj.amphibianworld.data.AmphibianRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface AmphibianUiState {
    object Loading : AmphibianUiState
    data class Success(val amphibians: List<AmphibianModel>) : AmphibianUiState
    data class Error(val message: String) : AmphibianUiState
}

class AmphibianViewModel(
    private val repository: AmphibianRepository = AmphibianRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<AmphibianUiState>(AmphibianUiState.Loading)
    val uiState: StateFlow<AmphibianUiState> = _uiState

    init {
        fetchAmphibians()
    }

    fun fetchAmphibians() {
        viewModelScope.launch {
            _uiState.value = AmphibianUiState.Loading
            try {
                val data = repository.getAmphibians()
                _uiState.value = AmphibianUiState.Success(data)
            } catch (e: Exception) {
                _uiState.value = AmphibianUiState.Error("Failed to load amphibians 🐸")
            }
        }
    }
}
