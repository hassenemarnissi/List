package com.example.test.di.core

import com.example.presentation.utils.DispatchersWrapper
import com.example.presentation.utils.DispatchersWrapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @Provides
    fun provideDispatchers(): DispatchersWrapper = DispatchersWrapperImpl()
}