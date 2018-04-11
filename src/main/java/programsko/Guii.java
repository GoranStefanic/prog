package programsko;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.TextArea;
import java.awt.Canvas;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Guii extends JFrame {
	private int testvalja=0,treningvalja=0,returnVal;
	private String pathtrening,pathtest;
	private JPanel contentPane;
	private  File file;
	private JFileChooser fc;
	private UcitajPodatke ucitavanje;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guii frame = new Guii();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Guii() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		TextArea textArea = new TextArea();
		textArea.setBounds(16, 34, 234, 73);
		
		JButton btnUcitaj = new JButton("Ucitaj");
		btnUcitaj.setBounds(260, 5, 89, 23);
		contentPane.add(btnUcitaj);
		btnUcitaj.setEnabled(false); // ovo stavi da je zatamnjeno dok se ne ucita i trening i test podaci
		
		btnUcitaj.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 try {
					ucitavanje = new UcitajPodatke(pathtrening,pathtest);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}} );
		
		JButton btnUcitajPodatke = new JButton("Trening");
		btnUcitajPodatke.setBounds(16, 5, 89, 23);
		btnUcitajPodatke.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 fc = new JFileChooser();
				  returnVal = fc.showOpenDialog(fc);
				
				    if (returnVal == JFileChooser.APPROVE_OPTION) {
				        file = fc.getSelectedFile();
				        // What to do with the file, e.g. display it in a TextArea
				       	pathtrening = file.getAbsolutePath().toString();
				       
				        try {
				        	if (pathtrening.endsWith(".arff")) {
				        		
				        		textArea.append("\nTrening je odabran: "+pathtrening);//ispis puta treninga
				        		treningvalja = 1;
				        		}else {
				        			textArea.append("\nFormat treninga nije valjan\n");
				        			treningvalja = 0;
				        		}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    } else {
				        System.out.println("File access cancelled by user.");
				    }
				    if(testvalja==1 && treningvalja==1) {
						btnUcitaj.setEnabled(true);//gledal dal moze enablat buton
					}
				  } 
				} );
		
		
		
		Canvas canvas = new Canvas();
		canvas.setBounds(5, 5, 0, 0);
		
		JPanel panel = new JPanel();
		panel.setBounds(412, 90, 22, 175);
		contentPane.setLayout(null);
		contentPane.add(textArea);
		contentPane.add(btnUcitajPodatke);
		contentPane.add(canvas);
		contentPane.add(panel);
		
		JButton btnUcitajTest = new JButton("Test");
		btnUcitajTest.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  fc = new JFileChooser();
				  returnVal = fc.showOpenDialog(fc);
				
				    if (returnVal == JFileChooser.APPROVE_OPTION) {
				        file = fc.getSelectedFile();
				        // What to do with the file, e.g. display it in a TextArea
				       pathtest = file.getAbsolutePath().toString();
				    
				        try {
				        	if (pathtest.endsWith(".arff")) {
				        		
				        		textArea.append("\nTest je odabran: "+pathtest); // ispis puta testa
				        		testvalja = 1;
				        		
				        		}else {
				        			textArea.append("\nFormat testa nije valjan\n");
				        			testvalja = 0;
				        		}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    } else {
				        System.out.println("File access cancelled by user.");
				    }
				    if(testvalja==1 && treningvalja==1) {
						btnUcitaj.setEnabled(true); // gleda dal moze enableat button za uctiavanjae
					}
				  } 
				} );
		btnUcitajTest.setBounds(161, 5, 89, 23);
		contentPane.add(btnUcitajTest);
		
		
	}
}
