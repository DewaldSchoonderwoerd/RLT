package base.web.utls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class WebPropertyUtils {

    private static final Logger LOG = LoggerFactory.getLogger(WebPropertyUtils.class);

    private static Properties webUrlProperties = null;

    static {
        LOG.info(" -- Loading Web properties -- ");
        try {
            webUrlProperties = mandatoryFileLoad(basePath() + "webUrl.properties");
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public static String getWebUrlDetails(String key) {
        return webUrlProperties.getProperty(key);
    }


    public static Properties mandatoryFileLoad(String filePath) throws Exception {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileReader(filePath));
        } catch (Exception e) {
            assert properties != null;
            properties.clear();
            throw new Exception(filePath + " not found");
        }
        return properties;
    }

    private static String basePath() {
        return System.getProperty("user.dir") + "/src/main/resources/";
    }
}