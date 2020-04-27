package com.xfor.passport.repository;

import com.xfor.passport.model.PassportAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassportAuthRepository extends JpaRepository<PassportAuth, String> {
}
