package com.example.test.di.mapper

import com.example.data.productdetails.mapper.ProductDetailsMapper
import com.example.data.productdetails.mapper.ProductDetailsMapperImpl
import com.example.data.productlist.mapper.ProductMapper
import com.example.data.productlist.mapper.ProductMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDetailsMapperModule {
    @Binds
    abstract fun bindProductDetailsMapper(
        impl: ProductDetailsMapperImpl
    ): ProductDetailsMapper
}