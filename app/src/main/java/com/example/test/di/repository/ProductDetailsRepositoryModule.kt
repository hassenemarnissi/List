package com.example.test.di.repository

import com.example.data.productdetails.repository.ProductDetailsRepositoryImpl
import com.example.data.productlist.repository.ProductListRepositoryImpl
import com.example.domain.productdetails.repository.ProductDetailsRepository
import com.example.domain.productlist.repository.ProductListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDetailsRepositoryModule {

    @Binds
    abstract fun bindProductDetailsRepository(
        impl: ProductDetailsRepositoryImpl
    ): ProductDetailsRepository
}