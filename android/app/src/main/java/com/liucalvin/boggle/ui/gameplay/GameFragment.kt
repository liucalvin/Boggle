package com.liucalvin.boggle.ui.gameplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.liucalvin.boggle.databinding.GameFragmentBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : Fragment() {

    private val gameViewModel: GameViewModel by viewModel()
    private lateinit var adapter: TilesAdapter

    private var _binding: GameFragmentBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GameFragmentBinding.inflate(inflater, container, false)

        adapter = TilesAdapter(object : TileTouchListener {
            override fun onTouch(tile: Tile): Boolean {
                gameViewModel.onTileTouched(id)
                return true
            }
        })
        binding.boggleBoard.adapter = adapter
        val layoutManager = BoardLayoutManager(requireActivity(), gameViewModel.boardSize.value)
        layoutManager.spanSizeLookup
        binding.boggleBoard.layoutManager = layoutManager

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.submitList(gameViewModel.tilesList.value)

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            gameViewModel.correctWords.collect {
                binding.currentScore.text = it.toString()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}