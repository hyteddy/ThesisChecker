package com.thesischecker.extractor;

import java.util.Calendar;

/**
 * Document inforomation interface
 * @author Bartlomiej Sadkiewicz
 */
public interface IDocumentInformation {
	/**
	 * @return Number of pages
	 */
	public int getNumberOfPages();
	/**
	 * @return Document title
	 */
	public String getTitle();
	/**
	 * @return Document author
	 */
	public String getAuthor();
	/**
	 * @return Document subject
	 */
	public String getSubject();
	/**
	 * @return Creation date of document
	 * @throws DocumentInformationException
	 */
	public Calendar getCreationDate() throws DocumentInformationException;
	/**
	 * @return Modification date of document
	 * @throws DocumentInformationException
	 */
	public Calendar getModificationDate() throws DocumentInformationException;
}
