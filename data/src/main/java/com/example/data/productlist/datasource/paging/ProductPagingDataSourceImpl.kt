package com.example.data.productlist.datasource.paging

import com.example.data.productlist.model.paging.ProductPaginationRequest
import com.example.data.productlist.model.paging.ProductPaginationState
import javax.inject.Inject

class ProductPagingDataSourceImpl @Inject constructor() : ProductPagingDataSource {

    private var state = ProductPaginationState(
        skip = 0,
        canLoadMore = true
    )

    override fun getNextPage(): ProductPaginationRequest? =
        if (state.canLoadMore) {
            ProductPaginationRequest(
                limit = DEFAULT_PAGE_SIZE,
                skip = state.skip
            )
        } else {
            null
        }

    override fun onPageLoaded(
        total: Int,
        limit: Int
    ) {
        val newSkip = state.skip + limit

        state = ProductPaginationState(
            skip = newSkip,
            canLoadMore = newSkip < total
        )
    }

    override fun clear() {
        state = ProductPaginationState(
            skip = 0,
            canLoadMore = true
        )
    }

    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
    }
}
