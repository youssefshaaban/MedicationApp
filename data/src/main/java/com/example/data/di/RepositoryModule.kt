package com.example.data.di


import com.example.data.repositories.MedicationRepositoryImp
import com.example.domain.repositories.IMedicationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCharactersRepo(iMedicationRepository: MedicationRepositoryImp): IMedicationRepository
}
