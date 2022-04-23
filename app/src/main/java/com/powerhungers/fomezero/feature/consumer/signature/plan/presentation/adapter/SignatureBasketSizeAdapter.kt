package com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.powerhungers.fomezero.common.utils.AdapterItemWithParameterClickListener
import com.powerhungers.fomezero.common.utils.DefaultDiffCallback
import com.powerhungers.fomezero.databinding.BasketRadioButtonItemBinding
import com.powerhungers.fomezero.feature.consumer.signature.domain.model.BasketType
import com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.model.BasketSizeItem

class SignatureBasketSizeAdapter :
    ListAdapter<BasketSizeItem, SignatureBasketSizeAdapter.ViewHolder>(
        DefaultDiffCallback<BasketSizeItem>()
    ) {

    var selectedPosition = -1
    var itemClickListener: AdapterItemWithParameterClickListener<BasketType> = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        BasketRadioButtonItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class ViewHolder(private val binding: BasketRadioButtonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BasketSizeItem, position: Int) {
            with(binding) {
                radioButtonTitle.text = item.title
                radioButtonDescription.text = item.description
                handleRadioButton(binding, position, item.type)
            }
        }

        private fun handleRadioButton(
            binding: BasketRadioButtonItemBinding,
            position: Int,
            type: BasketType
        ) {
            with(binding) {
                radioButton.isChecked = position == selectedPosition
                root.setOnClickListener {
                    itemClickListener(type)
                    if (position == selectedPosition) {
                        radioButton.isChecked = false
                        selectedPosition = -1
                    } else {
                        selectedPosition = position
                        notifyDataSetChanged()
                    }
                }
            }
        }
    }
}

