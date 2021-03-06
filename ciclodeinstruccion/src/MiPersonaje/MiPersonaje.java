/**
 * Clase de la que heredan miasesino, mifighter y mitanque
 */
package MiPersonaje;

public abstract class MiPersonaje implements MiPersonajeable,Comparable <MiPersonaje>{
    private float bonusVida;
    private float bonusDaño;
    private int nivel;
    private int experiencia;
    private int puntosNivel;
    private final int AUMENTA_VIDA=10;//cantidad de vida que se aumenta al subir un punto la vida
    private final int AUMENTA_DAÑO=5;//cantidad de daño que se aumenta al subir un punto el daño
    private final int EXPERIENCIA_NECESARIA=1000;

    public MiPersonaje(float bonusVida, float bonusDaño, int nivel, int experiencia, int puntosNivel) {
        this.bonusVida = bonusVida;
        this.bonusDaño = bonusDaño;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.puntosNivel=puntosNivel;
    }
    public void aumentarExperiencia(int sumaExperiencia){
        experiencia+=sumaExperiencia;
        if (experiencia>=EXPERIENCIA_NECESARIA*nivel){         
            experiencia=experiencia - EXPERIENCIA_NECESARIA * nivel;
            this.subeNivel();
        }
    }
    public void gastarPuntosNivel(){
        this.puntosNivel--;
    }
    public void aumentarPuntosNivel(){
        this.puntosNivel++;
    }
    public void aumentarBonusVida(){
        this.bonusVida+=AUMENTA_VIDA;
        this.gastarPuntosNivel();
    }
    public void disminuirBonusVida(){
        this.bonusVida-=AUMENTA_VIDA;
        puntosNivel++;
    }
    public void aumentarBonusDaño(){
        this.bonusDaño+=AUMENTA_DAÑO;
        this.gastarPuntosNivel();
    }
    public void disminuirBonusDaño(){
        this.bonusDaño-=AUMENTA_DAÑO;
        puntosNivel++;
    }
    public void subeNivel(){
        nivel++;
        puntosNivel++;
    }
    public float getBonusVida() {
        return bonusVida;
    }

    public float getBonusDaño() {
        return bonusDaño;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getPuntosNivel() {
        return puntosNivel;
    }

    public void setBonusVida(float bonusVida) {
        this.bonusVida = bonusVida;
    }

    public void setBonusDaño(float bonusDaño) {
        this.bonusDaño = bonusDaño;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setPuntosNivel(int puntosNivel) {
        this.puntosNivel = puntosNivel;
    }
    
    @Override
    public int compareTo(MiPersonaje p) {
        return this.getNombre().compareTo(p.getNombre());
    }
    
    
    
    
}
