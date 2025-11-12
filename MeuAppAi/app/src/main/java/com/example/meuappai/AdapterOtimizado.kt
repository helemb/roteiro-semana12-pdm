package com.example.meuappai

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterOtimizado(
    private val context: Context,
    private val dados: List<String>
) : BaseAdapter() {
    private val layoutInflater = LayoutInflater.from(context)
    // O PADRÃO ViewHolder Uma classe que segura as views do layout
// Assim não tempos que usar findViewById() toda hora.
    private class ViewHolder(view: View) {
        val imagem: ImageView = view.findViewById(R.id.item_imagem)
        val texto: TextView = view.findViewById(R.id.item_texto)
// O findViewById() é chamado somente neste ponto um única vez.
    }
    override fun getCount(): Int {
        return dados.size
    }
    override fun getItem(position: Int): Any {
        return dados[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    //getview é implementando usando o ViewHolder
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder
// Reutilização com o convertView, que é uma view antiga que saiu da tela e pode ser reutilizada.
        if (convertView == null) {
// Se for nulo, não há view para reutilizar, ai precisamos inflar uma nova.
            Log.d("AdapterOtimizado", "SOLUÇÃO 1: Inflou um NOVO XML para a posição $position")

            view = layoutInflater.inflate(R.layout.layout_item_linha, parent, false)
// Crie e anexa no ViewHolder
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
            Log.d("AdapterOtimizado", "SOLUÇÃO 2: findViewById() chamado UMA SÓ VEZ para a posição $position")
        } else {
// O sistema possui uma view para reutilizar!
            Log.d("AdapterOtimizado", ">>> REUTILIZANDO view existente para a posição $position <<<")
            view = convertView
// Recupera o ViewHolder anexado
            viewHolder = view.tag as ViewHolder
        }
// Usamos o ViewHolder que foi criado ou recuperado
        val item = dados[position]
        viewHolder.texto.text = item
        return view
    }
}