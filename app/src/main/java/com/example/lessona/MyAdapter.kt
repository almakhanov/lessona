package com.example.lessona

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_card.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var dataSet = ArrayList<String>()
    private var listener: MyClickListener? = null

    fun setDataSet(list: ArrayList<String>){
        dataSet = list
        this.notifyDataSetChanged()
    }

    fun setListener(link: MyClickListener){
        listener = link
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: String){
            itemView.myTextView.text = item
        }

        init {
            itemView.setOnClickListener{
                listener?.onClick(dataSet[adapterPosition])
            }
        }
    }

    interface MyClickListener{
        fun onClick(text: String)
    }
}