package com.example.gabriel.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){
        String opcoes[] = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        ImageView image = (ImageView) findViewById(R.id.imageResultado);
        TextView textResultado = (TextView) findViewById(R.id.textResultado);

        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "pedra":
                image.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                image.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                image.setImageResource(R.drawable.tesoura);
                break;
        }

        //App vencedor
        if((escolhaApp == "pedra" && escolhaUsuario == "tesoura") || (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra")){
            textResultado.setText("Você perdeu!");
        }
        //Usuario vencedor
        else if((escolhaUsuario == "pedra" && escolhaApp == "tesoura") || (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra")){
            textResultado.setText("Você ganhou!");
        }
        else{
            textResultado.setText("Empate!");
        }
    }

}
