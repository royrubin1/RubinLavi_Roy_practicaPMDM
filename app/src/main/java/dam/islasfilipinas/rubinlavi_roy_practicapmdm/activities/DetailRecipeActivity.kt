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

        val recipeTitle = intent.getStringExtra("recipeTitle")
        val recipeCategory = intent.getStringExtra("recipeCategory")
        val recipeImage = intent.getStringExtra("recipeImage")
        val recipeDescription = intent.getStringExtra("recipeDescription")

        binding.textTitle.text = recipeTitle
        binding.textCategory.text = recipeCategory
        binding.textRecipe.text = recipeDescription

        binding.imageRecipe.load(recipeImage)
    }
}
