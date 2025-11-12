package com.example.meuappai

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterIngenuo(
    private val context: Context,
    private val dados: List<String>
) : BaseAdapter() {
    // Para inflar as views
    private val layoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return dados.size
    }
    override fun getItem(position: Int): Any {
        return dados[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    // método crítico, implementado de forma ingenua.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewNova = layoutInflater.inflate(R.layout.layout_item_linha, parent, false)
        Log.d("AdapterIngenuo", "PROBLEMA 1: Inflou um novo XML para a posição $position")
//Para acompanhar pelo logcat
         val imagem: ImageView = viewNova.findViewById(R.id.item_imagem)
        Log.d("AdapterIngenuo", "PROBLEMA 2: Chamando findViewById() para a posição $position")
        val texto: TextView = viewNova.findViewById(R.id.item_texto)
// Pegar o dado para esta posição
        val item = dados[position]
// Popular os dados, só mudando o texto, a imagem é a mesma, poderíamos modificar a imagem neste ponto.
        texto.text = item
        return viewNova
    }
}