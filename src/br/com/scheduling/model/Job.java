package br.com.scheduling.model;

import java.util.Date;

/**
 * Modelo do Job a ser executado.
 * Cont�m todas as informa��es sobre o Job
 * 
 * @author Carlos Santos
 */
public class Job {
	private int id;
	private String description;
	private Date maxDateConclusion;
	private int estimatedExecTime;
	
	/**
	 * M�todo construtor do Job
	 * 
	 * @param id - Identifica��o do Job
	 * @param description - Descri��o do Job
	 * @param maxDateConclusion - Data m�xima em que o job deve ser conclu�do
	 * @param estimatedExecTime - Tempo estimado de execu��o do job
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
