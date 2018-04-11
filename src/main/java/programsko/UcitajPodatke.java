package programsko;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;

import weka.core.Instances;

public class UcitajPodatke {
	private BufferedReader breader;
	private String srctrening,srctest;
	private Instances train;
	private Instances test;
	
	public UcitajPodatke(String sourcetrening, String sourcetest) throws Exception {
		this.srctrening = sourcetrening;
		this.srctest = sourcetest;
		ucitaj();
	}
	private void ucitaj() throws Exception {
		breader = new BufferedReader(new FileReader(this.srctrening));
		train = new Instances(breader);
		train.setClassIndex(train.numAttributes()-1);
		
		breader = new BufferedReader(new FileReader(this.srctest));
		test = new Instances(breader);
		test.setClassIndex(train.numAttributes()-1);
		System.out.println("haha");
		breader.close();
	}
}
