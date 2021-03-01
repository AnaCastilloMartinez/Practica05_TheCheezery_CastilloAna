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

class SaltiesProductsActivity : AppCompatActivity() {
    var salties = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salties_products)
        addProductsSalties()
        var listView_Salties: ListView = findViewById(R.id.listView_products) as ListView
        var adapter = AdapterProducts(this, salties)
        listView_Salties.adapter = adapter
    }

    fun addProductsSalties(){
        salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.00))
        salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.00))
        salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.00))
        salties.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.00))
        salties.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.00))
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