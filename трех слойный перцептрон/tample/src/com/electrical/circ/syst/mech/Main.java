package com.electrical.circ.syst.mech;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static boolean flagData = true;
    static Neurons neuron;

    static File fileData = new File("tample/neuronetTest.txt");
    static File fileDataTest = new File("tample/testLearning.txt");
    static File file = new File("weightsAndBias.txt");
    static {
        try {
            neuron = new Neurons(4,3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Net net = new Net();
    public Main() throws FileNotFoundException {
    }


    public static void main(String[] args) throws FileNotFoundException {

        net.makeNewOrWriteFromFile();


        LearningProcess learningProcess = new LearningProcess();
        learningProcess.learning();

    }


}
