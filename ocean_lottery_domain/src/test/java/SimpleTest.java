import org.junit.Test;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/1 7:26 下午
 */
public class SimpleTest {

    private final int HASH_INCREMENT = 0x61c88647;

    // 数组初始化长度
    private final int RATE_TUPLE_LENGTH = 128;

    @Test
    public void method1(){
        int hashCode = 2 * HASH_INCREMENT + HASH_INCREMENT;
        System.out.println(hashCode & (RATE_TUPLE_LENGTH - 1));
        System.out.println(Integer.toBinaryString(RATE_TUPLE_LENGTH - 1));
    }
}
