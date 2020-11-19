package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {

    Enseignant untel;
    UE uml, java;

    @BeforeEach
    public void setUp() {
        untel = new Enseignant("untel", "untel@gmail.com");
        uml = new UE("UML");
        java = new UE("Programmation en java");
    }

    @Test
    public void testNouvelEnseignantSansService() {
        assertEquals(0, untel.heuresPrevues(),
                "Un nouvel enseignant doit avoir 0 heures prévues");
    }

    @Test
    public void testAjouteHeures() {
        // 10h TD pour UML
        untel.ajouteEnseignement(uml, 0, 10, 0);

        assertEquals(10, untel.heuresPrevuesPourUE(uml),
                "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

        // 20h TD pour UML
        untel.ajouteEnseignement(uml, 0, 20, 0);

        assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

    }

    @Test
    public void testHeuresPrevues() {
        untel.ajouteEnseignement(uml, 1, 1, 1);
        untel.ajouteEnseignement(java, 1, 1, 1);

        assertEquals(4, untel.heuresPrevues(), "l'enseignant doit realiser 4h");
    }

    @Test
    public void testHeuresPlanifiees() {
        Salle s = new Salle("B8", 30);
        Intervention e1 = new Intervention(new Date(), 2, TypeIntervention.TD, s, uml);
        Intervention e2 = new Intervention(new Date(), 2, TypeIntervention.TP, s, uml);
        
        untel.ajouteIntervention(e1);
        untel.ajouteIntervention(e2);
        
        assertEquals(3, untel.heuresPlanifiees(),"L'enseigant doit réaliser 3h" );
    }
    
    @Test
    public void testEnSousService(){
        untel.ajouteEnseignement(uml, 1, 1, 1);
        assertEquals(true, untel.enSousService(), "L'enseignant doit être en sous service");
        untel.ajouteEnseignement(uml, 155, 63, 48);
        assertEquals(false, untel.enSousService(), "L'enseignant ne doit pas être en sous service");
        
    }
}
