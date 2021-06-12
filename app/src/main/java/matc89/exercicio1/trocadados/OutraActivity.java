package matc89.exercicio1.trocadados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OutraActivity extends AppCompatActivity {

    private EditText editText;
    public String novonome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        String texto = getIntent().getStringExtra("nome");
        editText=findViewById(R.id.editText);
        editText.setText(texto);

    }

    public void confirmar(View view ){
        novonome = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("novonome",novonome);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void cancelar(View view){
        finish();
    }
}