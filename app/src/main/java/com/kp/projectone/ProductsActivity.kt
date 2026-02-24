package com.kp.projectone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recycleView = findViewById<RecyclerView>(R.id.rvProducts)

        val productList = listOf(
            Product(1, "ПК", "Висока продуктивність для сучасних ігор та роботи", "https://content2.rozetka.com.ua/goods/images/big/529493334.jpg"),
            Product(2, "Ігрова консоль", "Ексклюзивні хіти та незабутні емоції від геймінгу", "https://m.media-amazon.com/images/I/51ROi4d4puL._AC_UF1000,1000_QL80_.jpg"),
            Product(3, "Смартфон", "Яскравий дисплей, стильний дизайн та надійна батарея", "https://cactuss.com.ua/content/images/40/320x390l80mc0/smartfon-samsung-galaxy-s25-edge-12-512gb-titanium-jetblack-sm-s937bzkg-30427828198571.webp")

        )

        val adapter = ProductAdapter(productList)

        recycleView.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@ProductsActivity)
            setHasFixedSize(true)
        }
    }
}

