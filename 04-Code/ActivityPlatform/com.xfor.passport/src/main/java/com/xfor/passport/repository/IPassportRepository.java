package com.xfor.passport.repository;

import com.xfor.passport.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassportRepository extends JpaRepository<Passport, String> {
}
