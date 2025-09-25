package android.Caroline.atividade;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private EditText nota4;
    private EditText faltas;

    private Button btnCalcular;

    private TextView resultado;

    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponentes();

        btnCalcular.setOnClickListener(View ->{
            validaCampo();
            CalculaMedia();
            resultado.setText("você clicou no botão calcular");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void CalculaMedia() {
        double n1 = Double.parseDouble(nota1.getText().toString());
        double n2 = Double.parseDouble(nota2.getText().toString());
        double n3 = Double.parseDouble(nota3.getText().toString());
        double n4 = Double.parseDouble(nota4.getText().toString());
        double media = (n1 + n2 + n3 + n4) / 4;

        double falta = Double.parseDouble(faltas.getText().toString().toString());

        if (media > 7){
            if ( falta < 20) {
                resultado.setTextColor(Color.parseColor("#F44336"));
                resultado.setText("Exesso de falta " + media);
            } else {
                resultado.setTextColor(Color.parseColor("#437845"));
                resultado.setText("Aluno aprovado com média " + media);
            }
        }else{
            resultado.setTextColor(Color.parseColor("#F44336"));
            resultado.setText("Aluno retido com média " + media);
        }
    }

    private void validaCampo() {
        if (TextUtils.isEmpty(nota1.getText())){
            nota1.setError("este campo não pode estar vazio.");
        } else if (TextUtils.isEmpty(nota2.getText())) {
            nota2.setError("este campo não pode estar vazio.");
        } else if (TextUtils.isEmpty(nota3.getText())){
            nota3.setError("este campo não pode estar vazio.");
        } else if (TextUtils.isEmpty(nota4.getText())) {
            nota4.setError("este campo não pode estar vazio.");
        }
    }

    private boolean validaCAmpos2(){
        boolean camposValidos = true;
        if (nota1.getText().toString().isEmpty()){
            camposValidos = false;
        }else if ( nota2.getText().toString().isEmpty() ){
            camposValidos = false;
        } else if (nota3.getText().toString().isEmpty()) {
            camposValidos = false;
        } else if ( nota4.getText().toString().isEmpty()) {
            camposValidos = false;
        };

        return camposValidos;
    }

    private boolean initComponentes() {

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        faltas = findViewById(R.id.numerofaltas);
        btnCalcular = findViewById(R.id.button2);
        resultado = findViewById(R.id.resultado);

        return false;
    }

    private boolean validaCampos3(){
        return nota1.getText().toString().isEmpty()
                && nota2.getText().toString().isEmpty()
                && nota3.getText().toString().isEmpty()
                && nota4.getText().toString().isEmpty();
    }
}