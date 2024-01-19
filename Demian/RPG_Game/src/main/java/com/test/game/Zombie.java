package com.test.game;

public class Zombie extends Monster {
    private String name;
    private String color;
    private double height;
    private int hp;
    private int damage;

    public Zombie(String _name, String _color, double _height, int _hp, int _damage) {
        System.out.println(_name + "좀비 생성");
        name = _name;
        color = _color;
        height = _height;
        hp = _hp;
        damage = _damage;
    }

    @Override
    public void attack() {
        System.out.println("물어뜯기 공격!");
    }

    public void virus() {
        System.out.println("바이러스 퍼뜨리기!");
    }
}
