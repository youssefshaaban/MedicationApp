package com.example.taskapp.ui.screens.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.MedicationEntity
import com.example.domain.usecases.GetAllMedicationUseCase
import com.example.domain.util.Resource
import com.example.taskapp.ui.screens.detail.MedicationEntityUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getAllMedicationUseCase: GetAllMedicationUseCase):ViewModel() {

    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)
    val uiState: StateFlow<ViewState> = _uiState

    init {
        viewModelScope.launch {
            getAllMedicationUseCase().collectLatest {
                when(it){
                    is Resource.Success->{
                        _uiState.value=ViewState.Success(it.data.map { MedicationEntityUi(it.dose,it.name,it.strength) }.toPersistentList())
                    }
                    is Resource.Error->{
                        _uiState.value=ViewState.Error("something wrong")
                    }
                }
            }
        }

    }


}
sealed class ViewState {
    data object Loading : ViewState()
    data class Success(val medication:PersistentList<MedicationEntityUi>) : ViewState()
    data class Error(val error: String) : ViewState()
}
