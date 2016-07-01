package br.com.android.jhowcs.appconsultacep.apis;

import br.com.android.jhowcs.appconsultacep.models.Cep;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jonathan_campos on 24/06/2016.
 */
public interface IDevMediaService {
    @GET("cep/service")
    Call<Cep> getCEP(@Query("cep") final String cep,
                     @Query("chave") final String chave,
                     @Query("formato") final String formato);
}
