package com.example.test.di.mapper

import com.example.presentation.productdetails.mapper.ProductDetailViewMapper
import com.example.presentation.productdetails.mapper.ProductDetailViewMapperImpl
import com.example.presentation.productlist.mapper.ProductItemViewMapper
import com.example.presentation.productlist.mapper.ProductItemViewMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductDetailViewMapperModule {
    @Binds
    abstract fun bindProductDetailViewMapper(
        impl: ProductDetailViewMapperImpl
    ): ProductDetailViewMapper
}