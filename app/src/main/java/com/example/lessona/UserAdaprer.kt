package com.example.lessona

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdaprer : RecyclerView.Adapter<UserAdaprer.UserViewHolder>(){

    private var dataSet = ArrayList<User>()
    private var listener: MyClickListener? = null

    fun setDataSet(list: ArrayList<User>){
        dataSet = list
        this.notifyDataSetChanged()
    }

    fun setListener(link: MyClickListener){
        listener = link
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }


    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: User){
            itemView.nameValueTextView.text = item.name
            itemView.surnameValueTextView.text = item.name
            itemView.ageValueTextView.text = item.age.toString()
        }

        init {
            itemView.setOnClickListener{
                listener?.onClick(dataSet[adapterPosition])
            }
        }
    }

    interface MyClickListener{
        fun onClick(item: User)
    }
}