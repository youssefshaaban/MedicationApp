package com.example.domain.repositories


import com.example.domain.entity.MedicationEntity
import com.example.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface IMedicationRepository {

    suspend fun getMedications():Flow<Resource<List<MedicationEntity>>>
}