package dam.islasfilipinas.rubinlavi_roy_practicapmdm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.room.Recipe

@Dao
interface RecipeDAO {
    @Query("SELECT * FROM recipes")
    suspend fun getAllRecipes(): List<Recipe>

    @Insert
    suspend fun insertRecipe(recipe: Recipe)
}
