package uk.co.waleed.Util;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetLatLongTest extends TestCase {

    private GetLatLong latLongLondon = new GetLatLong("London");
    private GetLatLong latLongManchester = new GetLatLong("Manchester");

    @Test
    public void getLatitudeTestLondon() {
        assertEquals("51.4893335",latLongLondon.getLatitude());
    }

    @Test
    public void getLongitudeTestLondon() {
        assertEquals("-0.14405508452768728",latLongLondon.getLongitude());
    }

    @Test
    public void getLatitudeTestManchester() {
        assertEquals("42.9956397",latLongManchester.getLatitude());
    }

    @Test
    public void getLongitudeTestManchester() {
        assertEquals("-71.4547891",latLongManchester.getLongitude());
    }

}