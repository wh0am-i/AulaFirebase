package com.example.pagerandrv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Segundo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Segundo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static ArrayList<Produto> listaProdutos;
    ArrayList<Produto> listaTemp = new ArrayList<>();
    Button pesquisar;
    RecyclerView recycler;

    TextView Preco, Nome;
    EditText categoria;
    adaptador2 adapter;

    public Segundo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Segundo.
     */
    // TODO: Rename and change types and number of parameters
    public static Segundo newInstance(String param1, String param2) {
        Segundo fragment = new Segundo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_segundo, container, false);
        listaProdutos = Primeiro.listaProdutos;
        Preco = v.findViewById(R.id.Preco);
        Nome = v.findViewById(R.id.Nome);
        categoria = v.findViewById(R.id.categoria);
        pesquisar = v.findViewById(R.id.pesquisar);
        recycler = v.findViewById(R.id.rv);
        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pesquisar();
            }
        });
        recycler.setHasFixedSize(true); //terá um tamanho fixo
        recycler.setLayoutManager(new LinearLayoutManager(v.getContext())); //uma em cima da outra, linear
        adapter = new adaptador2(v.getContext(), listaProdutos, new adaptador2.OnItemClickListener() {//isso aqui é a interface criada
            //@Override
            public void onItemClick(Produto p) { //onclick de cada cartão, num geral
                Toast.makeText(v.getContext(), p.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return v;

    }

    public void pesquisar() {
        String textnome = Nome.getText().toString();
        String textcateg = categoria.getText().toString();
        float floatpreco = 0;
        if (!Preco.getText().toString().isEmpty()) {
            floatpreco = Float.parseFloat(Preco.getText().toString());
        }
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto p = listaProdutos.get(i);
            if (textnome.equals(p.getNome()) || textcateg.equals(p.getSabor()) || floatpreco == p.getPreco()) {
                listaTemp.add(p);
            }
        }
        adapter = new adaptador2(adapter.context, listaTemp, new adaptador2.OnItemClickListener() {//isso aqui é a interface criada
            @Override
            public void onItemClick(Produto p) { //onclick de cada cartão, num geral
                Toast.makeText(adapter.context, p.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}