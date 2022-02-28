package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.exceptions.models.ElementAlreadyExistsException;
import J.r.meTechnobel.Unma.exceptions.models.ElementNotFoundException;
import J.r.meTechnobel.Unma.mapper.AdministrationMapper;
import J.r.meTechnobel.Unma.models.dto.AdministrationDTO;
import J.r.meTechnobel.Unma.models.entity.Administration;
import J.r.meTechnobel.Unma.models.form.AdministrationForm;
import J.r.meTechnobel.Unma.repository.AdministrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministrationServiceImpl implements AdministrationService {


    private final AdministrationMapper mapper;
    private final AdministrationRepository repository;

    public AdministrationServiceImpl(AdministrationMapper mapper, AdministrationRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<AdministrationDTO> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AdministrationDTO getOne(String numMatricule) {
        return repository.findById(numMatricule).map(mapper::toDto).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public AdministrationDTO insert(AdministrationForm form) {

        if( repository.existsById(form.getNumMatricule()) )
            throw new ElementAlreadyExistsException();

        Administration toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDto(toInsert);
    }

    @Override
    public AdministrationDTO delete(String numMatricule) {

        Administration toDelete = repository.findById(numMatricule).orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }
}
