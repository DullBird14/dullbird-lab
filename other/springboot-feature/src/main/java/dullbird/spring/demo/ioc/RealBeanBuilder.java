package dullbird.spring.demo.ioc;

/**
 * @author : cys
 * date: 2021-05-09 20:26
 */
public class RealBeanBuilder {
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public RealBean createRealBean() {
        return new RealBean(version);
    }

    public void init() {
        System.out.println("=================== do RealBeanBuilder init ===================");
    }
}