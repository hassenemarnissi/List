package com.example.data.productlist.datasource.paging

import com.example.data.productlist.model.paging.ProductPaginationRequest

interface ProductPagingDataSource {
    fun getNextPage(): ProductPaginationRequest?

    fun onPageLoaded(
        total: Int,
        limit: Int
    )

    fun clear()
}