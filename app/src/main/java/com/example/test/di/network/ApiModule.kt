package com.example.test.di.network

import com.example.data.productdetails.api.ProductDetailsApi
import com.example.data.productlist.api.ProductListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideProductListApi(retrofit: Retrofit): ProductListApi =
        retrofit.create(ProductListApi::class.java)

    @Provides
    fun provideProductDetailsApi(retrofit: Retrofit): ProductDetailsApi =
        retrofit.create(ProductDetailsApi::class.java)
}