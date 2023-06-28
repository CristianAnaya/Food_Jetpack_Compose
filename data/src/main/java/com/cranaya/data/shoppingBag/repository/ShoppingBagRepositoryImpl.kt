package com.cranaya.data.shoppingBag.repository

import android.util.Log
import com.cranaya.data.shoppingBag.repository.dataSource.ShoppingBagLocalDataSource
import com.cranaya.domain.shoppingBag.model.ShoppingBag
import com.cranaya.domain.shoppingBag.repository.ShoppingBagRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ShoppingBagRepositoryImpl(
    private val shoppingBagLocalDataSource: ShoppingBagLocalDataSource
): ShoppingBagRepository {

    override suspend fun add(shoppingBag: ShoppingBag) {
        CoroutineScope(Dispatchers.IO).launch {
            val shoppingBagLocal = shoppingBagLocalDataSource.findById(id = shoppingBag.id)
            if (shoppingBagLocal == null) {
                shoppingBagLocalDataSource.create(shoppingBag)
            } else {
                shoppingBagLocalDataSource.update(shoppingBag.id, shoppingBag.quantity)
            }
        }
    }

    override suspend fun delete(id: String) = shoppingBagLocalDataSource.delete(id)

    override fun findAll(): Flow<List<ShoppingBag>>  {

        return shoppingBagLocalDataSource.finAll()
    }

    override suspend fun findById(id: String): ShoppingBag? {
        val data = runBlocking(context = Dispatchers.IO) {
            shoppingBagLocalDataSource.findById(id)
        }
        return data
    }
}