package br.com.scheduling.model;

import java.util.Date;

/**
 * Modelo do Job a ser executado.
 * Contém todas as informações sobre o Job
 * 
 * @author Carlos Santos
 */
public class Job {
	private int id;
	private String description;
	private Date maxDateConclusion;
	private int estimatedExecTime;
	
	/**
	 * Método construtor do Job
	 * 
	 * @param id - Identificação do Job
	 * @param description - Descrição do Job
	 * @param maxDateConclusion - Data máxima em que o job deve ser concluído
	 * @param estimatedExecTime - Tempo estimado de execução do job
	 */
	public Job(int id, String description, Date maxDateConclusion, int estimatedExecTime) {
		super();
		this.id = id;
		this.description = description;
		this.maxDateConclusion = maxDateConclusion;
		this.estimatedExecTime = estimatedExecTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getMaxDateConclusion() {
		return maxDateConclusion;
	}

	public void setMaxDateConclusion(Date maxDateConclusion) {
		this.maxDateConclusion = maxDateConclusion;
	}

	public int getEstimatedExecTime() {
		return estimatedExecTime;
	}

	public void setEstimatedExecTime(int estimatedExecTime) {
		this.estimatedExecTime = estimatedExecTime;
	}
	
}
