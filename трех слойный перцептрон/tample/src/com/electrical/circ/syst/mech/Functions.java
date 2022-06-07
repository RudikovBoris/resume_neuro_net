package com.electrical.circ.syst.mech;

public class Functions {

    public double Relu(double volume){
        double relu ;
        if(volume>=0)
            relu=volume;
        else
            relu=0;
        return relu;
    }

    public double reluDerivative(double volume){
        if (volume >= 0)
            return 1;
        else
            return 0;
    }

    public double sigmoidDerivative(double volume){
            return volume * (1 - volume);

    }

    public double Sigmoid(double volume){
        return   1 / (1 + Math.pow(2.718, -volume));

    }
}
