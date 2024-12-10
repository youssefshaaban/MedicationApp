package com.example.taskapp.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.LoginUseCase
import com.example.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase):ViewModel() {

    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName

    private val _password= MutableStateFlow("")
    val password: StateFlow<String> = _password
    private val _navigateToHome= MutableSharedFlow<Boolean>()
    val navigateToHome: SharedFlow<Boolean> = _navigateToHome

    fun onChangeUserName(username: String){
        _userName.value=username
    }
    fun onChangePassword(username: String){
        _password.value=username
    }

    fun onLoginClick() {
        viewModelScope.launch {
             loginUseCase(password = password.value, userName = password.value).collectLatest {
                 result->
                 when(result){
                     is Resource.Success->{
                         _navigateToHome.emit(true)
                     }
                     is Resource.Error->{

                     }
                 }
             }
        }
    }

}