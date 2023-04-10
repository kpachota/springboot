package com.example.projektspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT ID, imie, nazwisko, stan, punkty FROM student", BeanPropertyRowMapper.newInstance(Student.class));

    }

    public Student getById(int ID) {
        return jdbcTemplate.queryForObject("SELECT ID, imie, nazwisko, stan, punkty FROM student WHERE " + "ID = ?", BeanPropertyRowMapper.newInstance(Student.class), ID);

    }

    public int save(List<Student> students) {
        students.forEach(student -> jdbcTemplate.update("INSERT INTO student(imie, nazwisko, stan, punkty) VALUES(?, ?, ?, ?)",
                        student.getImie(), student.getNazwisko(), student.getStan(), student.getPunkty()));

        return 1;
    }

    public int update(Student student) {
        return jdbcTemplate.update("UPDATE student SET imie=?, nazwisko=?, stan=?, punkty=? WHERE ID=?",
                student.getImie(), student.getNazwisko(), student.getStan(), student.getPunkty(), student.getID());
    }

    public int delete(int ID) {
        return jdbcTemplate.update("DELETE FROM student WHERE ID=?", ID);
    }

    public List<Grupa> getAll2() {
        return jdbcTemplate.query("SELECT ID, nazwa, iloscOsob FROM projektspring.grupa", BeanPropertyRowMapper.newInstance(Grupa.class));
    }

    public int save2(List<Grupa> grupy) {
        grupy.forEach(grupa -> jdbcTemplate.update("INSERT INTO projektspring.grupa(nazwa, iloscOsob) VALUES (?,?)",
                grupa.getNazwa(), grupa.getIloscOsob()));
        return 1;
    }
}
