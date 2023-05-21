package a20230520;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class Resource1 {
    public static Integer[] get() throws IOException {

        Properties properties = new Properties();
        InputStream inputStream = BTS2.class.getClassLoader().getResourceAsStream("leetCode20230520.1.properties");
        System.out.println(inputStream);
        properties.load(inputStream);
        String str =(String) properties.get("array");
        String[] arr = str.split(",");
        Integer[] result = new Integer[arr.length];
        for(int i = 0;i<arr.length;i++){
            result[i] = !Objects.equals(arr[i], "null") ? Integer.parseInt(arr[i]) : null;
        }
        return result;
    }
}
