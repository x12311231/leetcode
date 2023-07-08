package utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class Resources {
    /**
     * this can be null for element
     * @param resource
     * @return
     * @throws IOException
     */

    public static Integer[] getInteger(String resource) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream(resource);
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
    
    public static int[] getInt(String resource) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream(resource);
        System.out.println(inputStream);
        properties.load(inputStream);
        String str =(String) properties.get("array");
        String[] arr = str.split(",");
        int[] result = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            result[i] = !Objects.equals(arr[i], "null") ? Integer.parseInt(arr[i]) : null;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Integer[] res = getInteger("a1.properties");
        Integer[] expected = new Integer[]{123,12344,null};
        for (int i = 0; i < res.length; i++) {
            if (!Objects.equals(res[i], expected[i])) {
                System.out.println("test fail");
                System.out.println("--");
                System.out.println(res[i]);
                System.out.println(expected[i]);
                System.out.println("==");
            }
        }

    }
}
