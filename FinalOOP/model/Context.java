package FinalOOP.model;

import FinalOOP.model.algorithms.Algorithms;
import FinalOOP.model.display.Display;

public class Context {
    private Algorithms algo;
    private Display display;

    public Algorithms getAlgo() {
        return algo;
    }

    public void setAlgo(Algorithms algo) {
        this.algo = algo;
    }

    public Display getDisplay() {
        return display;


    }

    public void setDisplay(Display display) {
        this.display = display;
    }



}
