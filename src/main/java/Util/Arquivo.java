package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {

	private static Scanner scanner;

	public static String leitor(String arquivo) {
		arquivo += ".txt";
		String texto = null;
		try {
			scanner = new Scanner(new File(arquivo));
			texto = scanner.useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}
		return texto;
	}

	public static void escritor(String arquivoTxt, String conteudo) {
		arquivoTxt += ".txt";
		File arquivo = new File(arquivoTxt);
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write(conteudo);
			fw.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
