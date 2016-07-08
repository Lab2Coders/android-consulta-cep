package br.com.android.jhowcs.appconsultacep.bll;

import android.util.Log;

import br.com.android.jhowcs.appconsultacep.apis.IDevMediaService;
import br.com.android.jhowcs.appconsultacep.models.Cep;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jonathan_campos on 24/06/2016.
 */
public class WSDevMedia extends ConsultaChain {

    private static final String TAG = WSDevMedia.class.getCanonicalName();

    @Override
    public void executarConsulta(final String cep, final IConsultaCEPCallback callback) {
        IDevMediaService devMediaService = retrofit.create(IDevMediaService.class);

        Call<Cep> call = devMediaService.getCEP(cep, "MVRJHSN7", "json");


        call.enqueue(new Callback<Cep>() {
            @Override
            public void onResponse(Call<Cep> call, Response<Cep> response) {
                Cep cepObj = response.body();

                if(cepObj.getResultado().indexOf("falha") > -1) {
                    Log.e(TAG, "Erro ao consultar serviço DevMedia");

                    if(next == null) {
                        callback.onError("Error");
                    } else {
                        Log.i(TAG, "Tentando conexão com próximo serviço!");
                        next.executarConsulta(cep, callback);
                    }
                } else
                    callback.onSucess(cepObj);
            }

            @Override
            public void onFailure(Call<Cep> call, Throwable t) {
                Log.e(TAG, "Erro ao consultar serviço DevMedia");

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
