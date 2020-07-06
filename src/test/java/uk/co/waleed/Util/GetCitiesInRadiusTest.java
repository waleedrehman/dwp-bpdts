package uk.co.waleed.Util;

import junit.framework.TestCase;
//import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetCitiesInRadiusTest extends TestCase {

    @Test
    public void getDataLondon() throws IOException {
        GetCitiesInRadius getCitiesInRadius = new GetCitiesInRadius("London", 50);
        Path fileName = Path.of("src/test/java/uk/co/waleed/Util/Resources/xmlDataLondon.txt");
        String xmlDataLondon = Files.readString(fileName);
        assertEquals(getCitiesInRadius.getData(),xmlDataLondon);
    }

    @Test
    public void getDataManchester() throws IOException {
        GetCitiesInRadius getCitiesInRadius = new GetCitiesInRadius("Manchester", 50);
        Path fileName = Path.of("src/test/java/uk/co/waleed/Util/Resources/xmlDataManchester.txt");
        String xmlDataManchester = Files.readString(fileName);
        assertEquals(getCitiesInRadius.getData(),xmlDataManchester);
    }
}