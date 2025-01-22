package br.com.wildrimak.questions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionsApplication.class, args);
		System.out.println(proximosPassos());
	}

	private static String proximosPassos() {
		String start = "\n\n\n\n\n";
		final int finalizados = 11;
		int i = 1;
		start += i++ + ". Refatorar a parte de service para que o dominio de negocios, nao tenha dependencias com o dominio de data\n";
		start += "\n\n";
		int total = finalizados + i;
		double percentual = (100 * finalizados) / (double) total;
		String resultado = String.format("%.2f", percentual) + "%";
		String line = "+-------------------------------+\n";
		String show = "| CONCLUÍDO " + resultado + " das tarefas! |\n";
		start += line + show + line;
		return start;
	}

}
