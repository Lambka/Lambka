package com.techelevator.view;

import java.util.ArrayList;
import java.util.List;

public class MachineNoises {

    private List<String> noisesMade = new ArrayList<>();

    public void addMachineNoises(String sound){
        noisesMade.add(sound);
    }
    public List<String> returnMachineNoises() {
        List<String> returnedNoises = noisesMade;
        noisesMade = new ArrayList<>();
        return returnedNoises;
    }
}
