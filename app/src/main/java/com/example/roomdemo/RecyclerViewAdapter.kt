package com.example.roomdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.db.UserEntity
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter(val listener: RowClickListener) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var item = ArrayList<UserEntity>()

    fun setistData(data: ArrayList<UserEntity>) {
        this.item = data
    }

    class MyViewHolder(view: View,val listener: RowClickListener) : RecyclerView.ViewHolder(view) {

        val tvName = view.tvName
        val tvEmail = view.tvEmail
        val deleteUserID = view.deleteUserID

        fun bind(data: UserEntity) {

            tvName.text = data.name
            tvEmail.text = data.email

            deleteUserID.setOnClickListener {
                listener.onDeleteUserClickListener(data)
            }

        }
    }

    interface RowClickListener {
        fun onDeleteUserClickListener(user: UserEntity)
        fun onItemClickListener(user: UserEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return MyViewHolder(inflater,listener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(item[position])
        }
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }


}


