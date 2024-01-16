package com.evirgenoguz.network.di

import com.evirgenoguz.network.source.rest.RestDataSource
import com.evirgenoguz.network.source.rest.RestDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {

    @Binds
    @Singleton
    abstract fun bindRestDataSource(restDataSource: RestDataSourceImpl): RestDataSource
    
}