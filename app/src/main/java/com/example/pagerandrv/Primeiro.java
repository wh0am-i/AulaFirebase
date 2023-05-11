package com.example.pagerandrv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Primeiro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Primeiro extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    static ArrayList<Produto> listaProdutos = new ArrayList<>(); //tem que receber o valor de novo.java - não pode ser static se n perde o valor dos items, tem q criar uma nova classe com getter and setter só pra isso
    RecyclerView recycler;

    adaptador2 adapter;

    public Primeiro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Primeiro.
     */
    // TODO: Rename and change types and number of parameters
    public static Primeiro newInstance(String param1, String param2) {
        Primeiro fragment = new Primeiro();
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
                             Bundle savedInstanceState) { //On Create do Adaptador
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_primeiro, container, false);
        cadastroInicial();
        recycler = v.findViewById(R.id.rv);
        recycler.setHasFixedSize(true); //terá um tamanho fixo
        recycler.setLayoutManager(new LinearLayoutManager(v.getContext())); //uma em cima da outra, linear
        adapter = new adaptador2(v.getContext(), listaProdutos, new adaptador2.OnItemClickListener() {//isso aqui é a interface criada
            @Override
            public void onItemClick(Produto p) { //onclick de cada cartão, num geral
                Toast.makeText(v.getContext(), p.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return v; //daqui pra baixo vai outras classes
    }

    public void cadastroInicial() {
        Produto p1 = new Produto("Arroz", "GOSTOSA", (float) 7.49);
        listaProdutos.add(p1);
    }
}