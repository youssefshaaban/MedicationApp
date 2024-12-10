package com.example.data.model

import com.example.domain.entity.MedicationEntity

data class Medication(
    val dose: String,
    val name: String,
    val strength: String
)

data class MedicationResponse(val medications:List<Medication>)

fun Medication.toMedicationEntity()= MedicationEntity(dose=this.dose,name=this.name, strength = this.strength)
