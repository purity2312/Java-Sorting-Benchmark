/**
 * Name: Yechan Lim
 * UMGC CMSC 451
 * Project 1: The project involves benchmarking the behavior of Java implemenations of insertion sort and heap sort.
 * Date: November 12, 2024
 * ReportGenerator class allows the user to choose an input file, computes values, and display the data in a table.
 * Java 21
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class ReportGenerator {

	public static void main(String[] args) throws Exception {
		int numPair = 40;
		
		// add columns for a table
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Size");
		tableModel.addColumn("Avg Count");
		tableModel.addColumn("Coef Count");
		tableModel.addColumn("Avg Time");
		tableModel.addColumn("Coef Time");
		
		// Open JFileChooser for the user to select a file
		File selectedFile = null;
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = jfc.getSelectedFile();
		}
		
		
        BufferedReader br = new BufferedReader(new FileReader(selectedFile));
        String st;
        int size;
        double[] counts = new double[numPair];
        double[] times = new double[numPair];
        double avgCount;
        double coefCount;
        double avgTime;
        double coefTime;
        
        // read each line of the input text
        while ((st = br.readLine()) != null) {
        	
        	String data[] = st.split(" ");
        	size = Integer.parseInt(data[0]);
        	int ci = 0;
        	int ti = 0;
        	
        	// store data for counts and times
        	for (int i = 0; i < data.length; i++) {
        		if (i % 2 == 0 && i > 0) {
        			times[ci++] = Double.parseDouble(data[i]);
        		}
        		if (i % 2 != 0 && i > 0) {
        			counts[ti++] = Double.parseDouble(data[i]);
        		}
        		
        	}
        	
        	// take average of counts
        	double sum = 0;
        	for (double count : counts) {
        		sum += count;
        		
        	}
        	avgCount = sum / counts.length;
        	
        	// take average of times
        	sum = 0;
        	for (double time : times) {
        		sum += time;
        	}
        	avgTime = sum / times.length;
        	
        	coefCount = Math.round((calculateCoefficientOfVariance(counts, avgCount) * 100.0)) / 100.0;
        	coefTime = Math.round((calculateCoefficientOfVariance(times, avgTime) * 100.0)) / 100.0;
        	
        	// add a row to the table
        	tableModel.addRow(new Object[]{data[0], avgCount, Double.toString(coefCount) + "%", avgTime, Double.toString(coefTime) + "%"});
        	
        }
		
        // create a table
		JTable table = new JTable(tableModel);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		JScrollPane sp = new JScrollPane(table);
		
		// create a frame
		JFrame frame = new JFrame("Benchmark Report");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 250);
		frame.add(sp);
		frame.setVisible(true);
	}
	
	// calculate coefficient of variance using the given list and its mean
	public static double calculateCoefficientOfVariance(double list[], double mean){
		double sum = 0;
		for (int j = 0; j < list.length; j++) {
			sum += Math.pow((list[j] - mean), 2);
			
		}
		
		double deviation = Math.sqrt(sum/(list.length-1));
		double coef = (deviation / mean) * 100;
		return coef;
		
	}
	
	
	

}
