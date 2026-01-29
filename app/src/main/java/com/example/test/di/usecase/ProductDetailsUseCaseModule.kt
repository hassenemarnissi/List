package com.example.test.di.usecase

import com.example.domain.productdetails.usecase.ProductDetailsUseCase
import com.example.domain.productdetails.usecase.ProductDetailsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductDetailsUseCaseModule {
    @Binds
    abstract fun bindProductDetailsUseCase(
        impl: ProductDetailsUseCaseImpl
    ): ProductDetailsUseCase
}