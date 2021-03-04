package com.liucalvin.boggle.ui.gameplay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.liucalvin.boggle.R
import com.liucalvin.boggle.databinding.GameFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : Fragment() {

    private val gameViewModel: GameViewModel by viewModel()
    private lateinit var adapter: TilesAdapter

    private var _binding: GameFragmentBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = GameFragmentBinding.inflate(inflater, container, false)

        adapter = TilesAdapter()
        binding.boggleBoard.adapter = adapter
        val layoutManager = GridLayoutManager(activity, 4)
        layoutManager.spanSizeLookup
        binding.boggleBoard.layoutManager = layoutManager

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}