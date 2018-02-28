
import java.lang.*;
import java.util.*;


class Node{
	private int[][] matrix;
	int profundidade = 0;
	Node pai = null;
	int custo = 1;
	char jogada = ' ';
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
	static int positionY;
	static int positionX;
	static String moves = "";


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

	static boolean compareMatrix(int[][] array1, int[][] array2){
		for(int i = 0; i < array1[0].length; i++){
			for(int j = 0; j < 4; j++){
				if(array1[i][j] != array2[i][j]){
					return false;
				}
			}
		}

		return true;
	}


    static void IDFS(Node jogoinicial, Node jogofinal){
		HashMap<String, Node> visitados = new HashMap<>();
    	LinkedList<Node> filhotes = new LinkedList<Node>();
    	LinkedList<Node> queue = new LinkedList<Node>();
    	int limite = 1;
    	queue.add(jogoinicial);
    	
    	while(!queue.isEmpty()){

    		Node temporary = queue.remove();
    		System.out.println(Arrays.deepToString(temporary.getTable()) + " " + temporary.profundidade);
    		
    		if(compareMatrix(temporary.getTable(), jogofinal.getTable())){
    			moves = "Profundidade = " + temporary.profundidade + "\n";
    			while(temporary.profundidade != 0){
    				moves += temporary.getJogada() + " ";
    				temporary = temporary.pai;
    			}
    			System.out.println(moves);
    			return;
    		}	


    		if(temporary.profundidade + 1 >= limite && queue.isEmpty()){
    				queue = new LinkedList<Node>();
    				System.out.println("queue empty = " + queue.isEmpty());
    				queue.add(jogoinicial);
    				visitados = new HashMap<String, Node>();
    				limite++;
    					System.out.println("limite = " + limite);
    				
    			}

    		else if(temporary.profundidade + 1 < limite){
    			filhotes = makeDescendants(temporary);
    			for(int i = 0; i < filhotes.size(); i++){
    				if(!visitados.containsKey(Arrays.deepToString(filhotes.get(i).getTable()))){
    					visitados.put(Arrays.deepToString(filhotes.get(i).getTable()), filhotes.get(i));
    					queue.add(filhotes.get(i));
    				}
    			}
    		}


    	}

    	System.out.println("solution not found");
    	return;
    }
    /*
    static void GULOSA(){
    }
    static void A(){
    }*/

    static void BFS(Node jogoinicial, Node jogofinal){
    	HashMap<String, Node> visitados = new HashMap<>();
    	LinkedList<Node> filhotes = new LinkedList<Node>();
    	LinkedList<Node> queue = new LinkedList<Node>();

    	queue.add(jogoinicial);
    	
    	while(!queue.isEmpty()){
    		Node temporary = queue.remove();
    		System.out.println(Arrays.deepToString(temporary.getTable()) + " " + temporary.profundidade);
    		if(compareMatrix(temporary.getTable(), jogofinal.getTable())){
    			moves = "Profundidade = " + temporary.profundidade + "\n";
    			while(temporary.profundidade != 0){
    				moves += temporary.getJogada() + " ";
    				temporary = temporary.pai;
    			}
    			System.out.println(moves);
    			return;
    		}	
    		filhotes = makeDescendants(temporary);
    	
    		for(int i = 0; i < filhotes.size(); i++){
   			
    			if(!visitados.containsKey(Arrays.deepToString(filhotes.get(i).getTable()))){
    				visitados.put(Arrays.deepToString(filhotes.get(i).getTable()), filhotes.get(i));
    				queue.add(filhotes.get(i));
    			}

    		}
    	}

    	System.out.println("solution not found");
    	return;

    }

    static void DFS (Node jogoinicial, Node jogofinal){
    	HashMap<String, Node> visitados = new HashMap<>();
    	LinkedList<Node> filhotes = new LinkedList<Node>();
    	LinkedList<Node> queue = new LinkedList<Node>();

    	queue.add(jogoinicial);
    	while(!queue.isEmpty()){
    		Node temporary = queue.remove();
    		System.out.println(Arrays.deepToString(temporary.getTable()) + " " + temporary.profundidade);
    		
    		if(compareMatrix(temporary.getTable(), jogofinal.getTable())){
    			moves = "Profundidade = " + temporary.profundidade + "\n";
    			while(temporary.profundidade != 0){
    				moves += temporary.getJogada() + " ";
    				temporary = temporary.pai;
    			}
    			System.out.println(moves);
    			return;
    		}	
    		filhotes = makeDescendants(temporary);
    		for(int i = 0; i < filhotes.size(); i++){
   			
    			if(!visitados.containsKey(Arrays.deepToString(filhotes.get(i).getTable()))){
    				visitados.put(Arrays.deepToString(filhotes.get(i).getTable()), filhotes.get(i));
    				queue.addFirst(filhotes.get(i));
    			}

    		}
    	}

    	System.out.println("solution not found");
    	return;
    }


