package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.adapter.output.repository.dto.EnderecoDto;
import com.ecommerce.digital.adapter.output.repository.dto.UserDto;
import com.ecommerce.digital.adapter.output.repository.mysql.UserRepository;
import com.ecommerce.digital.application.useCase.EnrollUseCase;
import com.ecommerce.digital.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollInputPortCreate implements EnrollUseCase {

    @Autowired
    UserRepository userRepository;

    @Override
    public void execute(User user) {
        //primeiro verifica se existe o usuário no banco utilizando e-mail

        if (getUserByEmail(user.getEmail()) == null) {
            Integer id = null;
            var nome = user.getNome();
            var email = user.getEmail();
            var idade = user.getIdade();
            var rua = user.getEndereco().getRua();
            var numero = user.getEndereco().getNumero();
            var bairro = user.getEndereco().getBairro();
            var uf = user.getEndereco().getUf();
            var cidade = user.getEndereco().getCidade();
            var cep = user.getEndereco().getCep();

            EnderecoDto endereco = new EnderecoDto(id, rua, numero, bairro, cidade, uf, cep);
            UserDto userDto = new UserDto(id, nome, email, idade, endereco);

            userRepository.save(userDto);
        };
        // quero que devolva um erro ou um aviso dizendo que o email ja está cadastrado.
    }

    public UserDto getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}




