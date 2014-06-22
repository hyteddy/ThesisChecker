package com.thesischecker.test.comparator;

import com.thesischecker.comparator.Analysis;
import com.thesischecker.comparator.AnalysisHTMLConverter;
import com.thesischecker.comparator.DiffMatchPatchComparator;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AnalysisHTMLConverterTest
{

    String testFile1 = "/test1.txt";
    String testFile2 = "/test2.txt";

    @Test
    public void testConversion() throws IOException
    {
        URL url1 = this.getClass().getResource(testFile1);
        URL url2 = this.getClass().getResource(testFile2);
        String s1 = readFile(url1.openStream());
        String s2 = readFile(url2.openStream());
        DiffMatchPatchComparator dmpc = new DiffMatchPatchComparator();
        Analysis analysis = dmpc.compare(s1, s2);
        AnalysisHTMLConverter converter = new AnalysisHTMLConverter();
        converter.setAnalysis(analysis);
//		System.out.println(converter.getLeft());
//		System.out.println(converter.getRight());

        //check if equal lines are at the same indexes
        String[] left = converter.getLeft().split("<br>");
        String[] right = converter.getRight().split("<br>");
        for(int i=0;i<left.length;i++)
            if(left[i].startsWith("<div class=\"equal\""))
                assertEquals(left[i], right[i]);
    }

    public static String readFile(InputStream in)
    {
        Scanner scanner = new Scanner(in);
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();
        return text;
    }

}

