package com.example.myapplication.presentation.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.ResultResponse
import com.example.myapplication.databinding.ItemCharactersBinding
import com.example.myapplication.domain.model.Characters
import com.squareup.picasso.Picasso

class CharactersAdapter(
    private var list: List<ResultResponse>
) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private var onItemClickListener: ((Characters) -> Unit)? = null

    inner class ViewHolder(val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun onBind(holder: ViewHolder, result: ResultResponse) {
        holder.binding.apply {
            textviewCharacter.text = result.name
            textviewDescriptionCharacter.text = result.status

            Picasso.get().load(result.image)
                .into(imgCharacter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBind(holder, list.get(position))
    }

    override fun getItemCount() = list.size

    fun setOnClickListener(listener: (Characters) -> Unit){
        onItemClickListener = listener
    }
}