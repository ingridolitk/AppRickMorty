package com.example.myapplication.presentation.character

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
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
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharactersViewModel>() {

    private val viewModel: CharactersViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        collectObserver()
        viewModel.getCharacters()
       // setNewsListAdapter(values.results)
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
        charactersAdapter.onItemClick = {
            toast("teste", Toast.LENGTH_LONG)
            findNavController().navigate(R.id.action_charactersfragment_to_detailsfragment)
        }
        rvCharacters.adapter = charactersAdapter
    }

    companion object{
        fun navInstance(): CharactersFragment{
            return CharactersFragment()
        }
    }

    interface onBottomClicked{
        fun buttonClicked(){

        }

    }
}