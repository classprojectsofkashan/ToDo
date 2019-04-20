package com.classroom;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add(new ToDoList.ToDoListArray.ToDo("test1"));
        toDoList.add(new ToDoList.ToDoListArray.ToDo("TEST2"));
        toDoList.add(new ToDoList.ToDoListArray.ToDo("TEST3"));
        toDoList.add(new ToDoList.ToDoListArray.ToDo("TEST4"));
        ToDoList.ToDoListArray.ToDo l;
        while(toDoList.hasNext())
            System.out.println(toDoList.next());
    }
}

class ToDoList {
    private ToDoListArray toDoListArray = new ToDoListArray();
    private int pivot = -1;

    ToDoListArray.ToDo get(int index) {
        return toDoListArray.get(index);
    }

    ToDoListArray.ToDo get(){
        if (hasNext())
            return toDoListArray.get(pivot);
        return null;
    }

    void add(ToDoListArray.ToDo toDo) {
        toDoListArray.add(toDo);
    }

    ToDoListArray.ToDo next() {
        if (hasNext()) {
            pivot++;
            return toDoListArray.get(pivot);
        }
        return null;
    }

    boolean hasNext() {
        return pivot + 1 < toDoListArray.last_index();
    }

    static class ToDoListArray {

        private ToDo[] toDos;
        private int current_add = 0;

        private int current_limit = 1;

        public ToDoListArray() {
            this.toDos = new ToDo[current_limit];
        }

        int size() {
            return toDos.length;
        }

        ToDo get(int index) {
            return toDos[index];
        }

        int last_index() {
            return current_add;
        }

        void add(ToDo toDo) {
            if (current_add >= current_limit) {
                current_limit *= 2;
                toDos = Arrays.copyOf(toDos, current_limit);
            }
            toDos[current_add] = toDo;
            current_add++;
        }

        static class ToDo {
            String name;
            String description;

            public ToDo() {
            }

            public ToDo(String name) {
                this(name, "");
            }

            public ToDo(String name, String description) {
                this.name = name;
                this.description = description;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            @Override
            public String toString() {
                return "ToDo{" +
                        "name='" + name + '\'' +
                        ", description='" + description + '\'' +
                        '}';
            }
        }
    }
}