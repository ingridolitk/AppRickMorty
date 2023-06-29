package com.example.myapplication.home.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapplication.data.model.ResultResponse
import com.example.myapplication.databinding.FragmentDetailsCharacterBinding
import com.example.myapplication.presentation.base.BaseFragment
import com.squareup.picasso.Picasso

class DetailsCharacterFragment : BaseFragment<FragmentDetailsCharacterBinding>() {
    private val args = navArgs<DetailsCharacterFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindCharacter(args.value.resultResponse)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsCharacterBinding =
        FragmentDetailsCharacterBinding.inflate(inflater, container, false)

    private fun bindCharacter(details: ResultResponse) = with(binding) {
        binding.apply{
        textviewComics.text = details.species
        tvNameCharacterDetails.text = details.name
        tvDescriptionCharacterDetails.text = details.status

        Picasso.get().load(details.image)
            .into(imgCharacterDetails)
    }
}
}