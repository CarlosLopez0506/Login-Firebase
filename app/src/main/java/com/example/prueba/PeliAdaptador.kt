package com.example.prueba

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class PeliAdaptador(private val context: Activity, private val arrayList: ArrayList<Pelicula>) :
    ArrayAdapter<Pelicula>(context, R.layout.item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        var view: View = inflater.inflate(R.layout.item, null)

        view.findViewById<TextView>(R.id.nombre).text = arrayList[position].nombre.toString()
        view.findViewById<TextView>(R.id.genero).text = arrayList[position].genero.toString()
        view.findViewById<TextView>(R.id.anio).text = arrayList[position].anio.toString()

        if(arrayList[position].genero == "comedia"){
            view.findViewById<ImageView>(R.id.imagen).setImageDrawable(ContextCompat.getDrawable(context,R.drawable.comedia))
        }
        if(arrayList[position].genero == "accion"){
            view.findViewById<ImageView>(R.id.imagen).setImageDrawable(ContextCompat.getDrawable(context,R.drawable.accion))
        }

        return view
//        return super.getView(position, convertView, parent)
    }
}