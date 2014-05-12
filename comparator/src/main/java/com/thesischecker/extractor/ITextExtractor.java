package com.thesischecker.extractor;

/**
 * Text extractor interface
 * @author Bartlomiej Sadkiewicz
 */
public interface ITextExtractor {
	/**
	 * 
	 * @return Extract plain text from file
	 * @throws TextExtractorException
	 */
	public String extract() throws TextExtractorException;
}
