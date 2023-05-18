package com.example.pagerandrv;

import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Produto {
    String nome, sabor;
    float preco;

    public Produto(String nome, String sabor, float preco) {
        this.nome = nome;
        this.sabor = sabor;
        this.preco = preco;
    }

    public Produto() { //construtor vazio para o Produto P dentro de loadDB no Primeiro.java

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void salvar() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            reference.child("Produtos").child(nome).setValue(this); /*
        nome do produto, é o path e declaras as childs, o setValue seta preco e tipo a partir do nome,
        o mais correto era ter um ID, mas aqui está sendo usado o nome mesmo
        */
    }
}
