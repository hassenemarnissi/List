package com.example.test.di.usecase


import com.example.domain.productlist.usecase.ProductListUseCase
import com.example.domain.productlist.usecase.ProductListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductUseCaseModule {

    @Binds
    abstract fun bindProductListUseCase(
        impl: ProductListUseCaseImpl
    ): ProductListUseCase
}
