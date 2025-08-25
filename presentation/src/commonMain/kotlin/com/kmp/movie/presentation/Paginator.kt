package com.kmp.movie.presentation

import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result

class Paginator<Key, Item>(
    private val initialKey: Key,
    private val onLoadUpdated: (Boolean) -> Unit,
    private val onRequest: suspend (nextKey: Key) -> Result<Item, DataError>, //★ 여기!
    private val getNextKey: suspend (currentKey: Key, result: Item) -> Key,
    private val onError: suspend (DataError?) -> Unit,  // ← 이 부분!
    private val onSuccess: suspend (result: Item, newKey: Key) -> Unit,
    private val endReached: (currentKey: Key, result: Item) -> Boolean
) {

    private var currentKey = initialKey
    private var isMakingRequest = false
    private var isEndReached = false

    suspend fun loadNextItems() {
        if(isMakingRequest || isEndReached) {
            return
        }

        isMakingRequest = true
        onLoadUpdated(true)

        val result = onRequest(currentKey)
        isMakingRequest = false

        val item = when(result) {
            is Result.Success -> result.data
            is Result.Error -> {
                onError(result.error)
                onLoadUpdated(false)
                return
            }
        }

        currentKey = getNextKey(currentKey, item)

        onSuccess(item, currentKey)

        onLoadUpdated(false)

        isEndReached = endReached(currentKey, item)
    }

    fun reset() {
        currentKey = initialKey
        isEndReached = false
    }
}