package com.kumulus.desafio.util;

public class StringUtils {

	public static String removerFormatacaoCep(String cep) {
		if (cep != null) {
			return cep.replaceAll("[\\s\\-().]", "");
		}
		return "";
	}
}