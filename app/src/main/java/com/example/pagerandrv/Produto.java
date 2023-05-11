package com.example.pagerandrv;

public class Produto {
    String nome, sabor;
    float preco;

    public Produto(String nome, String sabor, float preco) {
        this.nome = nome;
        this.sabor = sabor;
        this.preco = preco;
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
}
