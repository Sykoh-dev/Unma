package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.exceptions.models.ElementAlreadyExistsException;
import J.r.meTechnobel.Unma.exceptions.models.ElementNotFoundException;
import J.r.meTechnobel.Unma.mapper.EtudiantMapper;
import J.r.meTechnobel.Unma.models.dto.EtudiantDTO;
import J.r.meTechnobel.Unma.models.entity.Etudiant;
import J.r.meTechnobel.Unma.models.form.EtudiantForm;
import J.r.meTechnobel.Unma.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantMapper mapper;
    private final EtudiantRepository repository;

    public EtudiantServiceImpl(EtudiantMapper mapper, EtudiantRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<EtudiantDTO> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EtudiantDTO getOne(String numMatricule) {
        return repository.findById(numMatricule).map(mapper::toDto).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public EtudiantDTO insert(EtudiantForm form) {

        if( repository.existsById(form.getNumMatricule()) )
            throw new ElementAlreadyExistsException();

        Etudiant toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDto(toInsert);
    }

    @Override
    public EtudiantDTO delete(String numMatricule) {

        Etudiant toDelete = repository.findById(numMatricule).orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }
}
