package dam.islasfilipinas.rubinlavi_roy_practicapmdm.room
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category: String,
    val imageUri: String,
    val description: String
)
