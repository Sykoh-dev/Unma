package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.exceptions.models.ElementAlreadyExistsException;
import J.r.meTechnobel.Unma.exceptions.models.ElementNotFoundException;
import J.r.meTechnobel.Unma.mapper.ProfesseurMapper;
import J.r.meTechnobel.Unma.models.dto.ProfesseurDTO;
import J.r.meTechnobel.Unma.models.entity.Professeur;
import J.r.meTechnobel.Unma.models.form.ProfesseurForm;
import J.r.meTechnobel.Unma.repository.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesseurServiceImpl implements  ProfesseurService {

    private final ProfesseurMapper mapper;
    private final ProfesseurRepository repository;

    public ProfesseurServiceImpl(ProfesseurMapper mapper, ProfesseurRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<ProfesseurDTO> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProfesseurDTO getOne(String numMatricule) {
        return repository.findById(numMatricule).map(mapper::toDto).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public ProfesseurDTO insert(ProfesseurForm form) {

        if( repository.existsById(form.getNumMatricule()) )
            throw new ElementAlreadyExistsException();

        Professeur toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDto(toInsert);
    }

    @Override
    public ProfesseurDTO delete(String numMatricule) {

        Professeur toDelete = repository.findById(numMatricule).orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }
}
