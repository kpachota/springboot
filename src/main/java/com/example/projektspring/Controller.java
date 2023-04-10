package com.example.projektspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/students")
public class Controller {

    @Autowired
    StudentRepository repository;

    @GetMapping("/")
    public List<Student> getAll() {
        return repository.getAll();
    }

    @GetMapping("/test")
    public int test() {
        return 1;
    }

    @GetMapping("/{ID}")
    public Student getByID(@PathVariable("ID") int ID) {
        return repository.getById(ID);
    }

    @PostMapping("/")
    public int add(@RequestBody List<Student> students) {
        return repository.save(students);
    }

    @PutMapping("/{ID}")
    public int update(@PathVariable("ID") int ID, @RequestBody Student updatedStudent) {
        Student student = repository.getById(ID);

        if (student != null) {
            student.setImie(updatedStudent.getImie());
            student.setNazwisko(updatedStudent.getNazwisko());
            student.setStan(updatedStudent.getStan());
            student.setPunkty(updatedStudent.getPunkty());

            repository.update(student);
            return 1;
        } else
        {
            return -1;
        }
    }

    @PatchMapping("/{ID}")
    public int partiallyUpdate(@PathVariable("ID") int ID, @RequestBody Student updatedStudent) {
        Student student = repository.getById(ID);

        if (student != null) {
            if (updatedStudent.getImie() != null) student.setImie(updatedStudent.getImie());
            if (updatedStudent.getNazwisko() != null) student.setNazwisko(updatedStudent.getNazwisko());
            if (updatedStudent.getStan() != null) student.setStan(updatedStudent.getStan());
            if (updatedStudent.getPunkty() > 0) student.setPunkty(updatedStudent.getPunkty());

            repository.update(student);
            return 1;
        } else
        {
            return -1;
        }
    }

    @DeleteMapping("/{ID}")
    public int delete(@PathVariable("ID") int ID) {
        return repository.delete(ID);
    }

    @GetMapping("/grupa")
    public List<Grupa> getAll2() {
        return repository.getAll2();
    }

    @PostMapping("/grupa")
    public int add2(@RequestBody List<Grupa> grupy) {
        return repository.save2(grupy);
    }
}