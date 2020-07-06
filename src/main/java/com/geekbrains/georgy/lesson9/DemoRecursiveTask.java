package com.geekbrains.georgy.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class DemoRecursiveTask extends RecursiveTask<Integer> {
    private final int[] data;

    public DemoRecursiveTask(int[] data) {
        this.data = data;
    }

    @Override
    protected Integer compute() {
        if (this.data.length > 50000000){
            List<DemoRecursiveTask> subTasks = createSubTasks();
            for (DemoRecursiveTask subTask : subTasks) {
                subTask.fork();
            }
            int result = 0;
            for (DemoRecursiveTask subTask : subTasks) {
                if (result < subTask.join()) {
                    result = subTask.join();
                }
            }
            return result;
        } else {
            return IntStream.of(data).max().orElse(0);
        }
    }

    private List<DemoRecursiveTask> createSubTasks() {
        return new ArrayList<>(Arrays.asList(
                        new DemoRecursiveTask(Arrays.copyOfRange(data, 0, data.length/2)),
                        new DemoRecursiveTask(Arrays.copyOfRange(data, data.length/2, data.length))
        ));
    }
}

