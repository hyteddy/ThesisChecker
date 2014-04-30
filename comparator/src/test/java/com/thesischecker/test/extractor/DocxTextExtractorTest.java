package com.thesischecker.test.extractor;

import com.thesischecker.extractor.DocxTextExtractor;
import com.thesischecker.extractor.TextExtractorException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author Viciu
 *         Test suite for DocxTextExtractor
 */
public class DocxTextExtractorTest
{

    @Test
    public void testExtractHelloWorld()
    {
        String resourceInputFile = "/HelloWorld.docx";
        String expected = "Hello World\n";
        URL url = this.getClass().getResource(resourceInputFile);
        Assert.assertNotNull("Can't find resource " + resourceInputFile, url);
        InputStream inputStream = null;
        try
        {
            inputStream = url.openStream();
        } catch (IOException e)
        {
            Assert.fail("Ünexpected Exception accessing test resources");
        }
        String text;
        try
        {
            DocxTextExtractor extractor = new DocxTextExtractor(inputStream);
            text = extractor.extract();
            Assert.assertEquals(text, expected);
        } catch (TextExtractorException e)
        {
            Assert.fail("Ünexpected Exception");
        }
    }

    @Test
    public void testExtractEmpty()
    {
        String resourceInputFile = "/Empty.docx";
        String expected = "\n";
        URL url = this.getClass().getResource(resourceInputFile);
        Assert.assertNotNull("Can't find resource " + resourceInputFile, url);
        InputStream inputStream = null;
        try
        {
            inputStream = url.openStream();
        } catch (IOException e)
        {
            Assert.fail("Ünexpected Exception accessing test resources");
        }
        String text;
        try
        {
            DocxTextExtractor extractor = new DocxTextExtractor(inputStream);
            text = extractor.extract();
            Assert.assertEquals(text, expected);
        } catch (TextExtractorException e)
        {
            Assert.fail("Ünexpected Exception");
        }
    }

    @Test
    public void testExtractComplex()
    {
        String resourceInputFile = "/Complex.docx";
        String expected = "Klasyfikacja systemów procesów dyskretnych.\n\n"
                + "F - System przepływowy. Każde zadanie przetwarzane jest przez zbiór maszyn w ściśle określonym porządku, identycznym dla wszystkich zadań. Zadania wymagają obsługi na wszystkich maszynach, a każda z maszyn wymaga określenia odpowiedniej kolejności wprowadzania zadań.\n"
                + "PF - System przepływowy permutacyjny. Złożenia są takie same jak dla systemu typu F z dodatkowym wymaganiem, aby kolejność (permutacja) wykonywania zadań na wszystkich maszynach była taka sama, zgodna z kolejnością wprowadzania zadań do systemu.\n"
                + "O - System otwarty. Każde zadanie przetwarzane jest przez zbiór maszyn, zarówno kolejność przetwarzania każdego z zadań na poszczególnych maszynach jak i sekwencja przetwarzania kolejnych zadań przez każdą z maszyn mogą być dowolne.\n"
                + "J – system ogólny gniazdowy. Każde zadanie przetwarzane jest przez zbiór maszyn w ściśle określonym porządku, który może być odmienny dla każdego zadań; konkretna maszyna może przetwarzać zadania w dowolnej kolejności.\n"
                + "G – system ogólny. Każde zadanie jest pojedynczą czynnością, zależności między nimi są zadane dowolnym grafem.\n"
                + "P – system z równoległymi maszynami. Każde zadanie może być wykonywane na dokładnie jednej z kilku równoległych maszyn.\n\n";
        URL url = this.getClass().getResource(resourceInputFile);
        Assert.assertNotNull("Can't find resource " + resourceInputFile, url);
        InputStream inputStream = null;
        try
        {
            inputStream = url.openStream();
        } catch (IOException e)
        {
            Assert.fail("Ünexpected Exception accessing test resources");
        }
        String text;
        try
        {
            DocxTextExtractor extractor = new DocxTextExtractor(inputStream);
            text = extractor.extract();
            Assert.assertEquals(text, expected);
        } catch (TextExtractorException e)
        {
            Assert.fail("Ünexpected Exception");
        }
    }

    @Test
    public void testExtractInvalidType()
    {
        String resourceInputFile = "/simplePdf.pdf";
        URL url = this.getClass().getResource(resourceInputFile);
        Assert.assertNotNull("Can't find resource " + resourceInputFile, url);
        InputStream inputStream = null;
        try
        {
            inputStream = url.openStream();
        } catch (IOException e)
        {
            Assert.fail("Ünexpected Exception accessing test resources");
        }
        String text;
        try
        {
            DocxTextExtractor extractor = new DocxTextExtractor(inputStream);
            text = extractor.extract();
            Assert.fail("Exception was Expected" + text);
        } catch (TextExtractorException e)
        {
            //success
        }
    }

    @Test
    public void testExtractNull()
    {
        InputStream inputStream = null;
        try
        {
            DocxTextExtractor extractor = new DocxTextExtractor(inputStream);
            extractor.extract();
            Assert.fail("Exception Expected");
        } catch (NullPointerException e)
        {
            //success
        } catch (TextExtractorException e)
        {
            Assert.fail("Ünexpected Exception");
        }
    }

}
