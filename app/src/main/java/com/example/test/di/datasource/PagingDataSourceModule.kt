package com.example.test.di.datasource

import com.example.data.productlist.datasource.paging.ProductPagingDataSource
import com.example.data.productlist.datasource.paging.ProductPagingDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PagingDataSourceModule {

    @Binds
    abstract fun bindProductPagingDataSource(
        impl: ProductPagingDataSourceImpl
    ): ProductPagingDataSource
}
