package props;

public enum TestConfig {

    Uri("uri"),
    Path("path");

    public final String value;

    TestConfig(String value) {
        this.value = Configuration.getConfiguration().getProperty(value);
    }
}
