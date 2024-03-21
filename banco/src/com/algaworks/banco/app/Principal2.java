package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal2 {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("João da silva", "55566677788");
        Pessoa pessoa2 = new Pessoa("Maria Catarina", "11122233344");
        //System.out.println(pessoa1.toString());

        //List<Pessoa> pessoas = new ArrayList<>();
        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        //System.out.println(pessoas);

//        for (int i = 0; i < pessoas.size(); i++) {
//            System.out.println(pessoas.get(i).getNome());
//        }

//        for (Pessoa pessoa : pessoas) {
//            System.out.println(pessoa.getNome());
//        }

        Pessoa pessoa4 = new Pessoa("João da silva", "55566677788");

        boolean existe = pessoas.contains(pessoa4);
        System.out.println(existe);
    }

}
