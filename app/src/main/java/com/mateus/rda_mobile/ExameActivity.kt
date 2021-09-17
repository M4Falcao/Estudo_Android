package com.mateus.rda_mobile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mateus.rda_mobile.databinding.ActivityExameBinding
import java.text.DecimalFormat


class ExameActivity : AppCompatActivity() {

    private lateinit var binding:ActivityExameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPrefs = getSharedPreferences(
            "cadastro",
            Context.MODE_PRIVATE
        )
        val nome = sharedPrefs.getString("NOME", "")
        binding.txdNomePaciente.setText(nome)


        binding.btCalcular.setOnClickListener{

            var peso = binding.tdPeso.text.toString().toDouble()
            var altura = binding.tdAltura.text.toString().toDouble()
            var imc = peso / (altura * altura)
            val dec = DecimalFormat("#,###.00")

            if(imc<=18.5){
                binding.txdResultado.setText("IMC: ${dec.format(imc)} -- MAGREZA ")
                binding.txdResultado.setTextColor(Color.BLUE)

            }else if(imc<=24.9){
                binding.txdResultado.setText("IMC: ${dec.format(imc)} -- NORMAL ")
                binding.txdResultado.setTextColor(Color.GREEN)

            }else if(imc<=29.9){
                binding.txdResultado.setText("IMC: ${dec.format(imc)} -- SOBREPESO ")
                binding.txdResultado.setTextColor(Color.YELLOW)

            }else if(imc<=39.9){
                binding.txdResultado.setText("IMC: ${dec.format(imc)} -- OBESIDADE ")
                binding.txdResultado.setTextColor(Color.parseColor("#FF8C00"))

            }else if(imc>40){
                binding.txdResultado.setText("IMC: ${dec.format(imc)} -- OBESIDADE GRAVE ")
                binding.txdResultado.setTextColor(Color.RED)

            }
        }

        binding.btVoltar.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java)

            startActivity(mIntent)
            finish()
        }

    }
}