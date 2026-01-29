package com.example.data.productlist.repository

import com.example.data.productlist.datasource.ProductListRemoteDataSource
import com.example.data.productlist.datasource.paging.ProductPagingDataSource
import com.example.data.productlist.mapper.ProductMapper
import com.example.domain.productlist.entity.ProductEntity
import com.example.domain.productlist.entity.listing.Listing
import com.example.domain.productlist.repository.ProductListRepository
import com.example.domain.result.Failure

import com.example.domain.result.Result
import com.example.domain.result.Success

import javax.inject.Inject

class ProductListRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductListRemoteDataSource,
    private val pagingDataSource: ProductPagingDataSource,
    private val mapper: ProductMapper
) : ProductListRepository {
    override suspend fun getProducts(): Result<Listing<ProductEntity>> {
        val pagingRequest = pagingDataSource.getNextPage()
            ?: return Failure("No more products to load")

        return when (
            val result = remoteDataSource.getProducts(
                limit = pagingRequest.limit,
                skip = pagingRequest.skip
            )
        ) {
            is Success -> {
                val response = result.value

                pagingDataSource.onPageLoaded(
                    total = response.total,
                    limit = response.limit
                )

                Success(
                    Listing(
                        items = mapper.mapList(response.products),
                        canLoadMore = response.skip + response.limit < response.total
                    )
                )
            }

            is Failure -> Failure("Unable to load products")
        }
    }

}