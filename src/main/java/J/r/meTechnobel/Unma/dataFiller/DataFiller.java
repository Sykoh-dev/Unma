package J.r.meTechnobel.Unma.dataFiller;

import J.r.meTechnobel.Unma.models.entity.*;
import J.r.meTechnobel.Unma.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Component
public class DataFiller implements InitializingBean {



    private final HoraireRepository repository;
    private final UtilisateurRepository repositoryUser;
    private final PasswordEncoder encoder;
    private final CoursRepository repositoryCours;
    private final ProfesseurRepository  professeurRepository;
    private final EtudiantRepository etudiantRepository;
    private final AdministrationRepository administrationRepository;

    public DataFiller(HoraireRepository repository, UtilisateurRepository repositoryUser, PasswordEncoder encoder, CoursRepository repositoryCours, ProfesseurRepository professeurRepository, EtudiantRepository etudiantRepository, AdministrationRepository administrationRepository) {
        this.repository = repository;
        this.repositoryUser = repositoryUser;
        this.encoder = encoder;

        this.repositoryCours = repositoryCours;
        this.professeurRepository = professeurRepository;
        this.etudiantRepository = etudiantRepository;
        this.administrationRepository = administrationRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {


//        methodUtilisateur();
//        methodAdmin();
//        Cours cours1 = methodCours("Angular");
//        Cours cours2 = methodCours("Java");
//        Cours cours3 = methodCours("Algo");
//        Professeur prof1 = methodProf("prof001","123","Albert","Roberto","prof1","pass", "PROFESSEUR");
//        Professeur prof2 = methodProf("prof002","123","Jhon","Wick","prof2","pass", "PROFESSEUR");
//        Professeur prof3 = methodProf("prof003","123","Bruce","Wilis","prof3","pass", "PROFESSEUR");
//        methodHoraire(cours1, prof1);
//        methodHoraire(cours2, prof2);
//        methodHoraire(cours3, prof3);
//        Etudiant etudiant1 = methodEtudiant("etu001","123","Nick","Larson","etudiant1","pass", "ETUDIANT");
//        Administration administration1 = methodAdministration("secret001","123","Alfonse","Capone","secretaire1","pass", "ADMIN");
    }

    public Horaire methodHoraire(Cours cours, Professeur prof){
        Horaire horaire = new Horaire();
        horaire.setNomFiliere("Info");
        horaire.setHeureDebut(LocalTime.now());
        horaire.setHeureFin(LocalTime.now());
        horaire.setDate(LocalDate.now());
        horaire.setCours(Set.of(cours));
        horaire.setProfesseurs(Set.of(prof));
        return repository.save(horaire);
    }



    public Utilisateur methodAdmin(){
        Utilisateur admin = new Utilisateur();
        admin.setUsername("admin");
        admin.setPassword(encoder.encode("pass"));
        admin.setRoles(List.of("AdminGlobal"));
        admin.setEnabled(true);
        admin.setAccountNonLocked(true);
        admin.setAccountNonExpired(true);
        admin.setCredentialsNonExpired(true);
        admin.setNumMatricule("Admin001");
        return repositoryUser.save(admin);

    }

    public Cours methodCours(String intitule){
        Cours cours = new Cours();
        cours.setIntitule(intitule);
        return repositoryCours.save(cours);
    }

    public Professeur methodProf(String matricule, String adresse, String prenom, String nom, String username, String password, String role){
        Professeur prof = new Professeur();
        prof.setNumMatricule(matricule);
        prof.setAdresse(adresse);
        prof.setPrenom(prenom);
        prof.setNom(nom);
        prof.setUsername(username);
        prof.setPassword(encoder.encode(password));
        prof.setAccountNonExpired(true);
        prof.setCredentialsNonExpired(true);
        prof.setAccountNonLocked(true);
        prof.setEnabled(true);
        prof.setRoles(List.of(role));
        return professeurRepository.save(prof);
    }

    public Etudiant methodEtudiant(String matricule, String adresse, String prenom, String nom, String username, String password, String role){
        Etudiant etudiant = new Etudiant();
        etudiant.setNumMatricule(matricule);
        etudiant.setAdresse(adresse);
        etudiant.setPrenom(prenom);
        etudiant.setNom(nom);
        etudiant.setUsername(username);
        etudiant.setPassword(encoder.encode(password));
        etudiant.setAccountNonExpired(true);
        etudiant.setCredentialsNonExpired(true);
        etudiant.setAccountNonLocked(true);
        etudiant.setEnabled(true);
        etudiant.setRoles(List.of(role));
        return etudiantRepository.save(etudiant);
    }

    public Administration methodAdministration(String matricule, String adresse, String prenom, String nom, String username, String password, String role){
        Administration administration = new Administration();
        administration.setNumMatricule(matricule);
        administration.setAdresse(adresse);
        administration.setPrenom(prenom);
        administration.setNom(nom);
        administration.setUsername(username);
        administration.setPassword(encoder.encode(password));
        administration.setAccountNonExpired(true);
        administration.setCredentialsNonExpired(true);
        administration.setAccountNonLocked(true);
        administration.setEnabled(true);
        administration.setRoles(List.of(role));
        return administrationRepository.save(administration);
    }

    }
