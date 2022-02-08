package com.springboot.graphql.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.springboot.graphql.graphql.model.Student;
import com.springboot.graphql.graphql.model.Subject;
import com.springboot.graphql.graphql.repository.StudentRepository;
import com.springboot.graphql.graphql.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QueryService implements GraphQLQueryResolver {

    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;

    public Iterable<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public long countStudents(){
        return studentRepository.count();
    }

    public Iterable<Subject> findAllSubjects(){
        return subjectRepository.findAll();
    }

    public long countSubjects(){
        return subjectRepository.count();
    }

    public Subject findSubjectById(long id){
        return subjectRepository.findById(id).get();
    }

}
