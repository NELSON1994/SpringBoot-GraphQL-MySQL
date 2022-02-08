package com.springboot.graphql.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.springboot.graphql.graphql.model.Student;
import com.springboot.graphql.graphql.model.Subject;
import com.springboot.graphql.graphql.repository.StudentRepository;
import com.springboot.graphql.graphql.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MutationService implements GraphQLMutationResolver {
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;

    public Student createStudent(String name, Integer age, String department) {
        Student student = new Student();
        student.setAge(age);
        student.setDepartment(department);
        student.setName(name);
        return studentRepository.save(student);
    }

    public Subject createSubject(String title, String description, Long studentId) {
        Subject subject = new Subject();
        subject.setDescription(description);
        subject.setTitle(title);
        Student student = studentRepository.getById(studentId);
        subject.setStudent(student);
        return subjectRepository.save(subject);
    }

    public boolean deleteSubject(Long id) {
        subjectRepository.deleteById(id);
        return true;
    }

    public Subject updateSubject(Long id,String title,String description){
        Optional<Subject> subject= Optional.of(subjectRepository.getById(id));
        if(subject.isPresent()){
            Subject subject1=subject.get();
            subject1.setDescription(description);
            subject1.setTitle(title);
            subjectRepository.save(subject1);
            return subject1;
        }
        else{
            return new Subject();
        }
    }


}
