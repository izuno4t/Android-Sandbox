package example.myapplication;

import junit.framework.Assert;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by izuno on 15/07/30.
 */
@RunWith(CustomRobolectricRunner.class)
@Config(constants = BuildConfig.class)
public class ResourceUtilsTest {

    @Before
    public void before() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        System.out.println(ToStringBuilder.reflectionToString(cl, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println("Resource Path=" + cl.getResource("").getPath());
        System.out.println("Resource Path=" + cl.getParent().getResource("").getPath());
        System.out.println("Resource Path=" + MainActivity.class.getResource("").getPath() + "../../");

        String pathString = MainActivity.class.getResource("").getPath();


        System.out.println("Resource Path=");


    }

    @Test
    public void testLoadResourceFile() throws IOException {


        final Properties prop = new Properties();
        InputStream inStream = null;
        try {
            inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
            prop.load(inStream);
        } catch (IOException e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(inStream);
        }

        Assert.assertEquals("Android-Sandbox", prop.getProperty("name"));

        // test-resource
        try {
            inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config-test.properties");
            prop.load(inStream);
        } catch (IOException e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(inStream);
        }

        Assert.assertEquals("Android-Sandbox-Test", prop.getProperty("name"));


    }


}