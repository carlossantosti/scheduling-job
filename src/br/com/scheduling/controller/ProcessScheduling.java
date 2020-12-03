package br.com.scheduling.controller;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.scheduling.model.Job;
import br.com.scheduling.utils.Data;

/**
 * Responsável por processar os dados de agendamento e organizar a sequência de
 * acordo com as definições.
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
	@SuppressWarnings("unchecked")
	public static List<Job> getJobsToExecute(){
		List<Job> jobs = Data.getAllJobs();
		jobs = jobs
				.stream()
				.filter(j -> {
					if(j.getMaxDateConclusion() == null)
						return false;
					
					Date datePlusExecTime = Date.from(j.getMaxDateConclusion().toInstant().plus(j.getEstimatedExecTime(), ChronoUnit.HOURS));
					if (datePlusExecTime.after(Data.getExecWindowEnd()))
						return false;
					
					return
					j.getMaxDateConclusion().equals(Data.getExecWindowStart()) ||
					(j.getMaxDateConclusion().after(Data.getExecWindowStart()) 
							&& j.getMaxDateConclusion().before(Data.getExecWindowEnd()));
				})
				.collect(Collectors.toList());
		
		System.out.println("Jobs filtrados por janela de execução");
		jobs.stream().forEach(j -> System.out.println(j.getDescription()+" - "+j.getMaxDateConclusion()));
		
		jobs.sort((o1, o2) -> o1.getMaxDateConclusion().compareTo(o2.getMaxDateConclusion()));
		
		System.out.println("Jobs ordenados por data máxima");
		jobs.stream().forEach(j -> System.out.println(j.getDescription()+" - "+j.getMaxDateConclusion()));
		
		List<Object> jobsToExecute = new ArrayList<Object>();
		List<Integer> jobs8hours = new ArrayList<Integer>();
		List<Integer> jobsIds = new ArrayList<Integer>();
		int sum = 0;
		
		for (int i = 0; i < jobs.size(); i++) {
			int expectedTime = jobs.get(i).getEstimatedExecTime();
			int id = jobs.get(i).getId();
			sum = jobs8hours.stream().reduce(0, Integer::sum);
			if (sum < 8 && sum+expectedTime <= 8) {
				jobs8hours.add(expectedTime);
				jobsIds.add(id);
			} else {
				jobsToExecute.add(jobsIds);
				jobs8hours = new ArrayList<Integer>();
				jobsIds = new ArrayList<Integer>();
				jobs8hours.add(expectedTime);
				jobsIds.add(id);
			}
			
			if (i == jobs.size() - 1)
				jobsToExecute.add(jobsIds);
		}
		
		jobsToExecute.forEach(j -> {
			List<Integer> list = (List<Integer>) j;
			System.out.print("[");
			for (int k = 0; k < list.size(); k++)
				System.out.print(list.get(k)+(k != list.size()-1 ? "," : ""));
			System.out.println("]");
		});
		
		return jobs;
	}
}
