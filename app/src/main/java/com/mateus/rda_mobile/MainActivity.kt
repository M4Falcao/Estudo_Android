package com.mateus.rda_mobile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mateus.rda_mobile.databinding.ActivityExameBinding
import com.mateus.rda_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nome: String? = null

        binding.btExame.setOnClickListener{
            val mIntent = Intent(this, ExameActivity::class.java)
            mIntent.putExtra("INTENT_NOME", nome)

            startActivity(mIntent)
            finish()
        }

        binding.btCadastro.setOnClickListener{
            val sharedPreferences = getSharedPreferences(
                "cadastro",
                Context.MODE_PRIVATE
            )
            val editPrefs = sharedPreferences.edit()

            var nome = binding.editTextTextPersonName.text.toString().trim()
            var dataNascimento = binding.editTextDate.text.toString().trim()

            editPrefs.putString("NOME", nome)
            editPrefs.putString("DATA", dataNascimento)

            editPrefs.apply()

        }

    }
}