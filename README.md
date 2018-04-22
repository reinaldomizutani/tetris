Making a version of the game Tetris, as project of Object-Oriented Programming - 2018 Universidade de São Paulo - Bachelor in Information Systems


Classe GameScreen
	atributos: 
		private final lolo -> personagem principal.
		private final elemArray -> objetos na tela de jogo (com lógica de colisão e etc.).
		private final GameController -> 4 inputs para cima/baixo/esquerda/direita.

	métodos:
	    (construtor) public GameScreen()
	    	- inicia tela de jogo e componentes (lolo e obstáculos).
	    	- configura o tamanho da tela.
	    	- cria cenário (elemArray), lolo e caveira, inserindo-os nas posições iniciais.

	    addElement(Element elem) -> Adiciona elemento à elemArray (objetos do jogo).

	    removeElement(Element elem) -> remove elemento da elemArray (objetos de jogo).

	    go() -> creates a timer and refreshes the game screen every X miliseconds.

	    keyPressed(KeyEvent e) -> 	
	    	- lê o teclado e move lolo para a posição indicada. 
	    	- A lógica de colisão é feita pela classe GameController,
	    	- no método isValidPosition.

Classe GameController
	atributos: não tem

	métodos:
		drawAllElements(Element elem, Graphics g) -> desenha todos os elementos do jogo (contidos em elem) na tela de jogo (g).

		processAllElements(ArrayList<element> e) -> parte lógica, que usa outros métodos para verificar se a posição dos objetos é válida.
			- se array é vazio, não faz nada.
			- se posição de lolo não é válida, volta lolo para a última posição.
			- verifica se objetos "morreram" e remove objeto morto.

		isValidPosition(elemArray, elem) -> verifica se a posição que o player indicou é válida para lolo
			- elemArray é o cenário, elem é o lolo.
			- lolo só tem 1 quadrado, portanto será necessário alterar o código para o tetris.
			- para todos os quadrados, verifica se lolo está em um quadrado válido, retornando true ou false.
			
