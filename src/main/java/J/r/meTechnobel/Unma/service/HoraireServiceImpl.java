package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.exceptions.models.ElementAlreadyExistsException;
import J.r.meTechnobel.Unma.exceptions.models.ElementNotFoundException;
import J.r.meTechnobel.Unma.exceptions.models.InvalidTimesException;
import J.r.meTechnobel.Unma.mapper.HoraireMapper;
import J.r.meTechnobel.Unma.models.dto.HoraireDTO;

import J.r.meTechnobel.Unma.models.entity.Cours;
import J.r.meTechnobel.Unma.models.entity.Horaire;
import J.r.meTechnobel.Unma.models.entity.Professeur;
import J.r.meTechnobel.Unma.models.form.CoursForm;
import J.r.meTechnobel.Unma.models.form.HoraireForm;
import J.r.meTechnobel.Unma.models.form.HoraireUpdateForm;
import J.r.meTechnobel.Unma.repository.CoursRepository;
import J.r.meTechnobel.Unma.repository.HoraireRepository;
import J.r.meTechnobel.Unma.repository.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HoraireServiceImpl implements  HoraireService {

    private final HoraireMapper mapper;
    private final HoraireRepository repository;
    private final ProfesseurRepository professeurRepository;
    private final CoursRepository coursRepository;

    public HoraireServiceImpl(HoraireMapper mapper, HoraireRepository repository, ProfesseurRepository professeurRepository, CoursRepository coursRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.professeurRepository = professeurRepository;
        this.coursRepository = coursRepository;
    }

    @Override
    public List<HoraireDTO> getAll() {
        return repository.findAllHoraire()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public HoraireDTO getOne(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public HoraireDTO insert(HoraireForm form) {



        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

//        if(!form.getHeureDebut().isBefore(form.getHeureFin()))
//            throw new InvalidTimesException(form.getHeureDebut(), form.getHeureFin());

        Horaire toInsert = mapper.formToEntity(form);
        Set<Cours> cours = form.getCours().stream().map(coursform -> coursRepository.findById(coursform.getId()).orElseThrow(ElementNotFoundException::new)).collect(Collectors.toSet());

        Set<Professeur> professeurs = form.getProfesseurs().stream().map(professeurForm -> professeurRepository.findById(professeurForm.getNumMatricule()).orElseThrow(ElementNotFoundException::new)).collect(Collectors.toSet());
        toInsert.setCours(cours);
        toInsert.setProfesseurs(professeurs);
        toInsert = repository.save(toInsert);
        return mapper.toDto(toInsert);
    }

    @Override
    public HoraireDTO delete(Long id) {

        Horaire toDelete = repository.findById(id).orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }

    @Override
    public HoraireDTO update(Long id, HoraireUpdateForm form) {
        return null;
    }
}
