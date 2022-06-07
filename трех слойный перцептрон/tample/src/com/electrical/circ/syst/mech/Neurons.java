package com.electrical.circ.syst.mech;

import java.io.FileNotFoundException;

import static com.electrical.circ.syst.mech.Main.flagData;

public class Neurons {


    int inputNeuron, hiddenNeuron, hiddenNeuron2, outputNeuron;


    double outFromSoftMax = 0;
    double[] inputLayer ;

    double[] hiddenLayer;
    double[] hiddenLayer2;
    double[] outputLayer;

    double[] errorOutputLayer;

    double[] weightInput ;
    double[] weightHidden;
    double[] weightHidden2;

    double[] biasInput;
    double[] biasHidden;
    double[] biasHidden2;





    public Neurons(int input,  int output) throws FileNotFoundException {
        this.inputNeuron = input;
        this.outputNeuron = output;


        hiddenNeuron = ((input+output)*2)/3;
        hiddenNeuron2 = input*2;
        if (hiddenNeuron > hiddenNeuron2){
            hiddenNeuron2 = hiddenNeuron;
        }else {
            hiddenNeuron2 -=3;
            hiddenNeuron = hiddenNeuron2;
        }
         hiddenNeuron2 = 8;

        inputLayer = new double[input];
        hiddenLayer = new double[hiddenNeuron];
        hiddenLayer2 = new double[hiddenNeuron2];
        outputLayer = new double[output];
        errorOutputLayer = new double[output];

weightInput = new double[inputLayer.length*hiddenLayer.length];
weightHidden = new double[hiddenLayer.length*hiddenLayer2.length];
weightHidden2 = new double[hiddenLayer2.length*outputLayer.length];


         biasInput = new double[hiddenLayer.length];
         biasHidden = new double[hiddenLayer2.length];
         biasHidden2 = new double[outputLayer.length];

    }






    public void averageMeaning () throws FileNotFoundException {





        for (int i = 0; i < weightInput.length; i++) {
            weightInput[i] =  Math.random()/2 ;
        }

        for (int i = 0; i < weightHidden.length; i++) {
            weightHidden[i]= Math.random()/2;
        }
        for (int i = 0; i < weightHidden2.length; i++) {
            weightHidden2[i]= Math.random()/2;
        }
        for (int i = 0; i < biasInput.length; i++) {
            biasInput[i]= Math.random()/2;
        }
        for (int i = 0; i < biasHidden.length; i++) {
            biasHidden[i]= Math.random()/2;
        }
        for (int i = 0; i < biasHidden2.length; i++) {
            biasHidden2[i]= Math.random()/2;
        }


        DataSaver dataSaver = new DataSaver();
        dataSaver.writeData(weightInput);
        dataSaver.writeData(weightHidden);
        dataSaver.writeData(weightHidden2);
        dataSaver.writeData(biasInput);
        dataSaver.writeData(biasHidden);
        dataSaver.writeData(biasHidden2);
        dataSaver.printWriter.close();

        flagData = true;
    }



}
