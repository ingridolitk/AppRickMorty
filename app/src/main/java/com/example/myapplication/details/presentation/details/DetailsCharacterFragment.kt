package com.example.myapplication.details.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentDetailsCharacterBinding
import com.example.myapplication.home.data.model.ResultResponse
import com.example.myapplication.utils.base.BaseFragment
import com.squareup.picasso.Picasso

class DetailsCharacterFragment : BaseFragment<FragmentDetailsCharacterBinding>() {
    //verificar o args
    private val args = navArgs<Args>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindCharacter(args.value.id)
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