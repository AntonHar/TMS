package com.example.saper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView


class MyAdapter internal constructor(context: Context, private var data: MutableList<Int>) :
        RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val resources = context.resources
    private var listener: ItemClicklistener? = null

    /*class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById<Button>(R.id.cell).apply {
            setOnClickListener { listener?.onItemClick(it, adapterPosition) }
        }
    }*/
    inner class ViewHolder internal constructor(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById<Button>(R.id.cell)
                .apply {
                    setOnClickListener { listener?.onItemClick(it, adapterPosition) }
                }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        when (item) {
            -1 -> {
                holder.button.setBackgroundColor(resources.getColor(R.color.light_grey))
            }
            0 -> {
                holder.button.setBackgroundColor(resources.getColor(R.color.white))
            }
            1 -> {
                holder.button.setBackgroundColor(resources.getColor(R.color.white))
                holder.button.setTextColor(resources.getColor(R.color.blue))
                holder.button.text = "$item"
            }
            2 -> {
                holder.button.setBackgroundColor(resources.getColor(R.color.white))
                holder.button.setTextColor(resources.getColor(R.color.green))
                holder.button.text = "$item"
            }
            3 -> {
                holder.button.setBackgroundColor(resources.getColor(R.color.white))
                holder.button.setTextColor(resources.getColor(R.color.red))
                holder.button.text = "$item"
            }
            4 -> {
                holder.button.setBackgroundColor(resources.getColor(R.color.white))
                holder.button.setTextColor(resources.getColor(R.color.purple))
                holder.button.text = "$item"
            }
            5 -> {
                holder.button.setBackgroundColor(resources.getColor(R.color.white))
                holder.button.setTextColor(resources.getColor(R.color.brown))
                holder.button.text = "$item"
            }
            6 -> {
                holder.button.setBackgroundColor(resources.getColor(R.color.white))
                holder.button.setTextColor(resources.getColor(R.color.turquoise))
                holder.button.text = "$item"
            }
            10 -> {
                holder.button.setBackgroundColor(resources.getColor(R.color.light_grey))
            }
            11-> {holder.button.setBackgroundColor(resources.getColor(R.color.red))
                holder.button.setTextColor(resources.getColor(R.color.black))
                holder.button.text = "bomb"
            }


        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setClickListener(itemClicklistener: ItemClicklistener?) {
        listener = itemClicklistener
    }

}

