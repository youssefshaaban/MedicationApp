package com.example.data.remote


import com.example.data.model.MedicationResponse
import retrofit2.Response
import retrofit2.http.GET



interface MedicationAPI {
    @GET("v3/cb16f8db-6be5-4c39-899e-f1830d68f9cf")
    suspend fun getMedication(): Response<MedicationResponse>
}