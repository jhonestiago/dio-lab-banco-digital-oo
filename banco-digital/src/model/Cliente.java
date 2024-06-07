package model;

public class Cliente {

    // Atributos
    private String nome;
    private String cpf;
    private String senha;

    // Construtor
    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    // Métodos
    // Método para validar a senha
    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    // Método para validar o CPF
    private boolean validarCpf(String cpf) {
        // Flags
        boolean valido = false;
        boolean numerosIguais = true;

        // Verifica se todos os números do CPF são iguais
        for (int i = 0; i < (cpf.length() - 1); i++) {
            if (cpf.charAt(i) != cpf.charAt(i + 1)) {
                numerosIguais = false;
                break;
            }
        }

        // Se todos os números são iguais ou o tamanho do CPF é diferente de 11, 
        // retorna inválido
        if (numerosIguais || cpf.length() != 11) {
            return valido;
        }

        int primeiroSomatorio = 0;
        int j = 10;

        // Calcula o somatório dos primeiros 9 dígitos, 
        // multiplicando cada um pelo peso decrescente
        for (int i = 0; i < (cpf.length() - 2); i++) {
            if (j >= 2) {
                primeiroSomatorio += (Character.getNumericValue(cpf.charAt(i)) * j);
                j--;
            }
        }

        // Calcula o primeiro dígito verificador
        int primeiroResto = (primeiroSomatorio * 10) % 11;
        if (primeiroResto == 10) {
            primeiroResto = 0;
        }

        int segundoSomatorio = 0;
        int k = 11;

        // Calcula o somatório dos primeiros 10 dígitos, 
        // multiplicando cada um pelo peso decrescente
        for (int i = 0; i < (cpf.length() - 1); i++) {
            if (k >= 2) {
                segundoSomatorio += (Character.getNumericValue(cpf.charAt(i)) * k);
                k--;
            }
        }

        // Calcula o segundo dígito verificador
        int segundoResto = (segundoSomatorio * 10) % 11;
        if (segundoResto == 10) {
            segundoResto = 0;
        }

        // Extrai o 10º e 11º dígitos do CPF (dígitos verificadores fornecidos)
        int decimoDigito = Character.getNumericValue(cpf.charAt(9));
        int decimoPrimeiroDigito = Character.getNumericValue(cpf.charAt(10));

        // Verifica se os dígitos verificadores calculados correspondem aos dígitos fornecidos
        if (primeiroResto == decimoDigito && segundoResto == decimoPrimeiroDigito) {
            valido = true;
        }

        return valido;
    }

    // Getters e Setters

    // nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && nome.length() > 2) {
            this.nome = nome;
        } else {
            System.out.println("Nome inválido");
        }
    }

    // cpf
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        if (validarCpf(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido");
        }
    }

    // senha
    public void setSenha(String senhaUm, String senhaDois) {
        if (senhaUm.equals(senhaDois)) {
            this.senha = senhaUm;
        } else {
            System.out.println("Senhas diferentes");
        }
    }

}