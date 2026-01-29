package com.example.test.di.datasource

import com.example.data.productdetails.datasource.ProductDetailsRemoteDataSource
import com.example.data.productdetails.datasource.ProductDetailsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDetailsDataSourceModule {

    @Binds
    abstract fun provideProductDetailsRemoteDataSource(
        impl: ProductDetailsRemoteDataSourceImpl
    ): ProductDetailsRemoteDataSource
}