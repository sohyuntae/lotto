package com.example.testweb.repository;

import com.example.testweb.domain.usr_info;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<usr_info, Long>, usrInfoRepositoryCustom {

    @NotNull
    List<usr_info> findAll();

    @NotNull
    Optional<usr_info> findById(@NotNull Long uiKey);
}
