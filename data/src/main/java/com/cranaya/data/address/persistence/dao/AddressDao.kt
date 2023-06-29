package com.cranaya.data.address.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cranaya.data.address.persistence.entity.AddressEntity
import com.cranaya.data.category.persistence.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(addressEntity: AddressEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(addressEntityList: List<AddressEntity>)

    @Query("SELECT * FROM address WHERE id_user = :idUser")
    fun findByUser(idUser: String): Flow<List<AddressEntity>>

    @Query("UPDATE address SET address = :address, neighborhood = :neighborhood WHERE id = :id")
    suspend fun update(id: String, address: String, neighborhood: String)

    @Query("DELETE FROM address WHERE id = :id")
    suspend fun delete(id: String)

}