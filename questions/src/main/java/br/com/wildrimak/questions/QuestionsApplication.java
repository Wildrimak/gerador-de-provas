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
		final int finalizados = 6;
		int i = 1;
		start += i++ + ". Terminar mapeamento entre models de negocio e de jpa\n";
		start += i++ + ". Finalizar modelagem dos dtos das controllers\n";
		start += i++ + ". Terminar mapeamento entre models de negocio e os dtos da controller\n";
		start += i++ + ". Atualizar endpoint de criar questao para lista de questoes\n";
		start += i++ + ". Criar endpoint que permite filtras questoes com base em um tema\n";
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
