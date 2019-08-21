/**
 * 
 */
package com.david.mail.emailManager.dto;

/**
 * @author David Parra
 *
 */
public class EmailDto {

    private String nombreReceptor;
    private String estado;
    private String correo;

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
