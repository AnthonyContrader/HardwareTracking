package it.contrader.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;


import it.contrader.converter.Converter;
import it.contrader.dao.DAOGeneralInterface;

/**
 * Questa classe astratta implementa tutti i metodi CRUD firmati in ServiceDTO.
 * Il converter agisce due volte nei metodi  insert e update per avere sia come input che come output
 * un oggetto DTO.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @param <Entity>
 * @param <DTO>
 * 
 * @see ServiceDTO
 */
public abstract class AbstractService<Entity,DTO> implements ServiceDTO<DTO> {
	
	@Autowired
	protected DAOGeneralInterface<Entity> repository;
	@Autowired
	protected Converter<Entity,DTO> converter;
	
	@Override
	@Transactional
	public DTO insert(DTO dto) {
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}

	@Override
	@Transactional
	public List<DTO> getAll() {
		return converter.toDTOList(repository.findAll());
	}

	@Override
	@Transactional
	public DTO read(int id) {
		return converter.toDTO(repository.findById(id));
	}

	@Override
	@Transactional
	public DTO update(DTO dto) {
		return converter.toDTO(repository.update(converter.toEntity(dto)));
	}

	@Override
	@Transactional
	public void delete(int id) {
		repository.deleteById(id);
	}
}