package br.com.fabriciocurvello.hotdog2activities

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SegundaActivity : AppCompatActivity() {

    //Iniciando as variáveis e definindo os seus tipos:
    // SA -> SegundaActivity
    lateinit var clienteTvSA: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //"Linkando" as variáveis às views do activity_segunda.xml
        clienteTvSA = findViewById(R.id.tv_cliente_sa)


        //Recuperar dados que foram enviados via intent
        val dados = intent.extras
        /*
        O QUE FOI ENVIADO:
            intent.putExtra("chave_cliente", cliente)
            intent.putExtra("chave_proteina_selecionada", proteinaSelecionada)
            intent.putExtra("chave_molhos_selecionados", molhosSelecionados)
            intent.putExtra("chave_acompanhamentos_selecionados", acompanhamentosSelecionados)
         */
        //Extraindo cada item da val dados:
        val cliente = dados!!.getString("chave_cliente")
        val proteinas = dados!!.getString("chave_proteina_selecionada")
        val molhos = dados!!.getString("chave_molhos_selecionados")
        val acompanhamentos = dados!!.getString("chave_acompanhamentos_selecionados")

//        Log.i("SELECOES", cliente + "\n" +
//                proteinas + "\n" +
//                molhos + "\n" +
//                acompanhamentos)

        //setando o nome do cliente em clienteTvSA
        clienteTvSA.text = cliente

        var pedido = "Cliente: " + cliente + "\n\n" +
                proteinas + "\n" +
                molhos + "\n" +
                acompanhamentos



    }//fim do onCreate()
}