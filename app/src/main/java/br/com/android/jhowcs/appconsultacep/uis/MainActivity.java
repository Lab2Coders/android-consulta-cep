package br.com.android.jhowcs.appconsultacep.uis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.android.jhowcs.appconsultacep.bll.IConsultaCEPCallback;
import br.com.android.jhowcs.appconsultacep.R;
import br.com.android.jhowcs.appconsultacep.models.Cep;

public class MainActivity extends AppCompatActivity implements IConsultaCEPCallback {
    private EditText edtCEP;
    private Button btnConsultar;

    private EditText edtLogradouro;
    private EditText edtBairro;
    private EditText edtCidade;
    private EditText edtEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCEP          = (EditText) findViewById(R.id.edtCEP);
        edtLogradouro   = (EditText) findViewById(R.id.edtLogradouro);
        edtBairro       = (EditText) findViewById(R.id.edtBairro);
        edtCidade       = (EditText) findViewById(R.id.edtCidade);
        edtEstado       = (EditText) findViewById(R.id.edtEstado);

        btnConsultar    = (Button) findViewById(R.id.btnConsultar);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cep = edtCEP.getText().toString();
            }
        });

    }

    @Override
    public void onError(String message) {
        Log.i("CEP", message);
    }

    @Override
    public void onSucess(Cep cepResult) {
        if(cepResult != null) {
            edtLogradouro.setText(cepResult.getLogradouro());
            edtBairro.setText(cepResult.getBairro());
            edtCidade.setText(cepResult.getCidade());
            edtEstado.setText(cepResult.getUf());
        }
    }
}