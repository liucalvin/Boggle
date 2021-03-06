package com.liucalvin.boggle.ui.gameplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.liucalvin.boggle.databinding.ItemLetterBinding
import com.liucalvin.boggle.databinding.ItemLetterBindingImpl

class TilesAdapter(private val touchListener: TileTouchListener) :
    ListAdapter<Tile, TilesAdapter.ViewHolder>(TilesListDiffCallback()) {

    class ViewHolder private constructor(private val binding: ItemLetterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tile: Tile) {
            binding.itemLetter.text = tile.letter.toString()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding =
                    ItemLetterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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

data class Tile(val letter: Char, val id: Int) {}

class TileTouchListener(val touchListener: (id: Int) -> Unit) {
    fun onTouch(id: Int) = touchListener(id)
}
