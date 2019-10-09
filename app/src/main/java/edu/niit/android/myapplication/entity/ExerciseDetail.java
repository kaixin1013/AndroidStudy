package edu.niit.android.myapplication.entity;

import java.io.Serializable;

public class ExerciseDetail implements Serializable {
    private int exercise_id;//练习id
    private int subject;//习题id
    private String a;
    private String b;
    private String c;
    private String d;
    private int answer;//正确答案

    private int select;
}
