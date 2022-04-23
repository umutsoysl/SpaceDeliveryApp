package com.umut.soysal.spacedelivery.core.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.umut.soysal.spacedelivery.core.constant.GlobalConstant
import com.umut.soysal.spacedelivery.core.db.entity.StationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStation(station: StationEntity)

    @Query("SELECT * FROM ${GlobalConstant.DB_PLANET_TABLE} WHERE name LIKE :searchKey")
    fun searchStation(searchKey: String?): Flow<List<StationEntity>>

    @Query("SELECT * FROM ${GlobalConstant.DB_PLANET_TABLE} WHERE isFavorite=1")
    fun favoriteStationList(): Flow<List<StationEntity>>
}