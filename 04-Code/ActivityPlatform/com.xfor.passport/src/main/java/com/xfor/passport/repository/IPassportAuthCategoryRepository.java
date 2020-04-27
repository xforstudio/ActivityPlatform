package com.xfor.passport.repository;

import com.xfor.passport.model.PassportAuthCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassportAuthCategoryRepository extends JpaRepository<PassportAuthCategory, String> {
}
