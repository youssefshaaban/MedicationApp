package com.example.domain.usecases


import com.example.domain.entity.MedicationEntity
import com.example.domain.repositories.IMedicationRepository
import com.example.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllMedicationUseCase @Inject constructor(private val iMedicationRepository: IMedicationRepository) {
    suspend operator fun invoke(): Flow<Resource<List<MedicationEntity>>> = iMedicationRepository.getMedications()
}