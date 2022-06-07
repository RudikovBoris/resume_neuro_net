package com.electrical.circ.syst.mech;

import static com.electrical.circ.syst.mech.Main.neuron;

public class Learning {
    double learningRate = 0.001;


    double[] dE_dBi = new double[neuron.hiddenLayer.length];
    double[] dE_dBH1 = new double[neuron.hiddenLayer2.length];
    double[] dE_dBH2 = new double[neuron.outputLayer.length];



    double[] dE_dWI = new  double[neuron.weightInput.length];
    double[] dE_dW1 = new  double[neuron.weightHidden.length];
    double[] dE_dW2 = new  double[neuron.weightHidden2.length];

    double[] dE_dI = new  double[neuron.inputLayer.length];
    double[] dE_dH1 = new  double[neuron.hiddenLayer.length];
    double[] dE_dH2 = new  double[neuron.hiddenLayer2.length];

    double[] dE_dO = new  double[neuron.outputLayer.length];






    double[] errorOutput = new  double[neuron.outputLayer.length];



    double crossEntropy =0;



    public double functionDerivative (double neuronSecondOld){
        return neuronSecondOld * (1 - neuronSecondOld);
    }


    public void newWeightShort(double[] oldWeight, double[] errorWeight, double learningRate){
        for (int i = 0; i < oldWeight.length; i++) {
            oldWeight[i]=oldWeight[i] - errorWeight[i]*learningRate;
        }
    }




    public void newBiasFormula(double[] biasOld, double[] biasError,double learningRate){
        for (int i = 0; i < biasOld.length; i++) {
            biasOld[i] = biasOld[i] - learningRate * biasError[i];
        }
    }



    public void foundError_dE_dW_errorWeight(double[] error_dE_dW,double[] this_error_de_dT, double[] cleanNeuronLastLear_x){
        int counter = 0;
        for (int i = 0; i < this_error_de_dT.length; i++) {
            for (int k = 0; k < cleanNeuronLastLear_x.length; k++) {
                error_dE_dW[counter] = this_error_de_dT[i] * cleanNeuronLastLear_x[k];
                counter++;
            }
        }
    }


    public void foundError_dE_dB(double[] biasError, double[] error_dE_dT){
        for (int i = 0; i < biasError.length; i++) {
            biasError[i] = error_dE_dT[i];
        }
    }


    public void foundError_dE_neuron(double[] neuronFirst, double[] errorNeuron_Second){

        for (int i = 0; i < neuronFirst.length; i++) {
            errorNeuron_Second[i] = errorNeuron_Second[i] * (neuronFirst[i]*(1- neuronFirst[i])) ;
        }
    }

    public void errorAll_dE_Neuron(double[] errorNeuron, double[] weightFirstFromEnd, double[] errorLastLayer){
        int counter = 0;



        for (int j = 0; j < errorNeuron.length; j++) {
            for (int i = 0; i < errorLastLayer.length; i++) {
                errorNeuron[j] += weightFirstFromEnd[counter] * errorLastLayer[i];
                counter++;
            }
        }
    }

    public void errorOutput(){
        for (int i = 0; i < neuron.outputNeuron; i++) {
            dE_dO[i]  =  neuron.outputLayer[i] - neuron.errorOutputLayer[i];
        }

    }


    public void cross_entropy(double[] myOutNeuron, double[] learningDate){

        for (int i = 0; i < myOutNeuron.length; i++) {
            crossEntropy = (learningDate[i]*Math.log(myOutNeuron[i]));
        }
        crossEntropy= crossEntropy*-1;
    }


        public void learningProcess(){

            errorOutput();

            foundError_dE_neuron(neuron.outputLayer, dE_dO);
            foundError_dE_dB(dE_dBH2, dE_dO);
            foundError_dE_dW_errorWeight(dE_dW2, dE_dO, neuron.hiddenLayer2);


            errorAll_dE_Neuron(dE_dH2,neuron.weightHidden2,dE_dO);
            foundError_dE_neuron(neuron.hiddenLayer2, dE_dH2);
            foundError_dE_dB(dE_dBH2, dE_dH2);
            foundError_dE_dW_errorWeight(dE_dW1, dE_dH2,neuron.hiddenLayer);


            errorAll_dE_Neuron(dE_dH1,neuron.weightHidden,dE_dH2);
            foundError_dE_neuron(neuron.hiddenLayer, dE_dH1);
            foundError_dE_dB(dE_dBi, dE_dH1);
            foundError_dE_dW_errorWeight(dE_dWI, dE_dH1,neuron.inputLayer);


            changeWeightAndBias();
        }


        public void changeWeightAndBias(){
            newBias();
            newWeight();
        }

    public void newWeight(){
        newWeightShort(neuron.weightInput, dE_dWI,learningRate);
        newWeightShort(neuron.weightHidden, dE_dW1,learningRate);
        newWeightShort(neuron.weightHidden2, dE_dW2,learningRate);


    }
    public void newBias(){
        newBiasFormula(neuron.biasInput, dE_dBi, learningRate);
        newBiasFormula(neuron.biasHidden, dE_dBH1, learningRate);
        newBiasFormula(neuron.biasHidden2, dE_dBH2, learningRate);

    }

}







