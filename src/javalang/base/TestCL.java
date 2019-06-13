package javalang.base;

/**
 * created on 2018/12/23
 *
 * @author J
 **/
public class TestCL extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
