package com.example.projektspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grupa {
    private int ID;
    private String nazwa;
    private int iloscOsob;

}
