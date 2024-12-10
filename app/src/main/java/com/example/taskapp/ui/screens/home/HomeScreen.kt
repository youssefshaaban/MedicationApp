package com.example.taskapp.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.entity.MedicationEntity
import com.example.taskapp.ui.component.MedicationItem
import com.example.taskapp.ui.screens.detail.MedicationEntityUi
import kotlinx.collections.immutable.PersistentList

@Composable
fun HomeScreen(userName: String,onClickItem:(MedicationEntityUi)->Unit) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val uiState = viewModel.uiState.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                userName,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(10.dp),
                fontSize = 20.sp
            )
        }

        when (uiState.value) {
            is ViewState.Loading -> {
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(color = Color.Blue)
                }
            }

            is ViewState.Success -> {

                RenderMedication((uiState.value as ViewState.Success).medication,onClickItem)
            }

            is ViewState.Error -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text((uiState.value as ViewState.Error).error)
                }
            }
        }

    }

}

@Composable
fun RenderMedication(medications: PersistentList<MedicationEntityUi>,onClickItem:(MedicationEntityUi)->Unit) {

    LazyColumn {
        items(medications) { medication ->
            MedicationItem(modifier = Modifier.clickable { onClickItem(medication) }, medication)
        }
    }
}
