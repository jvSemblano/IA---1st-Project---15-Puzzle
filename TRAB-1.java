import java.util.*;
import java.lang.*;



class Node{
    private int[][] matrix;
    int profundidade = 0;
    Node pai = NULL;
    int custo = 1;
    char jogada = '';
    private int positionY;
    private int positionX;
    
    Node(int[][] matrix, int positionX, int positionY){
    	this.matrix = matrix;
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
        int positionY;
    	int positionX;
    String moves = "";

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

    static void BFS(Node jogoinicial, Node jogofinal){
    	queue.add(jogoinicial);
    	while(!queue.isEmpty()){
    		Node temporary = queue.remove();
    		moves += temporary.getJogada() + " ";
    		if(Arrays.deepEquals(temporary.getTable(),jogofinal.getTable())){
    			return moves;
    		}	
    		makeDescendants(temporary);
    		return "solution not found";
    	}
    }

    static void DFS (Node jogoinicial, Node jogofinal){
    	queue.add(jogoinicial);
    	while(!queue.isEmpty()){
    		Node temporary = queue.remove();
    		moves += temporary.getJogada() + " ";
    		if(Arrays.deepEquals(temporary.getTable(),jogofinal.getTable())){
    			return moves;
    		}	
    		makeDescendants(temporary);
    		return "solution not found";
    	}
    }


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


	static void moveDown(Node game){
		if(game.getY != 3) {
			int[][] temp = game.getTable();
			int positionY = game.getY();
			int positionX = game.getX();
			temp[positionY][positionX] = temp[positionY + 1][positionX];
			temp[positionY + 1][positionX] = 0;
			//nodes.add(new Node(temp, int prof, int pai, int cost, 'D'));
		}	
	}

	static void moveLeft(Node game){
		if(game.getX != 0) {
			int[][] temp = game.getTable();
			int positionY = game.getY();
			int positionX = game.getX();
			temp[positionY][positionX] = temp[positionY][positionX - 1];
			temp[positionY][positionX - 1] = 0;
			//nodes.add(new Node(temp, int prof, int pai, int cost, 'L'));
		}	
	}

	static void moveRight(Node game){
		if(game.getX != 3) {
			int[][] temp = game.getTable();
			int positionY = game.getY();
			int positionX = game.getX();
			temp[positionY][positionX] = temp[positionY][positionX + 1];
			temp[positionY][positionX + 1] = 0;
			//nodes.add(new Node(temp, int prof, int pai, int cost, 'R'))
		}
	}

	
    	static void arrayToMatrix(int[] array, int[][] config){
	       
    		int i = 0;
    		for(int j = 0; j < 4; j++){
    			for(int z = 0; z < 4; z++){
    				config[j][z] = array[i];
    				if(config[j][z] == 0){
    					positionY = j;
    					positionX = z;
    				}
    				i++;
    			}
    		}

    		
	}
    
    static void makeDescendants(Node pai){
	LinkedList<Node> children = new LinkedList<Node>();
	if(direita){
	    Node d = new Node(...);
	    children.add(d);
    }
    
    static void menu(Node jogoinicial, Node jogofinal){
	System.out.println("Qual algoritmo quer usar?");
	System.out.println("IDFS   -> 1");
	System.out.println("Greddy -> 2");
	System.out.println("A_STAR -> 3");
	System.out.println("BFS    -> 4");
	System.out.println("DFS    -> 5");
	Scanner input = new Scanner(System.in);
	int opcao = input.nextInt();
	switch(opcao){
	case 1: IDFS(jogoinicial, jogofinal);
	        break;
				
	case 2: SERANATADEAMOR(jogoinicial, jogofinal);
	        break;
				
	case 3: A_STAR(jogoinicial, jogofinal);
	        break;

	case 4: BFS(jogoinicial , jogofinal);
	        break;
	    
	case 5: DFS(jogoinicial , jogofinal);
	        break;
				
	default: System.out.println("Escolha uma das opcoes do menu!");
	    break;		    		
	}
    }

    
    public static void main(String[] args){
       	System.out.println("Bem-vindo ao Jogo dos 15!");
	System.out.println("Introduza a configuracao inicial do tabuleiro:");
    	Scanner input = new Scanner(System.in);
    	int[] arrayInicial = new int[16];
	int[] arrayFinal = new int[16];
    	int[][] configinicial = new int[4][4];
	int[][] configfinal = new int[4][4];
    	
    	for(int i = 0; i < arrayInicial.length; i++){
    		arrayInicial[i] = input.nextInt();
    	}

	boolean condI = checkIfPossible(arrayInicial);
		
	
	    
	System.out.println("Insira agora a configuração final:");
	for(int i = 0; i < arrayFinal.length; i++){
    		arrayFinal[i] = input.nextInt();
    	}
	
	boolean condF = checkIfPossible(arrayFinal);
	
	if(condI == condF){
	    arrayToMatrix(arrayInicial, configinicial);
	    Node inicial = new Node(configinicial, positionX, positionY); 
	    arrayToMatrix(arrayFinal, configfinal);
	    Node fim = new Node(configfinal, positionX, positionY); 
	    
	    menu();
	}

	else{
	    System.out.println("Impossible");
	}
    	
    	return;
    
    }
}
