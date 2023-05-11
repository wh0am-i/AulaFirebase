package com.example.pagerandrv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

class Adaptador extends FragmentStateAdapter {

    public Adaptador(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new Segundo();
            case 2:
                return new Terceiro();
            case 3:
                return new Quarto();
        }
        return new Primeiro();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
public class adaptador2 extends RecyclerView.Adapter<adaptador2.MyViewHolder> {
    Context context;
    ArrayList<Produto> listaProdutos;
    adaptador2.OnItemClickListener listener;

    public adaptador2(Context context, ArrayList<Produto> listaProdutos, OnItemClickListener listener) {
        this.context = context;
        this.listaProdutos = listaProdutos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public adaptador2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        return new adaptador2.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptador2.MyViewHolder holder, int position) {
        Produto p = listaProdutos.get(position);
        holder.nome.setText(p.getNome());
        holder.preco.setText("R$"+p.getPreco());
        holder.sabor.setText(p.getSabor());
        holder.itemView.setOnClickListener(view ->{
            listener.onItemClick(p);
        });
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }


    public interface OnItemClickListener {
        void onItemClick(Produto p);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder { //extende ao pacote RecyclerView
        TextView nome, sabor, preco;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            sabor = itemView.findViewById(R.id.sabor);
            preco = itemView.findViewById(R.id.preco);
        }
    }

}
