package com.evirgenoguz.presentation.di

import android.content.Context
import com.evirgenoguz.presentation.loading.IndicatorPresenter
import com.evirgenoguz.presentation.loading.IndicatorPresenterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

/**
 * @Author: Oguz Evirgen
 * @Date: 10.03.2024
 */

@Module
@InstallIn(ActivityComponent::class)
object PresentationModule {

    @Provides
    @ActivityScoped
    fun provideIndicatorPresenter(@ActivityContext context: Context): IndicatorPresenter =
        IndicatorPresenterImpl(context)
}