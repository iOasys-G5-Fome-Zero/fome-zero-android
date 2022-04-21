package com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.powerhungers.fomezero.common.utils.DefaultDiffCallback
import com.powerhungers.fomezero.databinding.BasketRadioButtonDateBinding
import com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.model.BasketDateItem

class SignatureBasketDateAdapter:
    ListAdapter<BasketDateItem, SignatureBasketDateAdapter.ViewHolder>(
    DefaultDiffCallback<BasketDateItem>()
    ) {

        var selectedPosition = -1

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            BasketRadioButtonDateBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(getItem(position), position)
        }

        inner class ViewHolder(private val binding: BasketRadioButtonDateBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(item: BasketDateItem, position: Int) {
                with(binding) {
                    radioButtonDate.text = item.title
                    handleRadioButton(binding, position)

                }
            }

            private fun handleRadioButton(binding: BasketRadioButtonDateBinding, position: Int) {
                with(binding) {
                    radioButton.isChecked = position == selectedPosition
                    root.setOnClickListener {
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