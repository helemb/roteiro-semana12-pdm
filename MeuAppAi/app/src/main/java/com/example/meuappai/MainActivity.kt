package com.example.meuappai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: ListView = findViewById(R.id.listView_problema)
// 1. Criar a fonte de dados (1.000 itens)
        val listaDeItens = ArrayList<String>()
        for (i in 1..1000) {
            listaDeItens.add("Item número $i")
        }
// 2. Criar e ligar nosso Adapter Ingênuo
        val adapter = AdapterOtimizado(this, listaDeItens)
        listView.adapter = adapter
//3. Criar uma mensagem ao clicar no item, para verificar que são itens diferentes.
        listView.setOnItemClickListener { parent, view, position, id ->
            val itemClicado = listaDeItens[position]
// Criar e exibir o Toast
            Toast.makeText(
                this,
                "Você clicou no: $itemClicado",
                Toast.LENGTH_SHORT // A duração

            ).show()
        }
    }
}