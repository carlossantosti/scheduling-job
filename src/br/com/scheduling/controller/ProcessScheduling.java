package br.com.scheduling.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.scheduling.model.Job;
import br.com.scheduling.utils.Data;

/**
 * Responsável por processar os dados de agendamento
 * e organizar a sequência de acordo com as definições.
 * 
 * @author Carlos Santos
 *
 */
public class ProcessScheduling {
	
	/**
	 * Método responsável pelo processamento dos dados.
	 * 
	 * @return Retorna uma lista de jobs que deve ser executada.
	 */
	public static List<Job> getJobsToExecute(){
		List<Job> jobs = Data.getAllJobs();
		jobs = jobs
				.stream()
				.filter(j -> {
					return
					//Maior que o início e menor que o fim. 
					j.getMaxDateConclusion().after(Data.getExecWindowStart()) 
							&& j.getMaxDateConclusion().before(Data.getExecWindowEnd());
				})
				.collect(Collectors.toList());
		
		jobs.sort((o1, o2) -> o1.getMaxDateConclusion().compareTo(o2.getMaxDateConclusion()));
		return jobs;
	}
}
