package com.electrical.circ.syst.mech;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.electrical.circ.syst.mech.Main.*;

public class LearningProcess {


    Forward forward = new Forward();



    Learning learning =new Learning();

    double[] inputData = new double[neuron.inputNeuron];
    double[] learningData = new double[neuron.outputNeuron] ;

    public LearningProcess(double[] inputData, double[] learningData, int inputCount, int outputCount) {

        this.inputData = new double[inputCount];
        this.learningData = new double[outputCount];
        this.inputData = inputData;
        this.learningData = learningData;
    }



    public LearningProcess() {

    }


    public void learning() throws FileNotFoundException {
        int counterPrint = 0;
        int counter = 0;

        Scanner scanner1 = new Scanner(fileDataTest);

        for (int t = 0; t < 100000; t++) {
            Scanner scanner = new Scanner(fileData);
            String line = new String();
            for (int o = 0; o < 146; o++) {


            line = scanner.nextLine();

            String[] lineEray1 = line.split("\t");
            double[] lineDouble1 = new double[lineEray1.length];

            for (int i = 0; i < neuron.inputLayer.length; i++) {
                lineDouble1[counter] = Double.parseDouble(lineEray1[counter]);
                neuron.inputLayer[i] = lineDouble1[counter];
                counter++;
            }
            for (int i = 0; i < neuron.errorOutputLayer.length; i++) {
                lineDouble1[counter] = Double.parseDouble(lineEray1[counter]);
                neuron.errorOutputLayer[i] = lineDouble1[counter];
                counter++;
            }


            forward.functionNewValue(neuron.inputLayer);

            learning.learningProcess();

            counter=0;
        }

        scanner.close();
        }
        if (counterPrint == 1) {
            System.out.println("learning");
            System.out.println(neuron.outputLayer[0]);
            System.out.println(neuron.outFromSoftMax);
            counterPrint = 0;
        }

        counterPrint++;


        for (int y = 0; y < 3; y++) {
            String line = new String();

        line = scanner1.nextLine();

        String[] lineEray1 = line.split("\t");
        double[] lineDouble1 = new double[lineEray1.length];

        for (int t = 0; t < neuron.inputLayer.length; t++) {
            lineDouble1[counter] = Double.parseDouble(lineEray1[counter]);
            neuron.inputLayer[t] = lineDouble1[counter];
            counter++;
        }




        forward.functionNewValue(neuron.inputLayer);
            System.out.println(neuron.outputLayer[0]);
            System.out.println(neuron.outputLayer[1]);
            System.out.println(neuron.outputLayer[2]);
            System.out.println();
            System.out.println();

            counter=0;

    }
        scanner1.close();

    }
}






