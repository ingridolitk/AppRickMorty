package com.example.myapplication.home.presentation.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCharactersBinding
import com.example.myapplication.home.data.model.ResultResponse
import com.example.myapplication.utils.base.BaseFragment
import com.example.myapplication.home.presentation.state.ResourceState
import com.example.myapplication.utils.hide
import com.example.myapplication.utils.show
import com.example.myapplication.utils.toast
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {

    private val viewModel: CharactersViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        setupObserver()
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

    private fun setupObserver() = lifecycleScope.launch {
        viewModel.descriptionCharacter.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is ResourceState.Success -> {
                    resource.listCharacters.let { values ->
                        binding.progressCircular.hide()
                        setNewsListAdapter(values.results)
                    }
                }
                is ResourceState.Error -> {
                    binding.progressCircular.hide()
                    resource.messageError.let { message ->
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

    private fun setNewsListAdapter(result: List<ResultResponse>) = with(binding) {
        val charactersAdapter = CharactersAdapter(result)

//        charactersAdapter.onItemClick = {
//            findNavController().navigate(CharactersFragmentDirections.actionCharactersfragmentToDetailsfragment(it))
//        }
        rvCharacters.adapter = charactersAdapter
    }
}