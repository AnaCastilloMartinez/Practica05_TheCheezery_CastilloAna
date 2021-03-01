package castillo.ana.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class HotDrinksProductsActivity : AppCompatActivity() {
    var hotDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_drinks_products)
        addProductsHot()
        var listView_hotdrinks: ListView = findViewById(R.id.listView_products) as ListView
        var adapter = AdapterProducts(this, hotDrinks)
        listView_hotdrinks.adapter = adapter
    }

    fun addProductsHot(){
        hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.00))
        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.00))
        hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.00))
        hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.00))
        hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.00))
        hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.00))
    }

    private class AdapterProducts: BaseAdapter {
        var products = ArrayList<Product>()
        var context: Context? = null
        constructor(context: Context, products: ArrayList<Product>) {
            this.products = products
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = products[position]
            var inflater = LayoutInflater.from(context)
            var view = inflater.inflate(R.layout.product_view,null)
            var image = view.findViewById(R.id.product_image) as ImageView
            var name =view.findViewById(R.id.product_name) as TextView
            var description =view.findViewById(R.id.product_description) as TextView
            var price =view.findViewById(R.id.product_price) as TextView
            image.setImageResource(prod.image)
            name.setText(prod.name)
            description.setText(prod.description)
            price.setText("$${prod.price}")
            return view
        }

        override fun getItem(position: Int): Any {
            return products[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return products.size
        }
    }
}