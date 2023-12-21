package dam.islasfilipinas.rubinlavi_roy_practicapmdm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.databinding.ActivityItemDetailsBinding

class DetailRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the data passed from the previous activity
        val recipeTitle = intent.getStringExtra("recipeTitle")
        val recipeCategory = intent.getStringExtra("recipeCategory")
        val recipeImage = intent.getStringExtra("recipeImage")
        val recipeDescription = intent.getStringExtra("recipeDescription")

        // Populate the views with the retrieved data
        binding.textTitle.text = recipeTitle
        binding.textCategory.text = recipeCategory
        binding.textRecipe.text = recipeDescription

        // Load the image from the URL into the ImageView using Coil
        binding.imageRecipe.load(recipeImage)
    }
}
