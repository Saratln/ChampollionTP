/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author Sara Toulon
 */
public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private TypeIntervention type;
    private Salle s;
   private UE u;

    public Intervention(Date debut, int duree, TypeIntervention type, Salle s, UE u) {
        this.debut = debut;
        this.duree = duree;
        this.type = type;
        this.s = s;
        this.u = u;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }

    public Salle getS() {
        return s;
    }

    public void setS(Salle s) {
        this.s = s;
    }

    public UE getU() {
        return u;
    }

    public void setU(UE u) {
        this.u = u;
    }
   
   
    
    
}
