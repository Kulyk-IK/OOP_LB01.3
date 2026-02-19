package qwjntwez.project.interfaces;

import qwjntwez.project.models.Vector3D;

import java.util.Scanner;

public interface Vector {
    public void init(int x, int y, int z);
    public void rewriteVector(Scanner input);
    public double length();
    public void display();
    public Vector scalarMultiplication(final int scalar);
}
