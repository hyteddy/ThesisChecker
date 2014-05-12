package com.thesischecker.test.extractor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.InputStream;

import org.junit.Test;

import com.thesischecker.extractor.IDocumentInformation;
import com.thesischecker.extractor.ITextExtractor;
import com.thesischecker.extractor.PDFExtractor;
import com.thesischecker.extractor.TextExtractorException;

public class PDFExtractorTest {
    
	@Test
	public void readFileFromInputStream() throws TextExtractorException {
		
		InputStream in = getClass().getResourceAsStream("/simplePdf.pdf");
		assertNotNull(in);
		
		ITextExtractor extr = new PDFExtractor(in);
		assertEquals("Simple pdf \r\nSadek \r\ntadek \r\n", extr.extract());
	}
	
	@Test
	public void readFileFromFile() throws TextExtractorException {
		
		File file = new File(getClass().getResource("/simplePdf.pdf").getPath());
		assertNotNull(file);
		
		ITextExtractor extr = new PDFExtractor(file);
		assertEquals("Simple pdf \r\nSadek \r\ntadek \r\n", extr.extract());
	}
	
	@Test
	public void readFileFromFileName() throws TextExtractorException {

		ITextExtractor extr = new PDFExtractor(getClass().getResource("/simplePdf.pdf").getPath());
		assertEquals("Simple pdf \r\nSadek \r\ntadek \r\n", extr.extract());
	}
	
	@Test
	public void getNumberOfPages() throws TextExtractorException {
		
		InputStream in = getClass().getResourceAsStream("/simplePdf2.pdf");
		assertNotNull(in);
		
		IDocumentInformation extr = new PDFExtractor(in);
		assertEquals(4, extr.getNumberOfPages());
	}
}
