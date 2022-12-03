package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ButtonItemBinding

class ButtonAdapter (context: Context, buttonList : ArrayList<ButtonModel>, clickListener: ClickListener) : RecyclerView.Adapter<ButtonAdapter.ViewHolder>()
{
    var list : ArrayList<ButtonModel> = buttonList
    var context : Context = context
    var clickListener : ClickListener = clickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder(ButtonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val model : ButtonModel = list[position]

        holder.binding.btSecenek.text = model.text

        if (model.isPressed)
        {
            holder.binding.btSecenek.background = AppCompatResources.getDrawable(context, R.drawable.pressed_background)
            holder.binding.btSecenek.setTextColor(context.resources.getColor(R.color.white))
        }
        else
        {
            holder.binding.btSecenek.background = AppCompatResources.getDrawable(context, R.drawable.unpressed_background)
            holder.binding.btSecenek.setTextColor(context.resources.getColor(R.color.purple_500))
        }

        holder.binding.btSecenek.setOnClickListener { clickListener.onClick(position) }
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    class ViewHolder(itemView: ButtonItemBinding) : RecyclerView.ViewHolder(itemView.root)
    {
        var binding : ButtonItemBinding = itemView
    }
}