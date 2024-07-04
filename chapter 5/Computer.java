public class Computer {
    private String name;
    private Configuration config;

    public Computer(String name, Configuration config) {
        this.name = name;
        this.config = config;
    }

    public String getName() {
        return name;
    }

    public Configuration getConfig() {
        return config;
    }

    public static class Configuration {
        private String operatingSystem;
        private String processor;
        private int ram;

        public Configuration(String operatingSystem, String processor, int ram) {
            this.operatingSystem = operatingSystem;
            this.processor = processor;
            this.ram = ram;
        }

        public String getOperatingSystem() {
            return operatingSystem;
        }

        public String getProcessor() {
            return processor;
        }

        public int getRam() {
            return ram;
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", config=" + config +
                '}';
    }
}