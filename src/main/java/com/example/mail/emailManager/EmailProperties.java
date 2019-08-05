/**
 * 
 */
package com.example.mail.emailManager;

/**
 * @author David Parra
 *
 */
public class EmailProperties {

	private String host;
	private String port;
	private String emailEmisor;
	private String contrasenaEmailEmisor;
	private boolean requiereAutenticacion;

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the emailEmisor
	 */
	public String getEmailEmisor() {
		return emailEmisor;
	}

	/**
	 * @param emailEmisor the emailEmisor to set
	 */
	public void setEmailEmisor(String emailEmisor) {
		this.emailEmisor = emailEmisor;
	}

	/**
	 * @return the contrasenaEmailEmisor
	 */
	public String getContrasenaEmailEmisor() {
		return contrasenaEmailEmisor;
	}

	/**
	 * @param contrasenaEmailEmisor the contrasenaEmailEmisor to set
	 */
	public void setContrasenaEmailEmisor(String contrasenaEmailEmisor) {
		this.contrasenaEmailEmisor = contrasenaEmailEmisor;
	}

	/**
	 * @return the requiereAutenticacion
	 */
	public boolean isRequiereAutenticacion() {
		return requiereAutenticacion;
	}

	/**
	 * @param requiereAutenticacion the requiereAutenticacion to set
	 */
	public void setRequiereAutenticacion(boolean requiereAutenticacion) {
		this.requiereAutenticacion = requiereAutenticacion;
	}
	
	

}
