package dam.islasfilipinas.rubinlavi_roy_practicapmdm.dao

import androidx.room.Dao
import androidx.room.Query
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.room.Recipe

@Dao
interface RecipeDAO {
    @Query("SELECT * FROM recipes WHERE category = :category")
    suspend fun getCategoryRecipes(category: String): List<Recipe>
}
