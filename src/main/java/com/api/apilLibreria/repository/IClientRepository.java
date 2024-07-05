package com.api.apilLibreria.repository;

import com.api.apilLibreria.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientModel, Long> {
}
