package com.xfor.passport.repository.jpa;

import com.xfor.passport.model.PassportAuthCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface IPassportAuthCategoryJpaDAO extends JpaRepository<PassportAuthCategory, String> {
}
