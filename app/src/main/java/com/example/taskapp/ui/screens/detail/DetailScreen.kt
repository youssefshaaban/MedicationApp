package com.example.taskapp.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskapp.ui.component.MedicationItem

@Composable
fun MedicationDetails(medicationEntity: MedicationEntityUi) {
    Column (modifier = Modifier.fillMaxSize().padding(10.dp)){
        MedicationItem(modifier = Modifier, medicationEntity)
    }

}