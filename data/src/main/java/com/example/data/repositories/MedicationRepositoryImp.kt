package com.example.data.repositories

import com.example.data.model.toMedicationEntity
import com.example.data.remote.MedicationAPI
import com.example.data.utils.apiCall
import com.example.domain.entity.MedicationEntity
import com.example.domain.repositories.IMedicationRepository
import com.example.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MedicationRepositoryImp @Inject constructor(private val medicationApi:MedicationAPI):IMedicationRepository {
    override suspend fun getMedications(): Flow<Resource<List<MedicationEntity>>> {
        return flow {
               val result= apiCall { medicationApi.getMedication() }
                when(result){
                    is Resource.Success->{
                        emit(Resource.Success(result.data.medications.map { it.toMedicationEntity() }))
                    }
                    is Resource.Error->{
                        emit(Resource.Error(result.error))
                    }
                }
        }
    }
}