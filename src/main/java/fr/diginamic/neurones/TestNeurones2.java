package fr.diginamic.neurones;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.TransferFunctionType;

public class TestNeurones2 {

    public static void main(String[] args) {
        NeuralNetwork<BackPropagation> neuralNetwork =
        			new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 1, 20, 1);
        DataSet trainingSet = new DataSet(1, 1);
        for (int i = 1; i <= 100; i++) {
            trainingSet.addRow(new double[]{i}, new double[]{i * i});
        }
        BackPropagation backPropagation = new BackPropagation();
        backPropagation.setMaxIterations(10000);
        neuralNetwork.learn(trainingSet, backPropagation);
        for (int i = 1; i <= 100; i++) {
            neuralNetwork.setInput(i);
            neuralNetwork.calculate();
            double output = neuralNetwork.getOutput()[0];
            System.out.println(i + " - " + output);
        }
    }
}