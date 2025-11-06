package config;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public final class TestConfig {
    private static final Properties P = new Properties();

    static {
        loadFromClasspath("test.properties");
        overrideWithSystemProps();
        overrideWithEnv();
    }

    private TestConfig() {
    }

    private static void loadFromClasspath(String name) {
        try (InputStream is = TestConfig.class.getClassLoader().getResourceAsStream(name)) {
            if (is == null) throw new IllegalStateException(name + " not found on classpath");
            P.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load " + name, e);
        }
    }

    private static void overrideWithSystemProps() {
        for (Map.Entry<Object, Object> e : System.getProperties().entrySet()) {
            String k = String.valueOf(e.getKey());
            String v = String.valueOf(e.getValue());
            if (P.containsKey(k)) P.setProperty(k, v);
        }
    }

    private static void overrideWithEnv() {
        for (Map.Entry<String, String> e : System.getenv().entrySet()) {
            String key = toPropKey(e.getKey());
            if (P.containsKey(key)) P.setProperty(key, e.getValue());
        }
    }

    private static String toPropKey(String envKey) {
        return envKey.toLowerCase().replace('_', '.'); // BASE_URL -> base.url
    }

    public static String baseUrl() {
        return normalizeUrl(req("baseUrl"));
    }

    private static String req(String key) {
        String v = P.getProperty(key);
        if (v == null || v.isBlank())
            throw new IllegalStateException("Required property '" + key + "' is missing or blank");
        return v;
    }

    private static String opt(String key, String def) {
        String v = P.getProperty(key);
        return (v == null || v.isBlank()) ? def : v.trim();
    }

    private static int intOpt(String key, int def) {
        String v = P.getProperty(key);
        if (v == null || v.isBlank()) return def;
        try {
            return Integer.parseInt(v.trim());
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Property '" + key + "' must be int, got: " + v);
        }
    }

    private static String normalizeUrl(String url) {
        return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }
}
