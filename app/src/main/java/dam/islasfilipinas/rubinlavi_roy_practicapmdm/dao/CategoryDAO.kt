package dam.islasfilipinas.rubinlavi_roy_practicapmdm.dao

import androidx.room.Dao
import androidx.room.Query
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.room.Category

@Dao
interface CategoryDAO {
    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<Category>
}
