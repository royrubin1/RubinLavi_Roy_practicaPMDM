package dam.islasfilipinas.rubinlavi_roy_practicapmdm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import dam.islasfilipinas.rubinlavi_roy_practicapmdm.room.Category

class CategoryAdapter(private val context: Context, private val categories: List<Category>) : BaseAdapter() {

    override fun getCount(): Int = categories.size

    override fun getItem(position: Int): Any = categories[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val view = convertView ?: layoutInflater.inflate(R.layout.item, parent, false)

        val textView = view.findViewById<TextView>(R.id.item_text)
        textView.text = categories[position].category

        // val imageView = view.findViewById<ImageView>(R.id.your_image_view_id)
        // Set image using imageView



        return view
    }



}
