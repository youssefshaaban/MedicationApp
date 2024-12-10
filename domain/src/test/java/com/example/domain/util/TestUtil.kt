package com.example.domain.util

import com.example.domain.entity.MedicationEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object TestUtil {


    fun createAllMedication(): Flow<Resource<List<MedicationEntity>>> {
        // Create a map of currencies for the mock response


        // Create a Response object with your mock data
        return flowOf(Resource.Success(data = buildList {
            repeat(10,{
                add(MedicationEntity("","asprin$it","500 mg"))
            })
        }))
    }

}