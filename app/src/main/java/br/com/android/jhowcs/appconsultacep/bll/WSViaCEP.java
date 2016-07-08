package br.com.android.jhowcs.appconsultacep.bll;

import android.util.Log;

import br.com.android.jhowcs.appconsultacep.apis.IViaCEPService;
import br.com.android.jhowcs.appconsultacep.models.Cep;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jonathan_campos on 24/06/2016.
 */
public class WSViaCEP extends ConsultaChain {
    private static final String TAG = WSViaCEP.class.getCanonicalName();

    @Override
    public void executarConsulta(final String cep, final IConsultaCEPCallback callback) {
        String consultaCep = String.format("http://viacep.com.br/ws/%s/json/", cep);

        IViaCEPService viaCEPService = retrofit.create(IViaCEPService.class);

        Call<Cep> call = viaCEPService.getCEP(consultaCep);

        call.enqueue(new Callback<Cep>() {
            @Override
            public void onResponse(Call<Cep> call, Response<Cep> response) {
                Cep cep = response.body();

                callback.onSucess(cep);
            }

            @Override
            public void onFailure(Call<Cep> call, Throwable t) {
                Log.e(TAG, "Erro ao consultar serviço ViaCep");

                if(next == null) {
                    callback.onError("Error");
                } else {
                    Log.i(TAG, "Tentando conexão com próximo serviço!");
                    next.executarConsulta(cep, callback);
                }
            }
        });
    }
}