    static Node moveUp(Node game){

    	int positionY = game.getY();
    	int positionX = game.getX();
    	int[][] temp = new int[4][4];
    	for(int i = 0; i < 4; i++){
    		for(int j=0 ; j<4; j++) {
    			temp[i][j]=game.getTable()[i][j];
    		}
    	}
    	temp[positionY][positionX] = temp[positionY - 1][positionX];
    	temp[positionY - 1][positionX] = 0;
    	Node toReturn = new Node(temp,positionX, positionY - 1);
    	toReturn.pai = game;
    	toReturn.jogada = 'U';
    	toReturn.profundidade = game.profundidade + 1;
    	return toReturn;


    }


    static Node moveDown(Node game){


    	int positionY = game.getY();
    	int positionX = game.getX();
    	int[][] temp = new int[4][4];
    	for(int i = 0; i < 4; i++){
    		for(int j=0 ; j<4; j++) {
    			temp[i][j]=game.getTable()[i][j];
    		}
    	}
    	temp[positionY][positionX] = temp[positionY + 1][positionX];
    	temp[positionY + 1][positionX] = 0;
    	Node toReturn = new Node(temp,positionX, positionY + 1);
    	toReturn.pai = game;
    	toReturn.jogada = 'D';
    	toReturn.profundidade = game.profundidade + 1;
    	return toReturn;

    }

    static Node moveLeft(Node game){


    	int positionY = game.getY();
    	int positionX = game.getX();
    	int[][] temp = new int[4][4];
    	for(int i = 0; i < 4; i++){
    		for(int j=0 ; j<4; j++) {
    			temp[i][j]=game.getTable()[i][j];
    		}
    	}
    	temp[positionY][positionX] = temp[positionY][positionX - 1];
    	temp[positionY][positionX - 1] = 0;
    	Node toReturn = new Node(temp,positionX - 1, positionY);
    	toReturn.pai = game;
    	toReturn.jogada = 'L';
    	toReturn.profundidade = game.profundidade + 1;
    	return toReturn;

    }

    static Node moveRight(Node game){
    	int positionY = game.getY();
    	int positionX = game.getX();
    	int[][] temp = new int[4][4];
    	for(int i = 0; i < 4; i++){
    		for(int j=0 ; j<4; j++) {
    			temp[i][j]=game.getTable()[i][j];
    		}
    	}
    	temp[positionY][positionX] = temp[positionY][positionX + 1];
    	temp[positionY][positionX + 1] = 0;
    	Node toReturn = new Node(temp,positionX + 1, positionY);
    	toReturn.pai = game;
    	toReturn.jogada = 'R';
    	toReturn.profundidade = game.profundidade + 1;
    	return toReturn;
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
    
    static LinkedList<Node> makeDescendants(Node pai){
    	LinkedList<Node> children = new LinkedList<Node>();
    	if(pai.getY() != 0){
    		children.add(moveUp(pai));
    	}

    	if(pai.getY() != 3){
    		children.add(moveDown(pai));
    	}

    	if(pai.getX() != 0){
    		children.add(moveLeft(pai));
    	}

    	if(pai.getX() != 3){
    		children.add(moveRight(pai));
    	}

    	return children;
    }
    
    static void menu(Node jogoinicial, Node jogofinal){
    	System.out.println("Qual algoritmo quer usar?");
    	System.out.println("IDFS   -> 1");
    	System.out.println("Greedy -> 2");
    	System.out.println("A_STAR -> 3");
    	System.out.println("BFS    -> 4");
    	System.out.println("DFS    -> 5");
    	Scanner input = new Scanner(System.in);
    	int opcao = input.nextInt();
    	switch(opcao){
	    case 1: IDFS(jogoinicial, jogofinal);
	        break;
				
			/*case 2: SERANATADEAMOR(jogoinicial, jogofinal);
	        break;
				
	case 3: A_STAR(jogoinicial, jogofinal);
	break;*/

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

		System.out.println("Insira agora a configuracao final:");
		for(int i = 0; i < arrayFinal.length; i++){
			arrayFinal[i] = input.nextInt();
		}
		
		boolean condF = checkIfPossible(arrayFinal);
		
		if(condI == condF){
			arrayToMatrix(arrayInicial, configinicial);

			Node inicial = new Node(configinicial, positionX, positionY); 
			arrayToMatrix(arrayFinal, configfinal);
			Node fim = new Node(configfinal, positionX, positionY); 

			menu(inicial, fim);
		}

		else{
			System.out.println("Impossible");
		}

		return;

	}
}

