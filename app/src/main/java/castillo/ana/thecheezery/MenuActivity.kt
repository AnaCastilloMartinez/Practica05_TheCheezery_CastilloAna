package castillo.ana.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnCold: Button = findViewById(R.id.button_cold_drinks) as Button
        var btnHot: Button = findViewById(R.id.button_hot_drinks) as Button
        var btnSweets: Button = findViewById(R.id.button_sweets) as Button
        var btnSalties: Button = findViewById(R.id.button_salties) as Button

        //Event button cold drinks
        btnCold.setOnClickListener {
            var intent: Intent = Intent(this, ColdDrinksProductsActivity::class.java)
            startActivity(intent)
        }
        //Event button hot drinks
        btnHot.setOnClickListener {
            var intent: Intent = Intent(this, HotDrinksProductsActivity::class.java)
            startActivity(intent)
        }
        //Event button sweets
        btnSweets.setOnClickListener {
            var intent: Intent = Intent(this, SweetsProductsActivity::class.java)
            startActivity(intent)
        }
        // //Event button salties
        btnSalties.setOnClickListener {
            var intent: Intent = Intent(this, SaltiesProductsActivity::class.java)
            startActivity(intent)
        }
    }
}