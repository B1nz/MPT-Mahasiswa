package com.gluthfi.mpt7
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val userList: ArrayList<User>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user: User=userList[position]
        holder?.idMhs?.text = user.id
        holder?.namaMhs?.text = user.nama
        holder?.noMhs?.text = user.nomor
        holder?.alamatMhs?.text = user.alamat

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }


    override fun getItemCount(): Int {

        return userList.size
    }



    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val idMhs = itemView.findViewById(R.id.idMhs) as TextView
        val namaMhs = itemView.findViewById(R.id.namaMhs) as TextView
        val noMhs = itemView.findViewById(R.id.noMhs) as TextView
        val alamatMhs = itemView.findViewById(R.id.alamatMhs) as TextView

    }

}