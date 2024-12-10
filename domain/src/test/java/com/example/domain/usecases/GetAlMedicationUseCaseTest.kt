package com.example.domain.usecases

import com.example.domain.repositories.IMedicationRepository
import com.example.domain.util.TestUtil
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class GetAlMedicationUseCaseTest {
    private lateinit var iMedicationRepository: IMedicationRepository

    @Before
    fun setUp() {

        iMedicationRepository = mockk()
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    operator fun invoke() {
        runTest {
            val mockResult=TestUtil.createAllMedication()
            coEvery { iMedicationRepository.getMedications() } returns mockResult
            val result = GetAllMedicationUseCase(iMedicationRepository).invoke()
            coVerify { iMedicationRepository.getMedications() }
            assertEquals(result,mockResult)
        }
    }
}