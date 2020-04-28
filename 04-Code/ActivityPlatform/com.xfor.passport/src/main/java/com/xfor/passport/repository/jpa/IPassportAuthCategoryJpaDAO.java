package com.xfor.passport.repository.jpa;

import com.xfor.passport.model.PassportAuthCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface IPassportAuthCategoryJpaDAO extends JpaRepository<PassportAuthCategory, String> {
}
