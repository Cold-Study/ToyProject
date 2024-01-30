package com.test.game;

public class Slime extends Monster implements GreenSlimeSkill {
    String name = "";
    String color = "";
    double height = 0.0;
    int hp = 0;
    int damage = 0;

    public Slime(String _name, String _color, double _height, int _hp, int _damage) {
        name = _name;
        color = _color;
        height = _height;
        hp = _hp;
        damage = _damage;
    }

    @Override
    public void attack() {
        System.out.println("점성 공격!");
    }

    public void jumpAttack() {
        System.out.println("점프해서 내려찍기!");
    }

    @Override
    public void poison() {
        if ("초록".equals(color)) {
            System.out.println("초록 독 퍼뜨리기!");
        } else {
            System.out.println("일반 슬라임은 사용할 수 없습니다.");
        }
    }
}
