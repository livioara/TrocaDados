package matc89.exercicio1.trocadados;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String nome;
    private static final String CHAVE = "numero";
    private TextView txtview;
    Intent intent;
    public int cont=1;
    private TextView estadotxt;
    private String mudaEstado;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtview = findViewById(R.id.textView);
        estadotxt=findViewById(R.id.estado);
        txtview.setText(nome);
       // mudaEstado = estadotxt.getText().toString();
        //estadotxt.setText("CREATE" +mudaEstado);



    }


    public void trocar(View view){

        //nome = txtview.getText().toString();
        //txtview.setText(nome );
        //nome=recebeNome;
        intent = new Intent(this,OutraActivity.class);
        intent.putExtra("nome",nome);
        startActivityForResult(intent,1234);

    }


    @Override
    protected void onResume() {
        super.onResume();

            if (nome == null) {
                txtview.setText("Oi!");
            } else {
                txtview.setText("Oi! " + nome);

            }
       // mudaEstado = estadotxt.getText().toString();
       // estadotxt.setText("RESUME" +mudaEstado);


    }

    @Override
    protected void onStart() {
        super.onStart();
      //  mudaEstado = estadotxt.getText().toString();
       // estadotxt.setText("START" +mudaEstado);

    }

    @Override
    protected void onStop() {
        super.onStop();
       // mudaEstado = estadotxt.getText().toString();
       // estadotxt.setText("STOP" +mudaEstado);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode ==RESULT_OK) {
            nome = data.getStringExtra("novonome");
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CHAVE,nome);



    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        nome = savedInstanceState.getString(CHAVE,"");

    }
}