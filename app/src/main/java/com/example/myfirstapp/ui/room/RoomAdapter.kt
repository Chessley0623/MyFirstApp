package com.example.myfirstapp.ui.room

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfirstapp.R
import com.example.myfirstapp.data.model.people.PeopleItemModel
import com.example.myfirstapp.data.model.room.RoomItemModel
import com.example.myfirstapp.databinding.ItemPeopleBinding
import com.example.myfirstapp.databinding.ItemRoomBinding
import com.example.myfirstapp.ui.people.PeopleAdapter
import java.text.SimpleDateFormat

class RoomAdapter(
    val data: ArrayList<RoomItemModel>,
    val function: (RoomItemModel) -> Unit
    ) : RecyclerView.Adapter<RoomAdapter.ViewHolder>() {
    inner class ViewHolder(val view: ItemRoomBinding) : RecyclerView.ViewHolder(view.root){

        fun initUI(roomItemModel: RoomItemModel){
            val parser =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formatter = SimpleDateFormat("MM.dd.yyyy HH:mm")
            val formattedDate = formatter.format(parser.parse("${roomItemModel.createdAt}"))
            view.tvId.text = "Room ID ${roomItemModel.id}"
            view.tvCreated.text = "Created On ${formattedDate}"
            view.tvCapacity.text = "Capacity ${roomItemModel.maxOccupancy}"
            if(roomItemModel.isOccupied == true){
                view.tvOccupied.text = "Vacant"
                view.tvOccupied.setTextColor(Color.GREEN)
            }
            else{
                view.tvOccupied.text = "Occupied"
                view.tvOccupied.setTextColor(Color.RED)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemRoomBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RoomAdapter.ViewHolder, position: Int) {
        holder.initUI(data[position])
    }
}