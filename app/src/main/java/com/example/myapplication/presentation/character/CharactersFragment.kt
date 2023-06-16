package com.example.myapplication.presentation.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.model.ResultResponse
import com.example.myapplication.data.state.ResourceState
import com.example.myapplication.databinding.FragmentCharactersBinding
import com.example.myapplication.presentation.base.BaseFragment
import com.example.myapplication.utils.hide
import com.example.myapplication.utils.show
import com.example.myapplication.utils.toast
import kotlinx.coroutines.launch
import org.koin.core.module.Module

class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharactersViewModel>() {

    private val viewModel: CharactersViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        collectObserver()
        viewModel.getCharacters()
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCharactersBinding = FragmentCharactersBinding.inflate(inflater, container, false)


    private fun setupRecycleView() = with(binding) {
        rvCharacters.apply {
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun collectObserver() = lifecycleScope.launch {
        viewModel.descriptionCharacter.collect { resource ->
            when (resource) {
                is ResourceState.Success -> {
                    resource.data?.let { values ->
                        binding.progressCircular.hide()
                        setNewsListAdapter(values.results)
                    }
                }
                is ResourceState.Error -> {
                    binding.progressCircular.hide()
                    resource.message?.let { message ->
                        toast(getString(R.string.an_error_occurred))
                    }

                }
                is ResourceState.Loading -> {
                    binding.progressCircular.show()

                }
                else -> {}
            }
        }
    }

    private fun setNewsListAdapter(result: List<ResultResponse>) {
        val charactersAdapter = CharactersAdapter(result)
        binding.rvCharacters.adapter = CharactersAdapter(result)
    }
}