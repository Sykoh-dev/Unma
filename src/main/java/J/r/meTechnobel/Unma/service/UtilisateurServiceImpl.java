package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.exceptions.models.ElementNotFoundException;
import J.r.meTechnobel.Unma.exceptions.models.RoleInvalidException;
import J.r.meTechnobel.Unma.mapper.UtilisateurMapper;
import J.r.meTechnobel.Unma.models.dto.UtilisateurDTO;
import J.r.meTechnobel.Unma.models.entity.Utilisateur;
import J.r.meTechnobel.Unma.models.form.UtilisateurForm;
import J.r.meTechnobel.Unma.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository repository;
    private final UtilisateurMapper mapper;
    private final PasswordEncoder encoder;

    public UtilisateurServiceImpl(UtilisateurRepository repository, UtilisateurMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername( username )
                .orElseThrow( () -> new UsernameNotFoundException("l'utilisateur avec le username donné n'existe pas") );
    }

    @Override
    public UtilisateurDTO insert(UtilisateurForm form) {
        if( form.getRoles().stream().anyMatch(role -> !role.equals("USER") && !role.equals("ADMIN")) )
            throw new RoleInvalidException();

        Utilisateur toInsert = mapper.formToEntity(form);
        toInsert.setPassword(encoder.encode( form.getPassword() ));
        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public UtilisateurDTO update(long id, UtilisateurForm form) {

        Utilisateur toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        if( form.getRoles().stream().anyMatch(role -> !role.equals("USER") && !role.equals("ADMIN")) )
            throw new RoleInvalidException();

        toUpdate.setUsername( form.getUsername() );
        toUpdate.setPassword( encoder.encode(form.getPassword()) );
        toUpdate.setRoles( form.getRoles() );

        toUpdate = repository.save( toUpdate );

        return mapper.toDTO(toUpdate);
    }

    @Override
    public List<UtilisateurDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
