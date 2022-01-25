package com.mogga.planto

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter (private val planet:List<PlanetData>):RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,PlanetDetail::class.java)
            holder.itemView.context.startActivity(intent)
        }
        var dummyImage:Int? = null
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + " m km"
        holder.gravity.text = planet[position].gravity + "m/ss"

        when (planet[position].title!!.toLowerCase()) {
            "mars" -> {
                dummyImage = R.drawable.ic_mars
            }
            "neptune" -> {
                dummyImage = R.drawable.ic_neptune
            }
            "earth" -> {
                dummyImage = R.drawable.ic_earth
            }
            "moon" -> {
                dummyImage = R.drawable.ic_moon
            }
            "venus" -> {
                dummyImage = R.drawable.ic_venus
            }
            "jupiter" -> {
                dummyImage = R.drawable.ic_jupiter
            }
            "saturn" -> {
                dummyImage = R.drawable.ic_saturn
            }
            "uranus" -> {
                dummyImage = R.drawable.ic_uranus
            }
            "mercury" -> {
                dummyImage = R.drawable.ic_mercury
            }
            "sun" -> {
                dummyImage = R.drawable.ic_sun
            }
        }
        holder.planetImg.setImageResource(dummyImage!!)


    }

    override fun getItemCount(): Int {
        return planet.size
    }

}

class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
    var title: TextView = view.titleText
    var planetImg: ImageView = view.planet_img
    var galaxy: TextView = view.galaxy
    var distance: TextView = view.distance
    var gravity: TextView = view.gravity



}