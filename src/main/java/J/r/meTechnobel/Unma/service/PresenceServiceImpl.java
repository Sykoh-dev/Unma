package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.mapper.PresenceMapper;
import J.r.meTechnobel.Unma.models.dto.PresenceDTO;
import J.r.meTechnobel.Unma.models.form.PresenceForm;
import J.r.meTechnobel.Unma.repository.PresenceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PresenceServiceImpl implements PresenceService {

    private final PresenceMapper mapper;
    private final PresenceRepository repository;

    public PresenceServiceImpl(PresenceMapper mapper, PresenceRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<PresenceDTO> getAll() {
        return null;
    }

    @Override
    public PresenceDTO getOne(LocalDate date) {
        return null;
    }

    @Override
    public PresenceDTO insert(PresenceForm form) {
        return null;
    }
}
