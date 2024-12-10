package com.example.taskapp.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(userName:String){
    val viewModel= hiltViewModel<HomeViewModel>()
    val uiState=viewModel.uiState.collectAsState()
    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(userName, modifier = Modifier.align(Alignment.Center).padding(10.dp), fontSize = 20.sp)
        }

        when(uiState.value){
            is ViewState.Loading ->{
                Column (modifier = Modifier.fillMaxSize()) {
                    Text((uiState.value as ViewState.Error).error)
                }
            }
            is ViewState.Success->{

            }
            is ViewState.Error->{
                Column (modifier = Modifier.fillMaxSize()) {
                    Text((uiState.value as ViewState.Error).error)
                }
            }
        }

    }

}