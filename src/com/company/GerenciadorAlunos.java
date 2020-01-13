package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorAlunos {

    ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        int opcao = 0;

        do {
            System.out.println("Escolha dentre as opções a seguir: (1) Cadastra aluno (2) Lista os alunos cadastrados (9) Sair");
            Scanner scanner = new Scanner(System.in);

            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Informe o nome do aluno: ");
                String nome = scanner.next();
                if ((nome == null) || (nome.trim().equals(""))) {
                    System.out.println("Nome não pode ser nulo.");
                    continue;
                }

                System.out.println("Informe a idade do aluno: ");
                int idade = scanner.nextInt();
                if (idade < 10 || idade > 18){
                    System.out.println("Idade do aluno deve ser entre 10 e 18 anos.");
                    continue;
                }

                System.out.println("Informe o documento do aluno: ");
                String documento = scanner.next();
                if((documento == null) || (documento.trim().length() < 10)) {
                    System.out.println("Documento não pode ser nulo e deve conter no minimo 10 caracteres.");
                    continue;
                }

                gerenciadorAlunos.listaAlunos.add(new Aluno(nome,idade,documento));

            } else if (opcao == 2) {
                if (gerenciadorAlunos.listaAlunos.size() == 0) {
                    System.out.println("Não há alunos cadastrados.");
                } else {
                    for (Aluno aluno : gerenciadorAlunos.listaAlunos) {
                        System.out.println("[Aluno] Nome: " + aluno.getNome() + " | Idade: " + aluno.getIdade() + " | Documento: " + aluno.getDocumento());
                    }
                }
            }
        } while (opcao != 9);
    }
}
