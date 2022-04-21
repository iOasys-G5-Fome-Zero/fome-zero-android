package com.powerhungers.fomezero.common.utils

import androidx.recyclerview.widget.DiffUtil

class DefaultDiffCallback<T> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return true
    }
}