package br.com.android.jhowcs.appconsultacep.apis;

import br.com.android.jhowcs.appconsultacep.models.Cep;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by jonathan_campos on 24/06/2016.
 */
public interface IViaCEPService {
    @GET
    Call<Cep> getCEP(@Url String url);
}
