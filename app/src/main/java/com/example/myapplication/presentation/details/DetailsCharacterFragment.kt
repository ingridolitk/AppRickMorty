package com.example.myapplication.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.domain.model.Result
import com.example.myapplication.databinding.FragmentDetailsCharacterBinding
import com.example.myapplication.presentation.base.BaseFragment
import com.example.myapplication.utils.DetailsCharacterState
import com.example.myapplication.utils.hide
import com.example.myapplication.utils.show
import com.example.myapplication.utils.toast
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsCharacterFragment :
    BaseFragment<FragmentDetailsCharacterBinding, DetailsCharacterViewModel>() {
    private val viewModel: DetailsCharacterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        observeViewModel()
        viewModel.fetchDetailsCharacters()
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsCharacterBinding =
        FragmentDetailsCharacterBinding.inflate(inflater, container, false)


    private fun observeViewModel() = with(binding) {
        lifecycleScope.launch {
            viewModel.detailsCharacter.observe(viewLifecycleOwner) { resource ->
                when (resource) {
                    is DetailsCharacterState.ResponseData -> resource.details?.let { details ->
                        handleResponseDataState(details)
                    }

                    is DetailsCharacterState.Error -> {
                        binding.progressBarDetail.hide()
                        resource.error.let { message ->
                            toast(getString(R.string.an_error_occurred))
                        }
                    }
                    is DetailsCharacterState.Loading -> {
                        binding.progressBarDetail.show()

                    }
                    else -> {}
                }
            }
        }
    }


    private fun handleResponseDataState(details: Result) {
        bindCharacter(details)
    }
    private fun bindCharacter(details: Result) {
        binding.apply {
            toast("teste", Toast.LENGTH_LONG)
            tvNameCharacterDetails.text = details.name
            tvDescriptionCharacterDetails.text = details.status

            Picasso.get().load(details.image)
                .into(imgCharacterDetails)
        }
    }
}