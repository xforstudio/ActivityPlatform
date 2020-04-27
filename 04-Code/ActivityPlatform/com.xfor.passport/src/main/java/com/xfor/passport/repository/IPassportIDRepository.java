package com.xfor.passport.repository;

import com.xfor.passport.model.PassportID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassportIDRepository extends JpaRepository<PassportID, String> {
}
