package com.example.myhealth

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.myhealth.model.Usuario

class CadastroActivity : AppCompatActivity() {

    private lateinit var fotoUsuario: ImageView
    private lateinit var nomeUsuario: EditText
    private lateinit var botaoCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        nomeUsuario = findViewById(R.id.txtDadosUsuario)
        fotoUsuario = findViewById(R.id.imgUsuario)
        botaoCadastrar = findViewById(R.id.btnCadastrar)


        botaoCadastrar.setOnClickListener {

            val nomeDigitado = nomeUsuario.text.toString()

            if (nomeDigitado.isEmpty()) {
                nomeUsuario.error = "Insira o nome do usuário"
            } else {
                val usuario = Usuario(nomeDigitado)
                exibirUsuario(usuario)
            }
        }

        fotoUsuario.setOnClickListener {
            abrirCamera()
        }
    }

    fun abrirCamera() {
        val CAMERA_REQUEST_CODE = 123
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (cameraIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
        } else {
            Toast.makeText(this, "Tente novamente!", Toast.LENGTH_SHORT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123 && resultCode == RESULT_OK) {
            val imagem = data?.extras?.get("data") as Bitmap
            fotoUsuario.setImageBitmap(imagem)
        }
    }

    fun exibirUsuario(usuario: Usuario) {
        Toast.makeText(
            this,
            "Usuário cadastrado com sucesso!",
            Toast.LENGTH_SHORT
        ).show()

       redirecionar(usuario)
    }

    fun redirecionar(usuario: Usuario) {

        val chaveNomeUsuario = "NOME"
        val chaveFotoUsuario = "IMAGEM"

        val destinoActivity = Intent(this@CadastroActivity, ListaExerciciosActivity::class.java)
        destinoActivity.putExtra(chaveNomeUsuario, usuario.nome)
        destinoActivity.putExtra(chaveFotoUsuario, usuario.foto)
        startActivity(destinoActivity)
        finish()
    }
}
