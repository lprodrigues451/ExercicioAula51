package br.com.zup.movieflix.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.R
import br.com.zup.movieflix.databinding.ActivityRegisterBinding
import br.com.zup.movieflix.login.viewmodel.LoginViewModel
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bvLogin.setOnClickListener {
            val register = RegisterModel(
                binding.etUserNameRegister.text.toString(),
                binding.etPasswordRegister.text.toString(),
                binding.etEmailRegister.text.toString(),
                binding.etConfirmPasswordRegister.text.toString()
            )
            viewModel.authentication(register)
            viewModel.response.observe(this){
                if (it != null) {
                    if (it.password == it.passwordTrue){
                        toastMensagemDoBotaoCadastro()
                    } else {
                        toastMensagemErroDeSenha()
                    }
                } else {
                    exibirMensagemErro()
                }
            }
        }
    }
    private fun toastMensagemDoBotaoCadastro() {
        Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
    }

    private fun toastMensagemErroDeSenha() {
        Toast.makeText(this, "Senha são diferente", Toast.LENGTH_SHORT).show()
    }

    private fun exibirMensagemErro() {
        binding.etUserNameRegister.error = "Por favor preencha o campo de nome"
        binding.etPasswordRegister.error = "Por favor preencha o campo de detalhe"
        binding.etEmailRegister.error = "Por favor preencha o campo de detalhe"
        binding.etConfirmPasswordRegister.error = "Por favor preencha o campo de detalhe"
    }
}