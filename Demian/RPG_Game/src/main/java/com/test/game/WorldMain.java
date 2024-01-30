package com.test.game;

import java.util.Scanner;

public class WorldMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String worldName = "스코월드";

        System.out.println("이름을 입력해주세요");
        String myName = scanner.nextLine();

        System.out.println("나이를 입력해주세요");
        int myAge = Integer.parseInt(scanner.nextLine());

        System.out.println("직업을 입력해주세요");
        String myJob = scanner.nextLine();

        System.out.println("성별을 입력해주세요");
        String myGender = scanner.nextLine();

        System.out.println("초기자본을 입력해주세요");
        int myMoney = Integer.parseInt(scanner.nextLine());

        System.out.println("초기체력 입력해주세요");
        int myHp = Integer.parseInt(scanner.nextLine());
        int myMp = 0;

        boolean isNamePass = true;
        boolean isAgePass = true;
        boolean isJobPass = true;

        String[] names = {"홍길동", "zl존법사", "타락파워전사"};
        for (String name : names) {
            if (myName.equals(name)) {
                System.out.println("중복된 이름이 존재합니다.");
                isNamePass = false;
                break;
            }
        }

        if (myAge < 12) {
            System.out.println("12세 미만은 이용할 수 없습니다.");
            isAgePass = false;
        }
        if ("전사".equals(myJob)) {
            System.out.println("일시적으로 전사를 이용할 수 없습니다.");
            isJobPass = false;
        }

        // 모든 조건을 통과한 경우에만 환영
        if (isNamePass && isAgePass && isJobPass) {
            displayInfo(worldName, myName, myAge, myJob);

            if ("마법사".equals(myJob)) {
                System.out.println("마법사는 초기 mp도 입력해주세요");
                myMp = Integer.parseInt(scanner.nextLine());
                Wizard myCharacter = new Wizard(myName, myAge, myGender, myMoney, myHp, myMp);

                System.out.println("던전을 선택해주세요");
                System.out.println("[1] 슬라임동굴, [2] 좀비마을");
                int selectWorld = Integer.parseInt(scanner.nextLine());
                selectWorldByWizard(selectWorld, myCharacter);

            } else if ("궁수".equals(myJob)) {
                System.out.println("궁수를 선택했군요");
                Archer myCharacter = new Archer(myName, myAge, myGender, myMoney, myHp);

                System.out.println("던전을 선택해주세요");
                System.out.println("[1] 슬라임동굴, [2] 좀비마을");
                int selectWorld = Integer.parseInt(scanner.nextLine());
                selectWorldByArcher(selectWorld, myCharacter);
            }
        }
    }

    static void displayInfo(String worldName, String myName, int myAge, String myJob) {
        System.out.println("==================" + worldName + "에 오신것을 환영합니다==================");
        System.out.println("당신의 정보는 다음과 같습니다.");
        System.out.println("이름: " + myName + "입니다.");
        System.out.println("나이: " + myAge + "입니다.");
        System.out.println("직업: " + myJob + "입니다.");
        System.out.println("모험을 떠나 볼까요?");
    }

    static void selectWorldByArcher(int selectWorld, Archer myCharacter) {
        if (selectWorld == 1) { // 슬라임 던전
            Slime slime1 = new Slime("초록슬라임", "초록", 30.2, 200, 10);
            slime1.attack();
            myCharacter.windArrow();

            slime1.poison();
            myCharacter.attack();

        } else if (selectWorld == 2) { // 좀비 던전
            Zombie zombie1 = new Zombie("파랑좀비", "파랑", 142.2, 500, 25);
            zombie1.virus();
            myCharacter.windJump("건물1");
        }
    }

    static void selectWorldByWizard(int selectWorld, Wizard myCharacter) {
        if (selectWorld == 1) { // 슬라임 던전
            Slime slime1 = new Slime("파랑슬라임", "파랑", 30.2, 200, 10);
            slime1.attack();
            myCharacter.attack();

            slime1.poison();

        } else if (selectWorld == 2) { // 좀비 던전
            Zombie zombie1 = new Zombie("파랑좀비", "파랑", 142.2, 500, 25);
            zombie1.virus();
            myCharacter.fireBall();
        }
    }
}
