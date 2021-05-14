import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void  printArray (String [][] matrix, int sizeListRow) {
		
	
		for (int m = 0; m < sizeListRow; m++) {
		
			for (int n = 0; n < matrix[m].length; n++) {
			//for (int n = 0; n < 3; n++) {
				
				
				System.out.print (matrix [m][n] + " ");
			
			}
			System.out.println();
		
		
	   }
	
	}

	public static void  printArray (String [] vector) {
		for (int n = 0; n < vector.length; n++) {
			System.out.print(vector[n] + " ");
		}
		System.out.println();
	}
	
	
	public static double calculeDistancia (String matrix[][], int sizeListRow) {
		
		double soma = 0;
		
		double distancia = 0;
	
		int maisProximo = 0;
		
		double menor = Double.MAX_VALUE;
		
		for (int m = 1; m < sizeListRow; m++) {
			soma = 0;
			for (int n = 0; n < matrix[m].length; n++) {
			// for (int n = 0; n < 3; n++) {
				 
		         double p = Double.parseDouble(matrix [0][n]); // Primeira linha (target)
		         double q = Double.parseDouble(matrix [m][n]); // Linhas demais
		         
		         soma += Math.pow((p - q), 2);
			}
			 
			// C�lculo de dist�ncia 
	        distancia = Math.sqrt(soma);
	        
	        
			if (distancia < menor) {
				
				menor = distancia;
				maisProximo = m;
			}
			System.out.println("Valor da dist�ncia euclidiana " + String.format("%d: %.2f", m, distancia));
		}
		
		
        // Vetor que possui valores encontrados na primeira linha (target)
		System.out.println("\nO target �: ");
		printArray(matrix [0]);
		
		
		/* O mais pr�ximo � aquele vetor que possui um valor  
		 * menor de dist�ncia em rela��o ao target(0).
		 */
		
		/*
		 * Ent�o toda vez que se acha um valor menor 
		 * de distancia  armazena-se o ind�ce (linha) na matriz (variav�l mais pr�ximo)
		 */
		
		System.out.println("\nItem mais pr�ximo �: ");
		printArray(matrix [maisProximo]);
		
		
        return menor;
	
	}
   

	
	public static void main (String [] args) throws Exception {
		

		File file  = new File ("D:\\dadosSD.csv");
	
		
		int sizeListRow = 4601;
		
		String [][] matrix = new String [sizeListRow] [];
		

		try (Scanner fileReader = new Scanner (file)) {
			
		    int row = 0; 
			while (fileReader.hasNext())  {	
				
				
				String [] dado = fileReader.nextLine().trim().split(",");
				
				matrix [row] = dado;
				row++;
			 
			}
			
			// sizeListRow = 6;
				
	     printArray(matrix, sizeListRow);
	     
	     
	   double   valorDistancia = calculeDistancia (matrix, sizeListRow);
	   
	   
	   System.out.println("\nMenor valor de dist�ncia euclidiana: " + String.format("%.2f", valorDistancia));
			
			
		
	} catch (FileNotFoundException ex) {
		
		ex.printStackTrace();
	}
		
	}
}

