package com.liucalvin.boggle.ui.viewholders

import android.view.ViewGroup
import com.liucalvin.boggle.databinding.ItemTileBinding
import com.liucalvin.boggle.ui.gameplay.Tile
import com.liucalvin.boggle.ui.gameplay.TileTouchListener

class TileViewHolder(
    parent: ViewGroup,
    private val touchListener: TileTouchListener
) : BaseViewHolder<Tile, ItemTileBinding>(parent, ItemTileBinding::inflate), TileTouchListener {
    override fun onTouch(tile: Tile) {

    }

    fun bind(tile: Tile) {
        binding.itemLetter.text = tile.letter.toString()
        binding.root.setOnClickListener {
            touchListener.onTouch(tile)
        }
    }

}
