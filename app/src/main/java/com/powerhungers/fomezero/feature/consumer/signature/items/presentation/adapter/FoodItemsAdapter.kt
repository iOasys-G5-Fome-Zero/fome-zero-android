package com.powerhungers.fomezero.feature.consumer.signature.items.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.powerhungers.fomezero.common.utils.DefaultDiffCallback
import com.powerhungers.fomezero.databinding.FoodItemViewBinding
import com.powerhungers.fomezero.feature.consumer.signature.domain.model.FoodItem

class FoodItemsAdapter : ListAdapter<FoodItem, FoodItemsAdapter.ViewHolder>(
    DefaultDiffCallback<FoodItem>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        FoodItemViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: FoodItemsAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: FoodItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FoodItem) {
            val context = this.itemView.context
            with(binding) {
                itemNameTextView.text = context.getString(item.name)
                moreOrLessButton.number.text = item.max.toString()
            }
        }
    }
}
