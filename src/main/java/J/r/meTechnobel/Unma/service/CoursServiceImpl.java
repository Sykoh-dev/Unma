package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.exceptions.models.ElementAlreadyExistsException;
import J.r.meTechnobel.Unma.exceptions.models.ElementNotFoundException;
import J.r.meTechnobel.Unma.mapper.CoursMapper;
import J.r.meTechnobel.Unma.models.dto.CoursDTO;
import J.r.meTechnobel.Unma.models.entity.Cours;
import J.r.meTechnobel.Unma.models.form.CoursForm;
import J.r.meTechnobel.Unma.repository.CoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursServiceImpl implements CoursService {

    private final CoursMapper mapper;
    private final CoursRepository repository;

    public CoursServiceImpl(CoursMapper mapper, CoursRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<CoursDTO> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CoursDTO getOne(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public CoursDTO insert(CoursForm form) {

        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        Cours toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDto(toInsert);
    }

    @Override
    public CoursDTO delete(Long id) {

        Cours toDelete = repository.findById(id).orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }
}
