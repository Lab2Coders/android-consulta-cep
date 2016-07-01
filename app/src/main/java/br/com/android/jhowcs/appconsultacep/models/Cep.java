package br.com.android.jhowcs.appconsultacep.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jonathan_campos on 24/06/2016.
 */
public class Cep {
    @SerializedName(value = "resultado_txt")
    private String resultado;

    @SerializedName(value = "cidade", alternate = {"localidade"})
    private String cidade;
    private String bairro;
    private String logradouro;
    private String uf;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}