package com.liucalvin.boggle.ui.viewholders

import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import com.liucalvin.boggle.databinding.ItemTileBinding
import com.liucalvin.boggle.ui.gameplay.Tile
import com.liucalvin.boggle.ui.gameplay.TileTouchListener

class TileViewHolder(
    parent: ViewGroup,
    private val touchListener: TileTouchListener
) : BaseViewHolder<Tile, ItemTileBinding>(parent, ItemTileBinding::inflate) {

    companion object {
        fun from(parent: ViewGroup, touchListener: TileTouchListener): TileViewHolder {
            return TileViewHolder(parent, touchListener)
        }
    }

    override fun bind(item: Tile) {
        binding.itemLetter.text = item.letter.toString()
        binding.root.setOnClickListener {
            touchListener.onTouch(item)
        }
        binding.root.setOnTouchListener { _, _ ->
            touchListener.onTouch(item)
        }

    }

}
