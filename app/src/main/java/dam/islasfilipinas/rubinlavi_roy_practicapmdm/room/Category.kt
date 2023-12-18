package dam.islasfilipinas.rubinlavi_roy_practicapmdm.room
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category: String
)
