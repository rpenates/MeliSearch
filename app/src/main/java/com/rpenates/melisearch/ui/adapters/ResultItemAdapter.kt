package com.rpenates.melisearch.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpenates.melisearch.R
import com.rpenates.melisearch.models.MlaItem

class ResultItemAdapter :  RecyclerView.Adapter<ResultItemAdapter.ResultItemHolder>() {

    var itemList = ArrayList<MlaItem>()
    var onItemClick : ((MlaItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultItemHolder {
        var cardItem = LayoutInflater.from(parent.context).inflate(R.layout.result_item_layout, parent, false)
        return ResultItemHolder(cardItem)
    }

    override fun onBindViewHolder(holder: ResultItemHolder, position: Int) {
        val item = itemList[position]
        holder?.render(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ResultItemHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        private val selfUrlText = itemView.findViewById<TextView>(R.id.product_text)
        private val shortUrlCode = itemView.findViewById<TextView>(R.id.price_text)
        private val content = itemView.findViewById<LinearLayout>(R.id.card_content)

        fun render(item: MlaItem) {
            selfUrlText.text = item.title
            shortUrlCode.text = item.price

            content.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }

    }
}

