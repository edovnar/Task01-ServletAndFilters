import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Order;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objm = new ObjectMapper();
        Order order = objm.readValue(" {\n" +
                "     \"id\":\"dlld\",\n" +
                "     \"item\":\"item\",\n" +
                "     \"quantity\":3\n" +
                " }", Order.class);
        System.out.println(order.getId());

        ThreadLocal th = new ThreadLocal();
        System.out.println(th.get());
    }
}
