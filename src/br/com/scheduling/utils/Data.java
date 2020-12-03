package br.com.scheduling.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.scheduling.model.Job;

/**
 * Classe utilizada como apoio ao código fornecendo os dados.
 * 
 * @author Carlos Santos
 *
 */
public class Data {	
	static Calendar cal = Calendar.getInstance();
	private static Date execWindowStart = null;
	private static Date execWindowEnd = null;
	
	public static Date getExecWindowStart() {
		if (execWindowStart == null) {			
			cal.set(2020, 11, 03, 00, 00, 00);
			execWindowStart = cal.getTime();
		}
		
		return execWindowStart;
	}
	
	public static Date getExecWindowEnd() {
		if (execWindowEnd == null) {
			cal.set(2020, 11, 04, 23, 00, 00);
			execWindowEnd = cal.getTime();
		}
		
		return execWindowEnd;
	}
	
	/**
	 * Método utilizado para obter todos os jobs
	 * 
	 * @return Todos os jobs
	 */
	public static List<Job> getAllJobs(){		
		cal.set(2020, 11, 03, 07, 50, 00);
		Job job1 = new Job(1, "job1", cal.getTime(), 5);
		
		cal.set(2020, 11, 05, 06, 50, 00);
		Job job2 = new Job(2, "job2", cal.getTime(), 6);
		
		cal.set(2020, 11, 03, 07, 51, 40);
		Job job3 = new Job(3, "job3", cal.getTime(), 3);
		
		cal.set(2020, 11, 02, 05, 30, 00);
		Job job4 = new Job(4, "job4", cal.getTime(), 2);
		
		cal.set(2020, 11, 03, 00, 00, 00);
		Job job5 = new Job(5, "job5", cal.getTime(), 1);
		
		List<Job> jobs = new ArrayList<>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job4);
		jobs.add(job5);
		
		System.out.println("Start: "+getExecWindowStart()+" - End: "+getExecWindowEnd());
		
		System.out.println("Jobs sem processamento");
		jobs.stream().forEach(j -> System.out.println(j.getDescription()+" - "+j.getMaxDateConclusion()+" -> "+j.getEstimatedExecTime()+"h"));
		
		return jobs;
	}
}
