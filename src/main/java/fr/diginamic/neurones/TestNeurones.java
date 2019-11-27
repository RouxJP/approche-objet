package fr.diginamic.neurones;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;

public class TestNeurones {

	public static void main(String[] args) {
		System.out.println( "Simulation porte logique OU");

		// Learning
		MultiLayerPerceptron neuralNetwork = new MultiLayerPerceptron(2, 5, 1);
		DataSet dataSet 	= new DataSet(2, 1);
		DataSetRow rOne 	= new DataSetRow(new double[] {1d, 0d}, new double[]{1d});
		DataSetRow rTwo 	= new DataSetRow(new double[] {0d, 1d}, new double[]{1d});
		DataSetRow rThree 	= new DataSetRow(new double[] {1d, 1d}, new double[]{1d});
		DataSetRow rFour 	= new DataSetRow(new double[] {0d, 0d}, new double[]{0d});
		dataSet.addRow(rOne);
		dataSet.addRow(rTwo);
		dataSet.addRow(rThree);
		dataSet.addRow(rFour);
		
		for( int i = 1 ; i < 101 ; i++) {
			neuralNetwork.learn(dataSet) ;
		}
		
		// Test 1 + 0 donne 1
		neuralNetwork.setInput( 1d, 0d);
		neuralNetwork.calculate();
		for (double output: neuralNetwork.getOutput()){
			System.out.println(output);
		}
		// Test 0 + 1 donne 1
		neuralNetwork.setInput( 0d, 1d);
		neuralNetwork.calculate();
		for (double output: neuralNetwork.getOutput()){
			System.out.println(output);
		}
		// Test 0 + 0 donne 0
		neuralNetwork.setInput( 0d, 0d);
		neuralNetwork.calculate();
		for (double output: neuralNetwork.getOutput()){
			System.out.println(output);
		}
	}

}
