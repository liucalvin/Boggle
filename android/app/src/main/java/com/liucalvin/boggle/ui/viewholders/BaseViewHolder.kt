package com.liucalvin.boggle.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T: AdapterItem, VB: ViewBinding>(
    parent: ViewGroup,
    bindingLayout: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    val binding: VB = bindingLayout.invoke(LayoutInflater.from(parent.context), parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T)
}

abstract class AdapterItem(val itemtype: String) {

}
