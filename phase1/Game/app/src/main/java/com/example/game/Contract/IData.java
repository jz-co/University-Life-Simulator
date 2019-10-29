package com.example.game.Contract;

import com.example.game.Model.Student;

import java.util.List;

public interface IData {
    interface IDataSaver{
        boolean saveAll(List<Student> students);
    }
    interface IDataLoader{
        List<Student> loadAll();
    }
}
