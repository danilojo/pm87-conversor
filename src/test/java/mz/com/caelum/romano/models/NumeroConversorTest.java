package mz.com.caelum.romano.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mz.com.caelum.romano.models.NumeroConversor;

public class NumeroConversorTest {

	private NumeroConversor conversor;

	@Before
	public void setUp() {
		conversor = new NumeroConversor("VI");
	}

	@Test
	public void deveRetornaFalsoSeSimboloRomanoNaoExistir() {
		conversor.setNumeroRomano("XC");
		Assert.assertTrue("Simbolo nao existe no vocabulario", conversor.temSimbolo());
	}

	@Test
	public void deveRetornarValorNumericoDeApenasUmSimboloRomano() {
		conversor.setNumeroRomano("VI");
		Assert.assertEquals(5, conversor.pegaValorNumerico(conversor.getNumeroRomano().charAt(0)));
	}

	@Test
	public void deveRetornarMaiorValorRomano(){
		conversor.setNumeroRomano("XII");
		Assert.assertEquals('X', conversor.pegaMaiorValorRomano());
	}
	
	@Test
	public void deveRetornarQuantidadeTotalDeSimbolos(){
		conversor.setNumeroRomano("XC");
		Assert.assertEquals(2, conversor.getNumeroRomano().length());
	}
	
	@Test
	public void deveVerificarSeExisteSequenciaRomanaEntreDoisValores(){
		conversor.setNumeroRomano("XX");
		String numRomano = conversor.getNumeroRomano();
		Assert.assertTrue("Nao Existe Sequencia de valores na expressao ["+numRomano+"]" ,conversor.temOrdemCrescenteRomana());
	}
	
	@Test
	public void deveCalcularSubtraccaoDeSimbolosRomanosParaDecimal() {
		conversor.setNumeroRomano("XL");
		Assert.assertEquals(40, conversor.calculaDiferencaRomana());
	}
	
	@Test
	public void deveConverterSimboloRomanoEmDecimal() {
		conversor.setNumeroRomano("VIII");
		Assert.assertEquals(8, conversor.converte());
	}
		

}
