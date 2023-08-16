package com.example.myapplication.details.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailsCharacterBinding
import com.example.myapplication.details.data.model.DetailsCharacters
import com.example.myapplication.details.presentation.state.DetailsResourceState
import com.example.myapplication.utils.base.BaseFragment
import com.example.myapplication.utils.hide
import com.example.myapplication.utils.show
import com.example.myapplication.utils.toast
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsCharacterFragment : BaseFragment<FragmentDetailsCharacterBinding>() {
    private val args by navArgs<DetailsCharacterFragmentArgs>()
    private val viewModel: DetailsCharacterViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchDetailsMovies(args.id)
        observeViewModel()
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsCharacterBinding =
        FragmentDetailsCharacterBinding.inflate(inflater, container, false)

    private fun bindCharacter(details: DetailsCharacters) = with(binding) {
        binding.apply {
            textviewComics.text = details.species
            tvNameCharacterDetails.text = details.name
            tvDescriptionCharacterDetails.text = details.status

            Picasso.get().load(details.image)
                .into(imgCharacterDetails)
        }
    }

    private fun observeViewModel() {
        viewModel.descriptionDetails.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is DetailsResourceState.Success -> {
                    resource.listCharacters.let { values ->
                        binding.progressBarDetail.hide()
                        bindCharacter(values)
                    }
                }
                is DetailsResourceState.Error -> {
                    binding.progressBarDetail.hide()
                    toast(getString(R.string.an_error_occurred))
                }
                is DetailsResourceState.Loading -> {
                    binding.progressBarDetail.show()
                }
                else -> {}
            }
        }
    }
}