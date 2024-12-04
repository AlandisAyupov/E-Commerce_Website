package com.ayupov.bank.Login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ayupov.bank.Login.LoginForm;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// Find some method to block repository from export.
@RepositoryRestResource(exported = false)
public interface LoginRepository extends CrudRepository<LoginForm, String> {

}