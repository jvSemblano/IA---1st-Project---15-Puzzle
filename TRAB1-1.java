
import java.util.*;
import java.lang.*;



class Node{
    private int[][] matrix;
    private int profundidade;
    private int pai;
    private int custo;
    private char jogada;
    
    Node(int[][] matrix2, int prof, int pai, int cost, char jogada){
    	matrix = matrix2;
    	profundidade = prof;
    	this.pai = pai;
    	custo = cost;
    	this.jogada = jogada;
    }

    public void printJogada(){
    	System.out.print(jogada + " ");
    }
    
}

public class TRAB1{

	static int positionX = 0;
	static int positionY = 0;
	static int[][] complete = [[1,2,3,4], [5,6,7,8], [9, 10, 11, 12], [13, 14, 15, 0]];

	static boolean checkIfPossible(int[] array){
		int inversions = 0;
		int blank = 1; // 0 if blank in even row . 1 if blank in odd row

		for(int i = 0; i < array.length; i++){
			if(array[i] == 0 && ((i >= 0 && i <= 3) || (i >= 8 && i <= 11))){
				blank = 0;
			}

			if(array[i] != 0){
				inversions += array[i] - 1;
				for(int j = i; j >= 0; j--){
					if(array[j] != 0 && array[j] < array[i]){
						inversions--;
					}
				}
			}
		}


		if(blank == 0 && inversions%2 != 0){
			return true;
		}

		else if(blank == 1 && inversions%2 == 0){
			return true;
		}

		else{
			return false;
		}
	}

    /*static void IDFS(){
	
    }

    static void GULOSA(){

    }

    static void A(){

    }*/

    /*static void generalSearchAlgorithm( String qualquer, int[][] jogoinicial, int[][] jogofinal){
    	if()
    }*/

    static void moveUp(int[][] gamematrix){
		if(positionY != 0){
			gametrix[positionY][positionX] = gamematrix[positionY - 1][positionX];
			gamematrix[positionY - 1][positionX] = 0;
		}

		else
			return;
	}

	static void moveDown(int[][] gamematrix){
		if(positionY != 3) {
			gametrix[positionY][positionX] = gamematrix[positionY + 1][positionX]
			gamematrix[positionY + 1][positionX] = 0
		}

		else{
			return
		}
		
	}

	static void moveLeft(int[][] gamematrix){
		if(positionX != 0) {
			gametrix[positionY][positionX] = gamematrix[positionY][positionX - 1];
			gamematrix[positionY][positionX - 1] = 0;
		}

		else{
			return;
		}
		
	}

	static void moveRight(int[][] gamematrix){
		if(positionX != 3) {
			gametrix[positionY][positionX] = gamematrix[positionY][positionX + 1];
			gamematrix[positionY][positionX + 1] = 0;
		}

		else{
			return;
		}
	}


    
    public static void main(String[] args){
    	Scanner input = new Scanner(System.in);

    	int[] arrayToCheck = new int[16];
    	int[][] configinicial = new int[4][4];
    	int[][] matrix = new int [4][4];


    	for(int i = 0; i < arrayToCheck.length; i++){
    		arrayToCheck[i] = input.nextInt();
    	}

    	if(checkIfPossible(arrayToCheck)){

    		int i = 0;
    		for(int j = 0; j < 4; j++){
    			for(int z = 0; z < 4; z++){
    				configinicial[j][z] = arrayToCheck[i];
    				if(configinicial[j][z] == 0){
    					positionY = j;
    					positionX = z;
    				}
    				i++;
    			}
    		}
   			 		
       	}	

    	else{
    		System.out.println("O puzzle e impossivel de resolver!..."); 
    	}
    	

    
    }
}
