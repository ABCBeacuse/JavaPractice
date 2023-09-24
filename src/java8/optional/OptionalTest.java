package java8.optional;

import java8.methodquote.Employee;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Optional 对象测试
 */
public class OptionalTest {

    @Test
    void test() {
        Employee employee = new Employee();
        // employee = null; 写了这句代码后，下面会抛出 NLP 空指针异常
        // of(T t)：保证 T 非空
        Optional<Employee> optional = Optional.of(employee);
        System.out.println(optional);
        // Optional[Employee{id=null, name='null', age=null, salary=null}]
    }

    @Test
    void test1() {
        Employee employee = new Employee();
        // ofNullable(T t)：t 可以为 null
        Optional<Employee> optionalEmployee = Optional.ofNullable(employee);
        System.out.println(optionalEmployee);
        // Optional[Employee{id=null, name='null', age=null, salary=null}]

        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o);
        // Optional.empty
    }

    @Test
    void test2() {
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        // Optional.empty
    }

    /**
     * 没有 Optional 类之前的代码形式
     */
    @Test
    void test3() {
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
        // null
    }

    /**
     * 没有 Optional 类之前的代码形式
     */
    private String getGirlName(Boy boy) {
        if(boy != null) {
            Girl girl = boy.getGirl();
            if(girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    /**
     * 有了 Optional 类之后的代码形式
     *
     * 保证该方法一定不会返回 null
     */
    private String getGirlName1(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("迪丽热巴")));
        // boy1 一定不为 null，但此时的 girl 可能为 null
        Girl girl = boy1.getGirl();

        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        Girl girl1 = optionalGirl.orElse(new Girl("古力娜扎"));
        // girl1 一定不为 null
        return girl1.getName();
    }

    @Test
    void test4() {
        Boy boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
        // 古力娜扎
    }

    @Test
    void test5() {
        String girlName = getGirlName1(null);
        System.out.println(girlName);
        // 迪丽热巴
    }

    @Test
    void test6() {
        Boy boy = new Boy(new Girl("rose"));
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
        // rose
    }
}
