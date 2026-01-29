package com.example.test.di.datasource

import com.example.data.productlist.datasource.ProductListRemoteDataSource
import com.example.data.productlist.datasource.ProductListRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDataSourceModule {

    @Binds
    abstract fun bindProductRemoteDataSource(
        impl: ProductListRemoteDataSourceImpl
    ): ProductListRemoteDataSource
}