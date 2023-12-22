package dam.islasfilipinas.rubinlavi_roy_practicapmdm.activities
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.adapters.CategoryAdapter
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.R
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.room.AppDatabase
import kotlinx.coroutines.launch

class CategoryListActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        database = AppDatabase.getDatabase(applicationContext)
        progressBar = findViewById<ProgressBar>(R.id.loading_progess_bar)
        val gridView = findViewById<GridView>(R.id.category_list)

        lifecycleScope.launch {
            showLoading(true)
            val categories = database.categoryDao().getAllCategories()
            runOnUiThread {
                showLoading(false)
                categoryAdapter = CategoryAdapter(this@CategoryListActivity, categories)
                gridView.adapter = categoryAdapter
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}
