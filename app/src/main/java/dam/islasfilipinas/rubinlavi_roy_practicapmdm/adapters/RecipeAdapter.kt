package dam.islasfilipinas.rubinlavi_roy_practicapmdm.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.R
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.activities.DetailRecipeActivity
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.activities.RecipeListActivity
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.room.Recipe

class RecipeAdapter(private val context: RecipeListActivity, private val recipes : List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val textView: TextView = view.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.textView.text = recipe.title

        holder.imageView.load(recipe.imageUri) {
            crossfade(true)
            error(R.drawable.error_placeholder)
        }

        holder.imageView.setOnClickListener {
            val intent = Intent(context, DetailRecipeActivity::class.java)
            intent.putExtra("recipeTitle", recipe.title)
            intent.putExtra("recipeCategory", recipe.category)
            intent.putExtra("recipeImage", recipe.imageUri)
            intent.putExtra("recipeDescription", recipe.description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}
