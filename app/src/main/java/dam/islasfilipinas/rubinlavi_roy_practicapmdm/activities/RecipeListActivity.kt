package dam.islasfilipinas.rubinlavi_roy_practicapmdm.activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.R
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.adapters.RecipeAdapter
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.room.AppDatabase
import kotlinx.coroutines.launch

class RecipeListActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes_list)
        val category = intent.getStringExtra("category")
        database = AppDatabase.getDatabase(applicationContext)
        progressBar = findViewById<ProgressBar>(R.id.loading_progess_bar)
        val recipeList = findViewById<RecyclerView>(R.id.recipe_list)

        recipeList.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            showLoading(true)
            val recipes = database.recipeDao().getCategoryRecipes(category!!)
            runOnUiThread {
                showLoading(false)
                recipeAdapter = RecipeAdapter(this@RecipeListActivity, recipes)
                recipeList.adapter = recipeAdapter
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}