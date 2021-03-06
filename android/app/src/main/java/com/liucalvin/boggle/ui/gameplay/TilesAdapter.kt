package com.liucalvin.boggle.ui.gameplay

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.liucalvin.boggle.ui.viewholders.AdapterItem
import com.liucalvin.boggle.ui.viewholders.TileViewHolder

class TilesAdapter(private val touchListener: TileTouchListener) :
    ListAdapter<Tile, TileViewHolder>(TilesListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TileViewHolder {
        return TileViewHolder.from(parent, touchListener)
    }

    override fun onBindViewHolder(holder: TileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class TilesListDiffCallback : DiffUtil.ItemCallback<Tile>() {
    override fun areItemsTheSame(oldItem: Tile, newItem: Tile): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Tile, newItem: Tile): Boolean {
        return oldItem.letter == newItem.letter
    }

}

data class Tile(val letter: Char, val id: Int) : AdapterItem("Tile")


interface TileTouchListener {
    fun onTouch(tile: Tile): Boolean
}

