package dam.islasfilipinas.rubinlavi_roy_practicapmdm.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.dao.CategoryDAO
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.dao.RecipeDAO

@Database(entities = [Recipe::class, Category::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDAO

    abstract fun categoryDao() : CategoryDAO

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database"
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            Log.d("AppDatabase", "Creating new database instance")
                            super.onCreate(db)
                            db.execSQL("INSERT INTO categories (category) VALUES ('Entradas');")
                            db.execSQL("INSERT INTO categories (category) VALUES ('Principales');")
                            db.execSQL("INSERT INTO categories (category) VALUES ('Postres');")


                            db.execSQL("INSERT INTO recipes (category, imageUri, description) VALUES ('Entradas', 'https://picsum.photos/536/354', 'Descripción de la receta 1');")
                            db.execSQL("INSERT INTO recipes (category, imageUri, description) VALUES ('Principales', 'https://picsum.photos/536/354', 'Descripción de la receta 2');")
                            db.execSQL("INSERT INTO recipes (category, imageUri, description) VALUES ('Postres', 'https://picsum.photos/536/354', 'Descripción de la receta 3');")
                        }
                    })
                    .fallbackToDestructiveMigration()
                    .build()
                this.instance = instance
                instance
            }
        }
    }
}
