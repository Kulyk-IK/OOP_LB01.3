package qwjntwez.project.models;

import org.junit.jupiter.api.Test;
import qwjntwez.project.interfaces.Vector;

import static org.junit.jupiter.api.Assertions.*;

class Vector3DTest {


    @Test
    void scalarMultiplication() {
        Vector3D vector = new Vector3D();
        vector.init(3,4,5);

        int scalar = 6;

        Vector3D newVector = vector.scalarMultiplication(6);

        Vector3D expectedVector = new Vector3D();
        expectedVector.init(18, 24, 30);

        assertEquals(true, Vector3D.compare(expectedVector, newVector));
    }
}