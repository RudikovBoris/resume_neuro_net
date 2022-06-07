package com.electrical.circ.syst.mech;

import static com.electrical.circ.syst.mech.Main.neuron;

public class Forward {

    int weightCounter = 0;

    public Forward() {
    }

    public void functionAdder (double layer[], double weight[], double layerNewValue[], double bias[]){
        int flag = 0;
        double adder=0;
        weightCounter = 0;
        for (int k = 0; k < layerNewValue.length ; k++) {

            flag = 0;

                for (int i = 0; i < layer.length; i++) {

                    flag = 1;
                    adder += layer[i] * weight[weightCounter];
                    weightCounter ++;
                }

                if (flag == 1) {
                    adder += bias[k];

                        layerNewValue[k] = 1 / (1 + Math.pow(2.718, -adder));

                    adder=0;
                }

        }
    }

    public void softMax(double[] out){
        double sum = 0;
        for (int i = 0; i < out.length; i++) {
            sum += out[i];
        }
        neuron.outFromSoftMax = out.length/sum;
    }

    public void functionNewValue(double[] inputData) {


        for (int i = 0; i < neuron.inputLayer.length; i++) {
            neuron.inputLayer[i] = inputData[i];
        }
        functionAdder(neuron.inputLayer, neuron.weightInput, neuron.hiddenLayer,neuron.biasInput);
        functionAdder(neuron.hiddenLayer, neuron.weightHidden, neuron.hiddenLayer2,neuron.biasHidden);
        functionAdder(neuron.hiddenLayer2, neuron.weightHidden2, neuron.outputLayer,neuron.biasHidden2);

        softMax(neuron.outputLayer);

    }
}
