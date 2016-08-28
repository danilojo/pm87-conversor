package mz.com.caelum.romano.models;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumeroConversor implements ConversorLogic {

	private Map<Character, Integer> romMap = new HashMap<>();
	private String numeroRomano;

	public String getNumeroRomano() {
		return numeroRomano;
	}

	public void setNumeroRomano(String numeroRomano) {
		this.numeroRomano = numeroRomano;
	}

	public NumeroConversor(String numeroRomano) {
		romMap.put('I', 1);
		romMap.put('V', 5);
		romMap.put('X', 10);
		romMap.put('L', 50);
		romMap.put('C', 100);
		this.numeroRomano = numeroRomano;
	}

	@Override
	public boolean temSimbolo() {

		for (int i = 0; i < numeroRomano.length(); i++) {
			if (!romMap.containsKey(numeroRomano.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int pegaValorNumerico(char simbolo) {
		return romMap.get(simbolo);
	}

	public char pegaMaiorValorRomano() {

		int maiorValor = -1;
		char maiorSimbolo = ' ';

		for (int i = 0; i < numeroRomano.length(); i++) { // percorre o simbolo

			int valorNumericoSimboloActual = this.pegaValorNumerico(numeroRomano.charAt(i));

			if (valorNumericoSimboloActual > maiorValor) {
				maiorValor = valorNumericoSimboloActual;
				maiorSimbolo = numeroRomano.charAt(i);
			}

		}

		return maiorSimbolo;
	}

	@Override
	public int converte() {

		int result = 0;
		if (temOrdemCrescenteRomana()) { // soma todos os simbolos
			for (int i = 0; i < numeroRomano.length(); i++) {
				result += this.pegaValorNumerico(numeroRomano.charAt(i));
			}
		} else {
			// remove os ultimos dois simbolos e acha a diferenca
			for (int i = 0; i < numeroRomano.length() - 2; i++) {
				result += this.pegaValorNumerico(numeroRomano.charAt(i));
			}
			//soma o total pela diferenca
			result = result + this.calculaDiferencaRomana();
		}

		return result;
	}

	public int calculaDiferencaRomana() {

		char penultimoSimbolo = numeroRomano.charAt(numeroRomano.length() - 2);
		char ultimoSimbolo = numeroRomano.charAt(numeroRomano.length() - 1);

		return (this.pegaValorNumerico(ultimoSimbolo) - this.pegaValorNumerico(penultimoSimbolo));

	}

	public boolean temOrdemCrescenteRomana() {
		char penultinoSimbolo = numeroRomano.charAt(numeroRomano.length() - 2);
		char ultimoSimbolo = numeroRomano.charAt(numeroRomano.length() - 1);

		return (this.pegaValorNumerico(penultinoSimbolo) >= this.pegaValorNumerico(ultimoSimbolo)) ? true : false;

	}

}
