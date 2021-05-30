package dullbird.spring.demo.ioc;

/**
 * @author : cys
 * date: 2021-05-09 20:25
 */
public class RealBean {

    public RealBean(String version) {
        System.out.println("================== start bean init ==================");
        this.version = version;
    }

    public RealBean() {
        System.out.println("================== start bean init ==================");
    }

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "RealBean{" +
                "version='" + version + '\'' +
                '}';
    }
}