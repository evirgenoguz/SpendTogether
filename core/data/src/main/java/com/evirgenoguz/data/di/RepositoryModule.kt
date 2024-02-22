package com.evirgenoguz.data.di

import com.evirgenoguz.data.AuthRepository
import com.evirgenoguz.data.AuthRepositoryImpl
import com.evirgenoguz.data.SampleRepository
import com.evirgenoguz.data.SampleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSampleRepository(sampleRepositoryImpl: SampleRepositoryImpl): SampleRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

}