package com.example.projektspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int ID;
    private String imie;
    private String nazwisko;
    private String stan;
    private int punkty;

}
