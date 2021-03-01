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

class ColdDrinksProductsActivity : AppCompatActivity() {
    var coldDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cold_drinks_products)
        addProductsCold()
        var listView_colddrinks: ListView = findViewById(R.id.listView_products) as ListView
        var adapter = AdapterProducts(this, coldDrinks)
        listView_colddrinks.adapter = adapter
    }

    fun addProductsCold(){
        coldDrinks.add(Product("Caramel Frap", R.drawable.caramel_frap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.00))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolate_frap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.00))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.00))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.00))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.00))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.00))
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