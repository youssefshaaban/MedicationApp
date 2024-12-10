package com.example.data.repositories


import com.example.data.remote.MedicationAPI
import com.example.data.util.TestUtil.createAllMedicationResponse
import com.example.domain.util.Resource
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MedicationRepositoryImpTest {
    private val medicationAPI: MedicationAPI = mockk()
    lateinit var medicationRepositoryImp: MedicationRepositoryImp

    @Before
    fun setUp() {
        medicationRepositoryImp = MedicationRepositoryImp(medicationAPI)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }


    @Test
    fun `getAll medication should return success when API call succeeds`() = runTest {
        // Mock API response
        val mockResponse=createAllMedicationResponse()
        coEvery { medicationAPI.getMedication() } returns mockResponse
        // Collect and assert the result
        val result = medicationRepositoryImp.getMedications().first()
        assert(result is Resource.Success)
        coVerify { medicationAPI.getMedication() }
    }

    @Test
    fun `get All medication should return error when API call fails`() = runTest {
        val characterId = 1
        coEvery { medicationAPI.getMedication() }returns  Response.error(500,"str".toResponseBody())

        val result = medicationRepositoryImp.getMedications().first()
        assert(result is Resource.Error)

        coVerify { medicationAPI.getMedication() }
    }

}