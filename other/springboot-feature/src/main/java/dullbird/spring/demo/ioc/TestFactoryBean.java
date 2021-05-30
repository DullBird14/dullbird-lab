package dullbird.spring.demo.ioc;

import lombok.SneakyThrows;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.ClassUtils;

/**
 * @author : cys
 * date: 2021-05-09 20:22
 */
public class TestFactoryBean implements FactoryBean, InitializingBean {
    private RealBeanBuilder realBeanBuilder = new RealBeanBuilder();
    private String interfaceName = null;
    @Override
    public Object getObject() throws Exception {
        return realBeanBuilder.createRealBean();
    }

    @SneakyThrows
    @Override
    public Class<?> getObjectType() {
        try {
            return interfaceName == null ? null : ClassUtils.forName(interfaceName, Thread.currentThread().getContextClassLoader());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void init() throws Exception {
        realBeanBuilder.init();
    }


    public void setVersion(String version) {
        realBeanBuilder.setVersion(version);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
}