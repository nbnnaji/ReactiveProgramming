package com.nkechinnaji.rxjavatutorial.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nkechi Nnaji on 4/22/21.
 * Description:
 */
public class DataSource {
    public static List<Task> createTasksList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Take out the trash", true, 3));
        tasks.add(new Task("Walk the dog", false, 2));
        tasks.add(new Task("Make my bed", true, 1));
        tasks.add(new Task("Unload the dishwasher", false, 0));
        tasks.add(new Task("Make dinner", true, 5));
        return tasks;
    }
}
