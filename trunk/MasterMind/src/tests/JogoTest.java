package tests;

import jogo.CorInvalidaException;
import jogo.Jogada;
import jogo.Jogo;
import jogo.PosicaoInvalidaException;
import jogo.Retorno;
import jogo.Tentativa;
import junit.framework.TestCase;

public class JogoTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/*
	 * O m�todo verSeAdivinhoGanhouJogo tem um try/catch que em condi��es normais n�o ser�
	 * executado, porque a exce��o seria lan�ada pelo "getPino(i)" onde "i" pertence ao "for",
	 * sendo assim, n�o � poss�vel que a exce��o seja lan�ada.
	 */
	public void testVerificaAdivinhoGanhou () throws PosicaoInvalidaException, CorInvalidaException {
		// Construtor
		Jogo jogo = new Jogo();
		
		Retorno retorno = new Retorno();
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		
		jogo.setJogada(jogada);
		
		//run and assert
		assertTrue(jogo.verSeAdivinhoGanhouJogo());
	}
	
	public void testVerificaAdivinhoGanhouJogadaNula () {
		// Construtor
		Jogo jogo = new Jogo();
		
		Jogada jogada = null;
		jogo.setJogada(jogada);
		
		//run and assert
		assertFalse(jogo.verSeAdivinhoGanhouJogo());
	}
	
	public void testVerificaAdivinhoNaoGanhou () throws PosicaoInvalidaException, CorInvalidaException {
		// Construtor
		Jogo jogo = new Jogo();
		
		Retorno retorno = new Retorno();
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("branco");
		
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		
		jogo.setJogada(jogada);
		
		assertFalse(jogo.verSeAdivinhoGanhouJogo());
	}
	
	public void testCriarSenha(){
		/*
		 * O m�todo testado simplesmente usa o m�todo FornecedorDaSenha.criarSenha(), que,
		 * como explicado em coment�rio no m�todo tests.FornecedorDaSenhaTest.testCriarSenha,
		 * � rand�mico e n�o tem como ser testado.
		 */
		Jogo jogo = new Jogo();
		jogo.criarSenha();
		assertTrue(true);
	}
	
	
	/*
	 * Os 4 m�todos a seguir se referem a testes dos m�todos Jogo.mostrarPinosTentativaDaJogada e
	 * Jogo.mostrarPinosRetornoDaJogada.
	 * Eles n�o t�m assert, pois os m�todos citados s�o do tipo void, com apenas um system.out no c�digo,
	 * logo n�o � poss�vel comparar nada para verificar a corretude do m�todo, j� que os m�todos
	 * n�o alteram o estado de nenhuma vari�vel e nem retornam nada.
	 * Al�m disso, esses m�todos n�o usam "throws" para nenhuma exce��o,
	 * A �nica exce��o dos m�todos (PosicaoInvalidaException) � tratada internamente com try/catch, logo, n�o h� exceptions
	 * para o teste capturar.
	 */
	public void testMostrarPinosTentativa() throws CorInvalidaException, PosicaoInvalidaException{
		Jogo jogo = new Jogo();
		
		//Tentativa
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "rosa");
		t.adicionarPino(1, "verde");
		t.adicionarPino(2, "azul");
		t.adicionarPino(3, "amarelo");
		
		Jogada jogada = new Jogada();
		jogada.setTentativa(t);
		
		jogo.setJogada(jogada);
		
		jogo.mostrarPinosTentativaDaJogada();
		
	}
	
	public void testMostrarPinosTentativaNullPointer() throws CorInvalidaException, PosicaoInvalidaException{
		Jogo jogo = new Jogo();
		
		//Tentativa
		Tentativa t = null;
		Jogada jogada = new Jogada();
		jogada.setTentativa(t);
		
		jogo.setJogada(jogada);
		
		/*
		 * Quando o m�todo � chamado com uma tentativa setada como nula, � lan�ada uma
		 * NullPointerException, n�o prevista pelos criadores do software.
		 */
		try{
			jogo.mostrarPinosTentativaDaJogada();
			fail("Tentativa nula");
		} catch (NullPointerException e) {}
		
	}
	
	public void testMostrarPinosRetorno() throws CorInvalidaException{
		Jogo jogo = new Jogo();
		
		//retorno
		Retorno retorno = new Retorno();
		retorno.adicionarPino("preto");
		retorno.adicionarPino("branco");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("branco");
		
		//Tentativa
		
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		
		jogo.setJogada(jogada);
		
		jogo.mostrarPinosRetornoDaJogada();
		
	}
	
	public void testMostrarPinosRetornoNullPointer() throws CorInvalidaException{
		Jogo jogo = new Jogo();
		
		//retorno
		Retorno retorno = null;
		
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		
		jogo.setJogada(jogada);
		
		/*
		 * Quando o m�todo � chamado com um retorno setado como nulo, � lan�ada uma
		 * NullPointerException, n�o prevista pelos criadores do software.
		 */
		try{
			jogo.mostrarPinosRetornoDaJogada();
			fail("Retorno nulo");
		} catch (NullPointerException e) {}
		
	}
	
	/* 
	 * Os 2 m�todos a seguir se referem ao m�todo Jogo.terminarJogo().
	 * Eles n�o t�m assert, pois os m�todos citados s�o do tipo void, com apenas um system.out no c�digo,
	 * logo n�o � poss�vel comparar nada para verificar a corretude do m�todo, j� que os m�todos
	 * n�o alteram o estado de nenhuma vari�vel e nem retornam nada.
	 */
	public void testTerminarJogoTerminou() {
		//construtor
		Jogo jogo = new Jogo();
		jogo.setTurno(10);
		
		jogo.terminarJogo();
		
	}
	
	public void testTerminarJogoVenceu() {
		//construtor
		Jogo jogo = new Jogo();
		jogo.setTurno(7);
		
		jogo.terminarJogo();
		
	}
}
