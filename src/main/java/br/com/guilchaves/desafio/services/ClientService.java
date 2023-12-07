package br.com.guilchaves.desafio.services;

import br.com.guilchaves.desafio.dto.ClientDTO;
import br.com.guilchaves.desafio.entities.Client;
import br.com.guilchaves.desafio.repositories.ClientRepository;
import br.com.guilchaves.desafio.services.exceptions.DatabaseException;
import br.com.guilchaves.desafio.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


//TODO
// - Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos
// - Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found"));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyPropertiesToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = repository.getReferenceById(id);
            copyPropertiesToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found");
        }

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Data integrity violation: Unable to delete the resource with ID " + id +
                    " due to existing related entities.");
        }
    }

    private void copyPropertiesToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

}
