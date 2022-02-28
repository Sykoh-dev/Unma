package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.models.dto.LoginSuccesDTO;
import J.r.meTechnobel.Unma.models.entity.Utilisateur;
import J.r.meTechnobel.Unma.models.form.LoginForm;
import J.r.meTechnobel.Unma.repository.UtilisateurRepository;
import J.r.meTechnobel.Unma.security.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl {

    private final UtilisateurRepository uRep;
    private final AuthenticationManager auth;
    private final JwtProvider jwtProvider;

    public SessionServiceImpl(UtilisateurRepository uRep, AuthenticationManager auth, JwtProvider jwtProvider) {
        this.uRep = uRep;
        this.auth = auth;
        this.jwtProvider = jwtProvider;
    }

    public LoginSuccesDTO login(LoginForm form){

        Utilisateur user = uRep.findByUsername(form.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("l'utilisateur n'existe pas"));
        // creer l'authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(),form.getPassword());
        // tester l'authentication
        auth.authenticate( authentication );

        // -> ok : creer token et le renvoyer
        return LoginSuccesDTO.builder()
                .jwt(jwtProvider.createToken(user.getUsername(), user.getRoles()))
                .username(user.getUsername())
                .build();

    }

}
