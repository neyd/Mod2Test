package com.neyd.cookbook;

import com.neyd.cookbook.util.RecipeGenerator;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * Created by Женя on 03.12.2015.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        List<String> nameOfRecipe = new ArrayList<String>();
        nameOfRecipe = Arrays.asList(RecipeGenerator.nameOfRecipe);

        List<String> description = new ArrayList<String>();
        description = Arrays.asList(RecipeGenerator.description);

        List<String> product = new ArrayList<String>();
        product = Arrays.asList(RecipeGenerator.product);

        System.out.println("Вітаємо у кулінарній книзі");

        while (true) {
            System.out.println("Меню:" + "\n" +
                    "------------\n" +
                    "1.Переглянути всі рецепти.\n" +
                    "2.Пошук по продукту.\n" +
                    "3.Вийти");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    for (int i = 0; i < nameOfRecipe.size(); i++) {
                        System.out.println((i + 1) + "." + nameOfRecipe.get(i));
                    }
                    int resp = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < nameOfRecipe.size(); i++) {
                        if (resp == i + 1) {
                            System.out.println("Назва: " + nameOfRecipe.get(i) + "\n" +
                                    "Опис:" + "\n" +
                                    description.get(i) + "\n" +
                                    "----------------");
                            scanner.nextLine();
                        }
                    }
                } else if (choice == 2) {
                    System.out.println("Що будете шукати?");
                    for (int i = 0; i < product.size(); i++) {
                        System.out.println((i + 1) + "." + product.get(i));
                    }
//                    System.out.println("Введіть перший продукт");
                    int search = Integer.parseInt(scanner.nextLine());
                    String prod = product.get(search - 1);

//                    System.out.println("Введіть другий продукт");
//                    int search2 = Integer.parseInt(scanner.nextLine());
//                    String prod2 = product.get(search2 - 1);

                    for (int i = 0; i < nameOfRecipe.size(); i++) {
                        String s = description.get(i);                          //беремо опис рецепта
                        String regex = "[^.]*(" + prod + ")[^.]*(\\.|$)";       //шукаємо наш продукт у рецепті
                        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
                        Matcher m = p.matcher(s);
                        while (m.find()) {
//                            s = description.get(i);
//                            regex = "[^.]*(" + prod2 + ")[^.]*(\\.|$)";       //шукаємо наш продукт2 у рецепті
//                            p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
//                            m = p.matcher(s);
//                            while (m.find()) {
                                System.out.println("------------\n" +
                                                (i + 1) + "." + nameOfRecipe.get(i) + "\n" +
                                                "------------"
                                );
//                            }
                        }
                    }

                    int resp = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < nameOfRecipe.size(); i++) {
                        if (resp == i + 1) {
                            System.out.println("Назва: " + nameOfRecipe.get(i) + "\n" +
                                    "Опис:" + "\n" +
                                    description.get(i) + "\n" +
                                    "----------------");
                            scanner.nextLine();
                        }
                    }

                } else if (choice == 3) {
                    System.out.println("Дякуємо що скористалися нашою книгою");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ви ввели неправильне число");
                System.out.println();
            }
        }
    }
}
