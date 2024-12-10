package com.example.data.util

import com.example.data.model.Medication
import com.example.data.model.MedicationResponse
import retrofit2.Response

object TestUtil {

    fun createAllMedicationResponse(): Response<MedicationResponse> {
        // Create a map of currencies for the mock response


        // Create a Response object with your mock data
        val list=buildList {
            repeat(10,{
                add(Medication("","asprin$it","500 mg"))
            })
        }
        return Response.success(MedicationResponse(list))
    }
}