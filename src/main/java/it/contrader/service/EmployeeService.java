package it.contrader.service;

import java.util.List;

import it.contrader.converter.EmployeeConverter;
import it.contrader.dao.EmployeeDAO;
import it.contrader.dto.EmployeeDTO;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class EmployeeService {
	
	private EmployeeDAO EmployeeDAO;
	private EmployeeConverter EmployeeConverter;
	
	//Istanzio DAO  e Converter specifici.
	public EmployeeService(){
		this.EmployeeDAO = new EmployeeDAO();
		this.EmployeeConverter = new EmployeeConverter();
	}
	

	public List<EmployeeDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return EmployeeConverter.toDTOList(EmployeeDAO.getAll());
	}
	
	
	public EmployeeDTO read(String idFC) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return EmployeeConverter.toDTO(EmployeeDAO.read(idFC));
	}


	public boolean insert(EmployeeDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return EmployeeDAO.insert(EmployeeConverter.toEntity(dto));
	}


	public boolean update(EmployeeDTO dto) {
		// Converte un EmployeeDTO in entità e lo passa allo EmployeeDAO per la modifica
		return EmployeeDAO.update(EmployeeConverter.toEntity(dto));
	}


	public boolean delete(String idFC) {
		// Questo mtodo chiama direttamente il DAO
		return EmployeeDAO.delete(idFC);
	}

}
