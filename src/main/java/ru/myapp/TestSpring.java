package ru.myapp;

import manager.DAO;
import models.Cinema;
import modelsDAO.CinemaDAO;

import java.util.Scanner;

public class TestSpring {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Ввод");
            System.out.println("2 - Вывод");
            System.out.println("3 - Редактировать по Id");
            System.out.println("4 - Удалить по Id");
            System.out.println("5 - Осуществить поиск по имени");
            System.out.println("0 - Выход");

            System.out.print("Введите номер меню: ");

            String key = scanner.nextLine();

            switch (key) {
                case "1":
                    Cinema newOdj = new Cinema();
                    System.out.print("Введите код кинотеатра: ");
                    String str = scanner.nextLine();
                    newOdj.setCinemaCode(str);
                    System.out.print("Введите название кинотеатра: ");
                    str = scanner.nextLine();
                    newOdj.setName(str);
                    System.out.print("Введите адрес кинотеатра: ");
                    str = scanner.nextLine();
                    newOdj.setAddress(str);
                    System.out.print("Введите телефон кинотеатра: ");
                    str = scanner.nextLine();
                    newOdj.setPhoneNumber(str);
                    CinemaDAO.insert(newOdj);
                    DAO.transaction();
                    break;
                case "2":
                    var tmpList = CinemaDAO.findAll();
                    for (Object item : tmpList)
                        System.out.println(item);
                    break;
                case "3":
                    System.out.print("Введите код кинотеатра: ");
                    str = scanner.nextLine();
                    Cinema edit = CinemaDAO.findById(str);
                    if (edit == null) {
                        System.out.println("Не найдено!");
                        break;
                    }
                    System.out.print("Введите название кинотеатра: ");
                    str = scanner.nextLine();
                    edit.setName(str);
                    System.out.print("Введите адрес кинотеатра: ");
                    str = scanner.nextLine();
                    edit.setAddress(str);
                    System.out.print("Введите телефон кинотеатра: ");
                    str = scanner.nextLine();
                    edit.setPhoneNumber(str);
                    CinemaDAO.insert(edit);
                    DAO.transaction();
                    break;
                case "4":
                    System.out.print("Введите код кинотеатра: ");
                    str = scanner.nextLine();
                    Cinema del = CinemaDAO.findById(str);
                    CinemaDAO.delete(del);
                    DAO.transaction();
                    break;
                case "5":
                    System.out.print("Введите имя кинотеатра: ");
                    str = scanner.nextLine();
                    var byName = CinemaDAO.findByName(str);
                    for (Object item : byName)
                        System.out.println(item);
                    break;
                case "0":
                    return;
            }
        }
    }
}