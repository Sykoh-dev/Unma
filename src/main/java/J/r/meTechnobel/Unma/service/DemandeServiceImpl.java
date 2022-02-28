package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.exceptions.models.ElementAlreadyExistsException;
import J.r.meTechnobel.Unma.exceptions.models.ElementNotFoundException;
import J.r.meTechnobel.Unma.mapper.DemandeMapper;
import J.r.meTechnobel.Unma.models.dto.DemandeDTO;
import J.r.meTechnobel.Unma.models.entity.Demande;
import J.r.meTechnobel.Unma.models.form.DemandeForm;
import J.r.meTechnobel.Unma.repository.DemandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandeServiceImpl implements  DemandeService{

    private final DemandeMapper mapper;
    private final DemandeRepository repository;

    public DemandeServiceImpl(DemandeMapper mapper, DemandeRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<DemandeDTO> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DemandeDTO getOne(int id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public DemandeDTO insert(DemandeForm form) {

        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        Demande toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDto(toInsert);
    }

    @Override
    public DemandeDTO delete(int id) {

        Demande toDelete = repository.findById(id).orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }
}
