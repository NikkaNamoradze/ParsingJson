package com.example.parsingdataandretrofit.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.parsingdataandretrofit.R
import com.example.parsingdataandretrofit.databinding.ParsingFragmentBinding
import kotlinx.coroutines.launch

class ParsingFragment : Fragment() {

    private var _binding: ParsingFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ParsingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ParsingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGetInfo.setOnClickListener {
            viewModel.getDataFromApi()
            Log.d("msg_api", "${viewModel.response}")
        }
    }



}