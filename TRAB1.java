
import java.util.*;
import java.lang.*;



class Node{
    private int[][] matrix;
    private int profundidade;
    private int pai;
    private int custo;
    private char jogada;
    private int positionY;
    private int positionX;
    
    Node(int[][] matrix, int prof, int pai, int cost, char jogada, int positionX, int positionY){
    	this.matrix = matrix;
    	profundidade = prof;
    	this.pai = pai;
    	custo = cost;
    	this.jogada = jogada;
    	this.positionY = positionY;
    	this.positionX = positionX;
    }

    public char getJogada(){
    	return jogada;
    }

    public int[][] getTable(){
    	return matrix;
    }

    public int getX(){
    	return positionX;
    }

    public int getY(){
    	return positionY;
    }
}

public class TRAB1{


	static int[][] complete = {{1,2,3,4}, 
							   {5,6,7,8}, 
							   {9, 10, 11, 12}, 
							   {13, 14, 15, 0}};
	static LinkedList<Node> queue = new LinkedList<Node>();



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

    static String generalSearchAlgorithm(String funcao, Node jogoinicial, int[][] jogofinal){
    	String moves = "";
    	queue.add(jogoinicial);
    	while(!queue.isEmpty()){
    		Node temporary = queue.remove();
    		moves += temporary.getJogada() + " ";
    		if(Arrays.deepEquals(temporary.getTable(),jogofinal)){
    			return moves;
    		}	
    		//construir os filhos e inseri-los todos na queue
    		return "solution not found";
    	}
    }

    static void 

    static void moveUp(Node game){
		if(game.getY != 0){
			int positionY = game.getY();
			int positionX = game.getX();
			int[][] temp = game.getTable();
			temp[positionY][positionX] = temp[positionY - 1][positionX];
			temp[positionY - 1][positionX] = 0;
			//nodes.add(new Node(temp, int prof, int pai, int cost, 'U'));
		}
	}


	static void moveDown(int[][] temp){
		if(game.getY != 3) {
			int[][] temp = game.getTable();
			int positionY = game.getY();
			int positionX = game.getX();
			temp[positionY][positionX] = temp[positionY + 1][positionX];
			temp[positionY + 1][positionX] = 0;
			//nodes.add(new Node(temp, int prof, int pai, int cost, 'D'));
		}	
	}

	static void moveLeft(int[][] temp){
		if(game.getX != 0) {
			int[][] temp = game.getTable();
			int positionY = game.getY();
			int positionX = game.getX();
			temp[positionY][positionX] = temp[positionY][positionX - 1];
			temp[positionY][positionX - 1] = 0;
			//nodes.add(new Node(temp, int prof, int pai, int cost, 'L'));
		}	
	}

	static void moveRight(int[][] temp){
		if(game.getX != 3) {
			int[][] temp = game.getTable();
			int positionY = game.getY();
			int positionX = game.getX();
			temp[positionY][positionX] = temp[positionY][positionX + 1];
			temp[positionY][positionX + 1] = 0;
			//nodes.add(new Node(temp, int prof, int pai, int cost, 'R'));
		}
	}


    
    public static void main(String[] args){
    	Scanner input = new Scanner(System.in);

    	int[] arrayToCheck = new int[16];
    	int[][] configinicial = new int[4][4];
    	
    	
    
    	for(int i = 0; i < arrayToCheck.length; i++){
    		arrayToCheck[i] = input.nextInt();
    	}

    	if(checkIfPossible(arrayToCheck)){
    		int positionY;
    		int positionX;
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

    		nodes.add(new Node(configinicial, 0, NULL, 1, NULL, positionX, positionY))
   			 		
       	}	

    	else{
    		System.out.println("O puzzle e impossivel de resolver!..."); 
    	}
    	
    	return;
    
    }
}
