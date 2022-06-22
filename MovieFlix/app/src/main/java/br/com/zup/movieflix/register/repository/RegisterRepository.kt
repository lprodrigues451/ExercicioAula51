package br.com.zup.movieflix.register.repository

import android.widget.Toast
import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository {

     fun recuperarResister(registerModel: RegisterModel): RegisterModel? {

        if (registerModel.name.isNotEmpty()
            && registerModel.email.isNotEmpty()
            && registerModel.password.isNotEmpty()
            && registerModel.passwordTrue.isNotEmpty()
        ) {
            return RegisterModel(
                registerModel.name,
                registerModel.password,
                registerModel.email,
                registerModel.passwordTrue
            )
        }
        return null
    }
}