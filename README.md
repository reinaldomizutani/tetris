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
			
Classe Element

	atributos: 
	    protected ImageIcon imageIcon;
    	protected Position pos;
    	protected boolean isTransposable; // Pode passar por cima?
    	protected boolean isMortal;       // Se encostar, morre?

    métodos: 
    	(construtor) Element(nome da imagem)
    		- estabelece posição inicial do elemento, se pode ou não ser atravessado e se pode morrer.
    		- try/catch -> tenta utilizar uma imagem (png/jpg/bmp/...) para o elemento (lolo e skull).

    	overlap(elem):
    		- verifica se  objeto está na mesma posição que um objeto na tela. Essa função é chamada por outros objetos que já estão na tela. 

    	getStringPosition():
    		- retorna string do tipo (x,y)

    	setPosition(int x, int y)
    		- tenta colocar objeto na posição (x,y), retornando true se a posição é válida e false se não é.

    	isTransposable() -> retorna true ou false se o objeto é transponível ou não.

    	setTransposable(bool) -> estabelece se o objeto é transponível ou não.

    	isMortal() -> retorna true ou false se o objeto pode morrer.

    	moveUp(), moveDown(), moveLeft(), moveRight() ->
    		usam classe Position para estabelecer nova posição do objeto, retornando true ou false se objeto foi movido ou não.


 classe Drawing

 	atributos: 
 		Gamescreen screen -> tela do jogo.

 	métodos:
 		getGameScreen():
 			- retorna a tela do jogo

 		setGameScreen():
 			- cria uma nova tela de jogo

 		draw(Graphics g, ImageIcon imageIcon, double y, double x): 
 			- usa biblioteca Graphics do java. <- verificar
 			- desenha os objetos na tela

classe Position:
	
	atributos:
		private int x, y, previousX, previousY 

	métodos:
		setPosition(x, y) -> estabelece nova posição e retorna true ou false se a posição foi alterada.

		getX(), getY() -> retornam X ou Y do objeto.

		comeBack() -> volta o objeto para a posição anterior.

		moveUp(), moveDown(), moveLeft() e moveRight() -> move objetos para as direções indicadas. Retorna true ou false se conseguiu ou não mover o objeto para uma posição válida.
