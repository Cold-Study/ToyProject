package com.test.game;

public class Archer extends Character {
    String name = "";
    int age = 0;
    String gender = "";
    int money = 0;
    int hp = 0;

    public Archer(String _name, int _age, String _gender, int _money, int _hp) {
        System.out.println(name + "궁수 생성");
        name = _name;
        age = _age;
        gender = _gender;
        money = _money;
        hp = _hp;
    }

    @Override
    public void attack() {
        System.out.println("활쏘기!");
    }

    public void windArrow() {
        System.out.println("바람의 화살!!");
    }

    public void windJump(String destination) {
        System.out.println(destination + "까지 도약!");
    }
}
