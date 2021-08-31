package com.example.test.dao;

import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface AdminPanel extends JpaRepositoryImplementation<Clinic,Long> {


}
