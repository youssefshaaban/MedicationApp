package com.example.taskapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.taskapp.R
import com.example.taskapp.ui.screens.detail.MedicationEntityUi

@Composable
fun MedicationItem(modifier: Modifier,medicationEntity: MedicationEntityUi,){

    Card(modifier = modifier.fillMaxSize().padding(10.dp)) {
        Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
            Row {
                Text(stringResource(R.string.name), fontSize = 16.sp)
                Spacer(modifier.size(width = 10.dp, height = 0.dp))
                Text(medicationEntity.name, fontSize = 16.sp)
            }
            Spacer(modifier.size(width = 0.dp, height = 10.dp))
            Row {
                Text(stringResource(R.string.dose), fontSize = 16.sp)
                Spacer(modifier.size(width = 10.dp, height = 0.dp))
                Text(medicationEntity.dose, fontSize = 16.sp)
            }
            Spacer(modifier.size(width = 0.dp, height = 10.dp))
            Row {
                Text(stringResource(R.string.strength), fontSize = 16.sp)
                Spacer(modifier.size(width = 10.dp, height = 0.dp))
                Text(medicationEntity.strength, fontSize = 16.sp)
            }
            Spacer(modifier.size(width = 0.dp, height = 10.dp))
        }
    }
}