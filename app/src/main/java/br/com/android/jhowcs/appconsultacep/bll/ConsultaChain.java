package br.com.android.jhowcs.appconsultacep.bll;

import br.com.android.jhowcs.appconsultacep.apis.BaseAPI;
import retrofit2.Retrofit;

/**
 * Created by jonathan_campos on 24/06/2016.
 */
public abstract class ConsultaChain {
    protected Retrofit retrofit;
    protected ConsultaChain next;

    public ConsultaChain() {
        retrofit = BaseAPI.getRetroInstance();
    }

    public void setNext(ConsultaChain next) {
        this.next = next;
    }

    public abstract void executarConsulta(final String cep, final IConsultaCEPCallback callback);
}
