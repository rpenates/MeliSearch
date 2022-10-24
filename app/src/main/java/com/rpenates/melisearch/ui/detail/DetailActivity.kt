package com.rpenates.melisearch.ui.detail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.rpenates.melisearch.R
import com.rpenates.melisearch.models.MlaItem
import com.rpenates.melisearch.ui.main.MainActivity
import com.rpenates.melisearch.utils.DataUtils
import java.io.Serializable

class DetailActivity : AppCompatActivity() {

    val TAG = "DetailActivity"

    lateinit var serializedMla: String
    lateinit var data: MlaItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        serializedMla = intent.getStringExtra("mlaitem").toString()
        data = DataUtils.mlaDeserialize(serializedMla)

        supportActionBar?.title = "Detalle"

        renderContent(data)
    }

    fun renderContent(data: MlaItem) {
        val productText = findViewById<TextView>(R.id.detail_product_text)
        val priceText = findViewById<TextView>(R.id.detail_price_text)
        val conditionText = findViewById<TextView>(R.id.detail_condition_text)
        val quantityText = findViewById<TextView>(R.id.detail_quantity_text)
        val thumbnail = findViewById<ImageView>(R.id.item_thumbnail_image)

        productText.text = data.title
        priceText.text = "$${data.price}"
        conditionText.text = data.condition
        quantityText.text = "${data.availableQuantity} Unidades"

        // Se usa esta url en vez de la contenida en data.thumbnail debido a que no carga por restricciones del api
        val imagePlaceholder = "https://picsum.photos/200"

        Glide.with(this)
            .load(imagePlaceholder)
            .into(thumbnail)
    }
}