package qwjntwez.project.models;

import qwjntwez.project.interfaces.Vector;

import java.util.Scanner;

public class Vector3D implements Vector {
    private int x;
    private int y;
    private int z;

    //Main logic
    public void init(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void rewriteVector(Scanner input) {
        System.out.println("Enter 'x' value : ");
        this.x = input.nextInt();

        System.out.println("Enter 'y' value : ");
        this.y = input.nextInt();

        System.out.println("Enter 'z' value : ");
        this.z = input.nextInt();
    }

    public double length() {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public Vector3D scalarMultiplication(final int scalar) {
        int xNew = this.x * scalar; int yNew = this.y * scalar; int zNew = this.z * scalar;

        Vector3D newVector = new Vector3D();
        newVector.init(xNew, yNew, zNew);

        return newVector;
    }

    public static boolean compare(Vector3D vector1, Vector3D vector2) {
        boolean compareX = vector1.getX() == vector2.getX();
        boolean compareY = vector1.getY() == vector2.getY();
        boolean compareZ = vector1.getZ() == vector2.getZ();

        return compareX && compareY && compareZ;
    }

    public static boolean compareLength(Vector3D vector1, Vector3D vector2) {
        return vector1.length() == vector2.length();
    }

    public void display() {
        System.out.println(toString());
    }

    //Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
