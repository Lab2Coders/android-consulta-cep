package br.com.android.jhowcs.appconsultacep.bll;

/**
 * Created by jonathan_campos on 24/06/2016.
 */
public class ConsultaCEP {
    private IConsultaCEPCallback callback;
    private ConsultaChain consultaChain;

    public ConsultaCEP(IConsultaCEPCallback callback) {
        consultaChain = new WSDevMedia();

        WSViaCEP wsViaCEP = new WSViaCEP();

        consultaChain.setNext(wsViaCEP);

        this.callback = callback;
    }

    public void executarConsultaCEP(final String cep) {
        consultaChain.executarConsulta(cep, this.callback);
    }
}
