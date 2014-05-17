package com.thesischecker.extractor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 * 
 * @author Bartlomiej Sadkiewicz
 */
public class PDFExtractor implements ITextExtractor, IDocumentInformation{

	private PDDocument pdf;
	private PDFTextStripper stripper;
	private PDDocumentInformation info;
	
	/**
	 * Constructor
	 * @param in
	 * @throws TextExtractorException
	 */
	public PDFExtractor(InputStream in) throws TextExtractorException
	{
		try {
			pdf = PDDocument.load(in);
			init();
		} catch (IOException e) {
			throw new TextExtractorException(e);
		}
	}
	
	/**
	 * Constructor
	 * @param file
	 * @throws TextExtractorException
	 */
	public PDFExtractor(File file) throws TextExtractorException
	{
		try {
			pdf = PDDocument.load(file);
			init();
		} catch (IOException e) {
			throw new TextExtractorException(e);
		}
	}
	
	/**
	 * Constructor
	 * @param filename
	 * @throws TextExtractorException
	 */
	public PDFExtractor(String filename) throws TextExtractorException
	{
		
		try {
			pdf = PDDocument.load(filename);
			init();
		} catch (IOException e) {
			throw new TextExtractorException(e);
		}
	}
	
	/**
	 * Initialize properties
	 * @throws IOException
	 */
	private void init() throws IOException
	{
		stripper = new PDFTextStripper();
		info = pdf.getDocumentInformation();
	}
	
	/**
	 * @see com.thesischecker.extractor.ITextExtractor#extract()
	 */
	public String extract() throws TextExtractorException{
		try {
			return stripper.getText(pdf);
		} catch (IOException e) {
			throw new TextExtractorException(e);
		}
	}

	/**
	 * @see com.thesischecker.extractor.IDocumentInformation#getNumberOfPages()
	 */
	public int getNumberOfPages() {
		return pdf.getNumberOfPages();
	}

	/**
	 * @see com.thesischecker.extractor.IDocumentInformation#getTitle()
	 */
	public String getTitle() {
		return info.getTitle();
	}

	/**
	 * @see com.thesischecker.extractor.IDocumentInformation#getAuthor()
	 */
	public String getAuthor() {
		return info.getAuthor();
	}

	/**
	 * @see com.thesischecker.extractor.IDocumentInformation#getSubject()
	 */
	public String getSubject() {
		return info.getSubject();
	}

	/**
	 * @see com.thesischecker.extractor.IDocumentInformation#getCreationDate()
	 */
	public Calendar getCreationDate() throws DocumentInformationException {
		try {
			return info.getCreationDate();
		} catch (IOException e) {
			throw new DocumentInformationException(e);
		}
	}

	/**
	 * @see com.thesischecker.extractor.IDocumentInformation#getModificationDate()
	 */
	public Calendar getModificationDate() throws DocumentInformationException {
		try {
			return info.getModificationDate();
		} catch (IOException e) {
			throw new DocumentInformationException(e);
		}
	}
}
