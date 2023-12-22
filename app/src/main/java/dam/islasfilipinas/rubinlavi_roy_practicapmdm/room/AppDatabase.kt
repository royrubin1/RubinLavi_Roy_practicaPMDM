package dam.islasfilipinas.rubinlavi_roy_practicapmdm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.dao.CategoryDAO
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.dao.RecipeDAO

@Database(entities = [Recipe::class, Category::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDAO
    abstract fun categoryDao(): CategoryDAO

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database"
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            val categories = listOf(
                                "Entradas Navideñas",
                                "Platos Principales Navideños",
                                "Postres Navideños",
                                "Ensaladas Navideñas",
                                "Sopas Navideñas",
                                "Bebidas Navideñas"
                            )

                            categories.forEach { category ->
                                db.execSQL("INSERT INTO categories (category) VALUES ('$category');")
                            }

                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Canapés de salmón', 'Entradas Navideñas', 'https://i.blogs.es/3cb78d/canape_salmon/650_1200.jpg', 'Unta rodajas finas de baguette tostada con queso crema, coloca encima láminas de salmón ahumado y adereza al gusto con eneldo, alcaparras, rodajas de pepino, jugo de limón, sal y pimienta. Sirve como aperitivo elegante y sencillo.')")
                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Croquetas de jamón', 'Entradas Navideñas', 'https://www.annarecetasfaciles.com/files/croquetas-jamon-scaled.jpg', 'Mezcla jamón serrano picado con una bechamel espesa. Forma croquetas, pásalas por huevo y pan rallado, y fríelas hasta que estén doradas. Perfectas para compartir.')")

                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Pavo relleno', 'Platos Principales Navideños', 'https://t1.uc.ltmcdn.com/es/posts/5/1/2/como_hacer_pavo_relleno_asado_3215_orig.jpg', 'Adoba un pavo con hierbas y especias. Rellénalo con una mezcla de pan, cebolla, apio, manzana y salchichas. Hornea hasta que esté bien cocido. Ideal para una cena familiar.')")
                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Bacalao a la vizcaína', 'Platos Principales Navideños', 'https://www.petitchef.es/imgupl/recipe/bacalao-a-la-vizcaina-cocina-vasca--456314p731843.jpg', 'Prepara una salsa vizcaína con pimientos choriceros, tomate, ajo y cebolla. Cocina el bacalao en la salsa hasta que esté tierno. Un clásico de Navidad.')")

                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Rosca de Reyes', 'Postres Navideños', 'https://recetasdecocina.elmundo.es/wp-content/uploads/2023/01/roscon-de-reyes-receta-facil.jpg', 'Prepara una masa dulce con frutas confitadas y forma una rosca. Decora con azúcar y frutas confitadas después de hornear. Un postre tradicional para el Día de Reyes.')")
                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Turrón de almendras', 'Postres Navideños', 'https://okdiario.com/img/2018/07/19/receta-de-turron-duro-de-almendras-1.jpg', 'Tuesta almendras y mézclalas con miel y clara de huevo batida. Extiende la mezcla en un molde y deja que se endurezca. Un dulce típico navideño.')")

                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Ensalada de manzana', 'Ensaladas Navideñas', 'https://tvpacifico.mx/recetas/intranet/images/recipes/431-453.jpg', 'Combina manzanas picadas, piña, crema y nueces. Endulza al gusto y enfría antes de servir. Una ensalada fresca y deliciosa para acompañar la cena.')")
                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Ensalada Waldorf', 'Ensaladas Navideñas', 'https://enrilemoine.com/wp-content/uploads/2010/12/1-DSC06597.jpg', 'Mezcla apio, manzana y nueces picadas. Añade mayonesa y un toque de limón. Una ensalada clásica y refrescante.')")

                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Crema de calabaza', 'Sopas Navideñas', 'https://okdiario.com/img/2018/02/22/crema-calabaza-zanahoria.jpg', 'Cocina calabaza, cebolla y ajo hasta que estén tiernos. Tritura hasta obtener una crema suave y condimenta con sal, pimienta y un toque de crema. Una sopa cálida y reconfortante.')")
                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Sopa de mariscos', 'Sopas Navideñas', 'https://i0.wp.com/www.angsarap.net/wp-content/uploads/2023/07/Sopa-de-Mariscos-Wide.jpg?fit=1080%2C720&ssl=1', 'Prepara un caldo con pescado, camarones, mejillones y verduras. Sirve con un toque de limón y cilantro fresco. Una sopa llena de sabor y perfecta para ocasiones especiales.')")

                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Ponche navideño', 'Bebidas Navideñas', 'https://www.goya.com/media/6728/mexican-christmas-punch.jpg?quality=80', 'Hierve agua con canela, clavo y piloncillo. Añade frutas como guayaba, tamarindo y manzana. Sirve caliente para calentar el espíritu navideño.')")
                            db.execSQL("INSERT INTO recipes (title, category, imageUri, description) VALUES ('Sidra caliente especiada', 'Bebidas Navideñas', 'https://hips.hearstapps.com/hmg-prod/images/coctel-sidra-caliente-especiada-1544460165.jpg', 'Calienta sidra de manzana con canela, clavo, anís y ralladura de naranja. Perfecta para compartir en una noche fría.')")

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
