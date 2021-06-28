package com.example.sqlex.models.tasks;
import lombok.Data;

@Data
public class Task8 {
    private String maker;

    public Task8() {
    }

    public Task8(String maker) {
        this.maker = maker;
    }
}
