package com.springboot.graphql.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.springboot.graphql.graphql.model.Student;
import com.springboot.graphql.graphql.model.Subject;
import com.springboot.graphql.graphql.repository.StudentRepository;
import com.springboot.graphql.graphql.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubjectResolverService implements GraphQLResolver {

    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;

    // used for student id which is foreign key in subject table
//    If the client want to get a Subject without student field, the GraphQL
//    Server will never do the work to retrieve it. So the getStudent() method below will never be executed.

    public Student getStudent(Subject subject){
        return studentRepository.findById(subject.getStudent().getId()).orElseThrow(null);
    }
}
