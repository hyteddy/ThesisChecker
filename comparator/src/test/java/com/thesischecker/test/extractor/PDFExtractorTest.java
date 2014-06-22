package com.thesischecker.test.extractor;

import com.thesischecker.extractor.IDocumentInformation;
import com.thesischecker.extractor.ITextExtractor;
import com.thesischecker.extractor.PDFExtractor;
import com.thesischecker.extractor.TextExtractorException;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PDFExtractorTest {

    private static final String lf=System.getProperty("line.separator");

	@Test
	public void readFileFromInputStream() throws TextExtractorException {
		
		InputStream in = getClass().getResourceAsStream("/simplePdf.pdf");
		assertNotNull(in);
		
		ITextExtractor extr = new PDFExtractor(in);
		assertEquals("Simple pdf "+lf+"Sadek "+lf+"tadek "+lf, extr.extract());
	}
	
	@Test
	public void readFileFromFile() throws TextExtractorException {
		
		File file = new File(getClass().getResource("/simplePdf.pdf").getPath());
		assertNotNull(file);
		
		ITextExtractor extr = new PDFExtractor(file);
		assertEquals("Simple pdf "+lf+"Sadek "+lf+"tadek "+lf, extr.extract());
	}
	
	@Test
	public void readFileFromFileName() throws TextExtractorException {

		ITextExtractor extr = new PDFExtractor(getClass().getResource("/simplePdf.pdf").getPath());
		assertEquals("Simple pdf "+lf+"Sadek "+lf+"tadek "+lf, extr.extract());
	}
	
	@Test
	public void getNumberOfPages() throws TextExtractorException {
		
		InputStream in = getClass().getResourceAsStream("/simplePdf2.pdf");
		assertNotNull(in);
		
		IDocumentInformation extr = new PDFExtractor(in);
		assertEquals(4, extr.getNumberOfPages());
	}
}
