package com.springboot.graphql.graphql.repository;

import com.springboot.graphql.graphql.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
