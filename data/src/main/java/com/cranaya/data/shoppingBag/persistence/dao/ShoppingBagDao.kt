package com.cranaya.data.shoppingBag.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cranaya.data.shoppingBag.persistence.entity.ShoppingBagEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingBagDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(shoppingBagEntity: ShoppingBagEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(shoppingBagEntity: List<ShoppingBagEntity>)

    @Query("SELECT * FROM shopping_bag")
    fun findAll(): Flow<List<ShoppingBagEntity>>

    @Query("SELECT * FROM shopping_bag WHERE id = :id")
    fun findById(id: String): ShoppingBagEntity?

    @Query("UPDATE shopping_bag SET quantity = :quantity WHERE id = :id")
    suspend fun update(id: String, quantity: Int)

    @Query("DELETE FROM shopping_bag WHERE id = :id")
    suspend fun delete(id: String)

}