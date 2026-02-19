package qwjntwez.project;

import qwjntwez.project.interfaces.Vector;
import qwjntwez.project.models.Vector3D;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        LinkedList<Vector> vectorList = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        Random random = new Random(12341541);

        while(true) {
            displayMainMenu();
            int mainMenuChoice = input.nextInt();

            switch (mainMenuChoice){
                //Додати вектор
                case 1: {
                    Vector newVector = new Vector3D();

                    System.out.println("Введіть 'x' : ");
                    int x = input.nextInt();
                    System.out.println("Введіть 'y' : ");
                    int y = input.nextInt();
                    System.out.println("Введіть 'z' : ");
                    int z = input.nextInt();

                    newVector.init(x, y, z);

                    vectorList.addLast(newVector);
                    break;
                }
                //Змінити вектор
                case 2: {
                    displayAllVectors(vectorList);
                    System.out.println("Виберіть вектор: ");
                    Vector vector = vectorList.get(input.nextInt() - 1);

                    vector.rewriteVector(input);
                    break;
                }
                //Знайти довжину вектора
                case 3: {
                    displayAllVectors(vectorList);
                    System.out.println("Виберіть вектор: ");
                    Vector vector = vectorList.get(input.nextInt() - 1);

                    double length = vector.length();

                    System.out.printf("Довжина обраного вектора - %f\n", length);
                    break;
                }
                //Мжонення вектора на склаляр
                case 4: {
                    displayAllVectors(vectorList);
                    System.out.println("Виберіть вектор: ");
                    Vector vector = vectorList.get(input.nextInt() - 1);

                    System.out.println("Введіть скаляр: ");
                    int scalar = input.nextInt();

                    Vector result = vector.scalarMultiplication(scalar);

                    System.out.println("Отриманий вектор: ");
                    result.display();
                    break;
                }
                //Порівняти вектори
                case 5: {
                    displayAllVectors(vectorList);
                    System.out.println("Оберіть перший вектор: ");
                    Vector vector1 = vectorList.get(input.nextInt() - 1);

                    System.out.println("Введіть другий вектор: ");
                    Vector vector2 = vectorList.get(input.nextInt() - 1);

                    if (Vector3D.compare((Vector3D) vector1,(Vector3D) vector2))
                        System.out.println("Вектори рівні.");
                    else
                        System.out.println("Вектори не рівні.");
                    break;
                }
                //Порівняти довжини векторів
                case 6: {
                    displayAllVectors(vectorList);
                    System.out.println("Оберіть перший вектор: ");
                    Vector vector1 = vectorList.get(input.nextInt() - 1);

                    System.out.println("Оберіть другий вектор: ");
                    Vector vector2 = vectorList.get(input.nextInt() - 1);

                    double vector1Len = vector1.length();
                    double vector2Len = vector2.length();

                    System.out.printf("Довжина першого вектору - %f, \nДовжина другого вектору - %f\n", vector1Len, vector2Len);

                    if (vector1Len > vector2Len)
                        System.out.println("Довжина першого вектору більша за довжину другого.");
                    else if (vector1Len < vector2Len)
                        System.out.println("Довжина першого вектору менша за довжину другого.");
                    else
                        System.out.println("Довжини векорів однакові.");
                    break;
                }
                //Вивести вектор
                case 7:
                    Vector randomVector = vectorList.get(random.nextInt(vectorList.size()));
                    randomVector.display();
                    break;
                //Вивести всі вектори
                case 8:
                    displayAllVectors(vectorList);
                    break;
                //Вийти
                case 0:
                    return;
            }
        }

    }

    public static void displayAllVectors(LinkedList<Vector> vectors) {
        int i = 1;
        for (Vector vector : vectors) {
            System.out.printf("№ %d | " + vector.toString() + "\n", i);
            i++;
        }
        System.out.println("\n");
    }

    public static void displayMainMenu() {
        System.out.println("""
                ================================
                1. Додати вектор.              |
                2. Змінити вектор.             |
                3. Знайти довжину вектора.     |
                4. Помножити вектор на скаляр  |
                5. Порівняти вектори.          |
                6. Порівняти довжини векторів. |
                7. Вивести вектор.             |
                8. Вивести всі вектори.        |
                0. Вийти                       |
                ================================
                """);
    }

}