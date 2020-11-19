package champollion;

import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    List<ServicePrevu> serviceprevu = new ArrayList<>();
    List<Intervention> interventions = new LinkedList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures
     * équivalent TD" Pour le calcul : 1 heure de cours magistral vaut 1,5 h
     * "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut
     * 0,75h "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int equivalentTD = 0;
        for (ServicePrevu s : serviceprevu) {
            equivalentTD += 1.5 * s.getVolumeCM();
            equivalentTD += s.getVolumeTD();
            equivalentTD += 0.75 * s.getVolumeTP();
            
            round(equivalentTD);
        }
        return equivalentTD;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE
     * spécifiée en "heures équivalent TD" Pour le calcul : 1 heure de cours
     * magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent
     * TD" 1 heure de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public long heuresPrevuesPourUE(UE ue) {
        int heuresequivalentTD = 0;
        for (ServicePrevu s : serviceprevu) {
            if (s.getUe() == ue) {
                heuresequivalentTD += 1.5 * s.getVolumeCM();
                heuresequivalentTD += s.getVolumeTD();
                heuresequivalentTD += 0.75 * s.getVolumeTP();
                round(heuresequivalentTD);
            }
        }
        return heuresequivalentTD;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu nouveauService = new ServicePrevu(this, ue, volumeCM, volumeTD, volumeTD);
        serviceprevu.add(nouveauService);
    }

    public int heuresPlanifiees() {
        int heuresplanif = 0;

        for (int i = 0; i < interventions.size(); i++) {
            switch (interventions.get(i).getType()) {
                case CM:
                    heuresplanif += interventions.get(i).getDuree() * 1.5;
                    break;
                case TD:
                    heuresplanif += interventions.get(i).getDuree();
                    break;
                case TP:
                    heuresplanif += interventions.get(i).getDuree() * 0.75;
                    break;
                default:
                    break;
            }
        }
        return round(heuresplanif);

    }

    public boolean enSousService() {
        if (this.heuresPlanifiees() >= 192) {
            return false;
        } else {
            return true;
        }
    }
    public void ajouteIntervention(Intervention e) {
        interventions.add(e);
    }
}
