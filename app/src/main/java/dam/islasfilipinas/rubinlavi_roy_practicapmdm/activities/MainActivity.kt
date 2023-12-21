package dam.islasfilipinas.rubinlavi_roy_practicapmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button =  findViewById<Button>(R.id.start_button)
        button.setOnClickListener(){
            val intent = Intent(this, CategoryListActivity::class.java)
            startActivity(intent)
        }
    }
}