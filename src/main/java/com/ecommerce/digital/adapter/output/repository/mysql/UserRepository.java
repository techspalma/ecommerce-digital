package com.ecommerce.digital.adapter.output.repository.mysql;

import com.ecommerce.digital.adapter.output.repository.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // interface de JPA. Através dela tenho acesso aos métodos de CRUD já existentes para gravar/ler dados do banco.
public interface UserRepository extends JpaRepository<UserDto, Integer> {
    public UserDto findByEmail(String email);
    public Page<UserDto> findAll(Pageable page);
}
