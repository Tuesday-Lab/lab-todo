package com.circlee.todo;

public class Test {

    public static void main(String[] args) {


        Temp temp = new Temp();



    }

    static class Temp {

        private static Temp INSTANCE = null;

        private Temp(){}

        public static Temp getInstance() {
            return INSTANCE;
        }
    }
}
