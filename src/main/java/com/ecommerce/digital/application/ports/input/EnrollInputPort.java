package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.adapter.output.repository.dto.UserDto;
import com.ecommerce.digital.adapter.output.repository.mysql.UserRepository;
import com.ecommerce.digital.application.useCase.EnrollUseCase;
import com.ecommerce.digital.domain.User;

public class EnrollInputPort implements EnrollUseCase {
    UserRepository userRepository;

    @Override
    public void execute(User user) {
        //primeiro verifica se existe o usuário no banco utilizando e-mail ou RG
        if (getUserByName(user.getNome()) == null) {
            var nome = user.getNome();
            var idade = user.getIdade();
            var endereco = user.getEndereco();

            UserDto userDto = new UserDto(nome, idade, endereco);
            userRepository.save(userDto);
        };
    }

    public UserDto getUserByName(String nome) {
        return userRepository.getByNome(nome);
    }
}
