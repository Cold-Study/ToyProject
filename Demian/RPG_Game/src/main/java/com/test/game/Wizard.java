package com.test.game;

public class Wizard extends Character {
    String name = "";
    int age = 0;
    String gender = "";
    int money = 0;
    int hp = 0;
    int mp = 0;

    public Wizard(String _name, int _age, String _gender, int _money, int _hp, int _mp) {
        System.out.println(name + "마법사 생성");
        name = _name;
        age = _age;
        gender = _gender;
        money = _money;
        hp = _hp;
        mp = _mp;
    }

    @Override
    public void attack() {
        System.out.println("에너지 볼!");
    }

    public void fireBall() {
        System.out.println("파이어 볼!");
    }

    public void teleport(int src, int dst) {
        System.out.println(src + "에서 " + dst + "로 텔레포트!");
    }
}
