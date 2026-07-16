package model;

import enums.TipoPet;
import enums.TipoSexo;

public class Pet {
    private String name;
    private TipoPet pet;
    private TipoSexo sexo;
    private String numero;
    private String rua;
    private String cidade;
    private String idade;
    private String peso;
    private String raca;

    public Pet(String name, TipoPet pet, TipoSexo sexo, String numero, String rua, String cidade, String idade, String peso, String raca) {
        this.name = name;
        this.pet = pet;
        this.sexo = sexo;
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TipoPet getPet() {
        return pet;
    }

    public void setPet(TipoPet pet) {
        this.pet = pet;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "pet: " +
                "name: " + name +
                "tipo: " + pet +
                ", sexo: " + sexo +
                ", numero: " + numero +
                ", rua: " + rua +
                ", cidade: " + cidade +
                ", idade: " + idade +
                ", peso: " + peso +
                ", raca: " + raca;
    }


}