package qwjntwez.project;

import qwjntwez.project.models.Vector3D;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Vector3D> vectorList = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        Random random = new Random(12341541);

        while(true) {
            displayMainMenu();
            int mainMenuChoice = input.nextInt();

            switch (mainMenuChoice){
                //Додати вектор
                case 1: {
                    Vector3D newVector = new Vector3D();

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
                    Vector3D vector = vectorList.get(input.nextInt() - 1);

                    vector.rewriteVector(input);
                    break;
                }
                //Знайти довжину вектора
                case 3: {
                    displayAllVectors(vectorList);
                    System.out.println("Виберіть вектор: ");
                    Vector3D vector = vectorList.get(input.nextInt() - 1);

                    double length = vector.length();

                    System.out.printf("Довжина обраного вектора - %f\n", length);
                    break;
                }
                //Мжонення вектора на склаляр
                case 4: {
                    displayAllVectors(vectorList);
                    System.out.println("Виберіть вектор: ");
                    Vector3D vector = vectorList.get(input.nextInt() - 1);

                    System.out.println("Введіть скаляр: ");
                    int scalar = input.nextInt();

                    Vector3D result = vector.scalarMultiplication(scalar);

                    System.out.println("Отриманий вектор: ");
                    result.display();
                    break;
                }
                //Порівняти вектори
                case 5: {
                    displayAllVectors(vectorList);
                    System.out.println("Оберіть перший вектор: ");
                    Vector3D vector1 = vectorList.get(input.nextInt() - 1);

                    System.out.println("Введіть другий вектор: ");
                    Vector3D vector2 = vectorList.get(input.nextInt() - 1);

                    if (Vector3D.compare(vector1, vector2))
                        System.out.println("Вектори рівні.");
                    else
                        System.out.println("Вектори не рівні.");
                    break;
                }
                //Порівняти довжини векторів
                case 6: {
                    displayAllVectors(vectorList);
                    System.out.println("Оберіть перший вектор: ");
                    Vector3D vector1 = vectorList.get(input.nextInt() - 1);

                    System.out.println("Оберіть другий вектор: ");
                    Vector3D vector2 = vectorList.get(input.nextInt() - 1);

                    double vector1Len = vector1.length();
                    double vector2Len = vector2.length();

                    System.out.printf("Довжина першого вектору - %f, \n Довжина другого вектору - %f\n", vector1Len, vector2Len);

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
                    Vector3D randomVector = vectorList.get(random.nextInt(vectorList.size()));
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

    public static void displayAllVectors(LinkedList<Vector3D> vectors) {
        int i = 1;
        for (Vector3D vector : vectors) {
            System.out.printf("№ %d | x = %d, y = %d, z = %d \n", i, vector.getX(), vector.getY(), vector.getZ());
            i++;
        }
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