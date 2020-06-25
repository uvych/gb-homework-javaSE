package com.geekbrains.georgy.lesson3;

public class MainAppLesson3 {
    public static void main(String[] args) {
        Cat cat = new Cat("Murka", 10 , 5);
        Cat cat1 = new Cat("Vaska", 12 , 4);
        Human human = new Human("Tom", 6 , 7);
        Robot robot = new Robot("R2D2", 30 , 15);

        Move [] movers = new Move[]{cat ,cat1 ,human ,robot};

        Wall wall = new Wall(2);
        Treadmill treadmill = new Treadmill(3);
        Wall wall1 = new Wall(6);
        Treadmill treadmill1 = new Treadmill(15);

        Obstacle [] obstacles = new Obstacle[]{wall, treadmill, wall1 ,treadmill1};

        startGame(movers,obstacles);
    }

    public static void startGame(Move [] movers , Obstacle [] obstacles){
        for (Move mover : movers){
            for (Obstacle obstacle : obstacles){
                if (!obstacle.tryToOvercome(mover)) break;
            }
        }
    }
}
