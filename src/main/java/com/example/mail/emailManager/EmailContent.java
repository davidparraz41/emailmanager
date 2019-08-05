/**
 * 
 */
package com.example.mail.emailManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Parra
 *
 */
public class EmailContent {

	private String[] to;
	private String subject;
	private String contentHtml;
	private List<File> files = new ArrayList<>();

	/**
	 * @return the to
	 */
	public String[] getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String[] to) {
		this.to = to;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the contentHtml
	 */
	public String getContentHtml() {
		return contentHtml;
	}

	/**
	 * @param contentHtml the contentHtml to set
	 */
	public void setContentHtml(String contentHtml) {
		this.contentHtml = contentHtml;
	}

	/**
	 * @return the files
	 */
	public List<File> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<File> files) {
		this.files = files;
	}

}
