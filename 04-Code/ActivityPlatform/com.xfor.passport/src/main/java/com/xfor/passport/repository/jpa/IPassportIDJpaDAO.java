package com.xfor.passport.repository.jpa;

import com.xfor.passport.model.PassportID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface IPassportIDJpaDAO extends JpaRepository<PassportID, String> {
}
