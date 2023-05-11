package com.example.pagerandrv;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Quarto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Quarto extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    static ArrayList<Produto> listaProdutos;
    Button cadastrar;
    TextView Preco, Nome;
    EditText categoria;


    public Quarto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Quarto.
     */
    // TODO: Rename and change types and number of parameters
    public static Quarto newInstance(String param1, String param2) {
        Quarto fragment = new Quarto();
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
        View v = inflater.inflate(R.layout.fragment_quarto, container, false);
        //listaProdutos = com.example.aularecycler.listaProdutos.getListaProdutos();
        Preco = v.findViewById(R.id.Preco);
        Nome = v.findViewById(R.id.Nome);
        categoria = v.findViewById(R.id.categoria);
        cadastrar = v.findViewById(R.id.cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });
        return v;
    }

    public void cadastrar() {
        String textnome = Nome.getText().toString();
        String textcateg = categoria.getText().toString();
        listaProdutos = Primeiro.listaProdutos;

        if (!textnome.isEmpty() && !textcateg.isEmpty() && !Preco.getText().toString().isEmpty()) {
            float floatpreco = Float.parseFloat(Preco.getText().toString());
            Produto i = new Produto(textnome, textcateg, floatpreco);
            listaProdutos.add(i);
            Primeiro.listaProdutos = listaProdutos;
        }
    }
}