package com.electrical.circ.syst.mech;

import java.io.FileNotFoundException;

import static com.electrical.circ.syst.mech.Main.file;
import static com.electrical.circ.syst.mech.Main.neuron;

public class Net {



    public void makeNewOrWriteFromFile() throws FileNotFoundException {
        ReaderData readerData = new ReaderData();

        if ( file.length()== 0) {
            neuron.averageMeaning();
        }else {
            readerData.readData(neuron.weightInput, neuron.weightHidden, neuron.weightHidden2, neuron.biasInput, neuron.biasHidden, neuron.biasHidden2);
        }
    }

}