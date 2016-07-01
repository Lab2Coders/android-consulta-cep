package br.com.android.jhowcs.appconsultacep.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jonathan_campos on 24/06/2016.
 */
public class BaseAPI {
    private static final String ENDPOINT = "http://www.devmedia.com.br/api/";

    private static Retrofit retrofit;

    private BaseAPI() {}

    public static Retrofit getRetroInstance() {
        if(retrofit != null) {
            return retrofit;
        }
        return retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
