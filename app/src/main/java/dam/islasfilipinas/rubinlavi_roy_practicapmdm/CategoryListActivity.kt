package dam.islasfilipinas.rubinlavi_roy_practicapmdm
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.room.AppDatabase
import kotlinx.coroutines.launch

class CategoryListActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        database = AppDatabase.getDatabase(applicationContext)

        val gridView = findViewById<GridView>(R.id.category_list)

        lifecycleScope.launch {
            val categories = database.categoryDao().getAllCategories()
            Log.d("DEBUG", "$categories")
            runOnUiThread {
                categoryAdapter = CategoryAdapter(this@CategoryListActivity, categories)
                gridView.adapter = categoryAdapter
            }
        }

    }
}
