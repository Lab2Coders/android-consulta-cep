package br.com.android.jhowcs.appconsultacep.bll;

import br.com.android.jhowcs.appconsultacep.models.Cep;

/**
 * Created by jonathan_campos on 24/06/2016.
 */
public interface IConsultaCEPCallback {
    void onError(String message);
    void onSucess(Cep cepResult);
}
