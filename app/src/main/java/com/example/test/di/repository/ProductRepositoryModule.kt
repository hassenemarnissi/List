package com.example.test.di.repository

import com.example.data.productlist.repository.ProductListRepositoryImpl
import com.example.domain.productlist.repository.ProductListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductRepositoryModule {

    @Binds
    abstract fun bindProductListRepository(
        impl: ProductListRepositoryImpl
    ): ProductListRepository
}