import java.time.ZonedDateTime;

/**
 * 获取当前时间及时区
 */
public class T1 {
    public static void main(String[] args){
        ZonedDateTime zbj=ZonedDateTime.now();
        System.out.println(zbj);
    }

}
