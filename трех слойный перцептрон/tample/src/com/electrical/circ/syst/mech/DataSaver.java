package com.electrical.circ.syst.mech;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static com.electrical.circ.syst.mech.Main.file;

public class DataSaver {
    public static boolean allSaveFlag = false;

    PrintWriter printWriter = new PrintWriter(file);

    public DataSaver() throws FileNotFoundException {
    }


    public void writeData(double[] layer) {


        for (int i = 0; i < layer.length; i++) {
            printWriter.print(layer[i] + " ");
        }
        System.out.println(allSaveFlag);
        printWriter.println();

    }

}
