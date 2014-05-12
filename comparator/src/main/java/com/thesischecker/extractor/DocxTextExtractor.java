package com.thesischecker.extractor;

import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Viciu
 *         Component for extracting Text from Docx files.
 */
public class DocxTextExtractor implements ITextExtractor
{

    private POITextExtractor poiTextExtractor;

    /**
     * Creates new instance of DocxTextExtractor
     * with Docx source from given InputStream
     *
     * @param in InputStram with docx file
     */
    public DocxTextExtractor(InputStream in) throws TextExtractorException
    {
        try
        {
            poiTextExtractor = ExtractorFactory.createExtractor(in);
        } catch (IOException e)
        {
            throw new TextExtractorException(e);
        } catch (OpenXML4JException e)
        {
            throw new TextExtractorException(e);
        } catch (XmlException e)
        {
            throw new TextExtractorException(e);
        } catch (IllegalArgumentException e)
        {
            throw new TextExtractorException(e);
        }
    }

    /**
     * Creates new instance of DocxTextExtractor
     * with Docx source from given InputStream
     *
     * @param f Docx file
     */
    public DocxTextExtractor(File f) throws TextExtractorException
    {
        try
        {
            poiTextExtractor = ExtractorFactory.createExtractor(new FileInputStream(f));
        } catch (IOException e)
        {
            throw new TextExtractorException(e);
        } catch (OpenXML4JException e)
        {
            throw new TextExtractorException(e);
        } catch (XmlException e)
        {
            throw new TextExtractorException(e);
        } catch (IllegalArgumentException e)
        {
            throw new TextExtractorException(e);
        }
    }

    /**
     * @see com.thesischecker.extractor.ITextExtractor#extract()
     */
    @Override
    public String extract() throws TextExtractorException
    {
        return poiTextExtractor.getText();
    }
}