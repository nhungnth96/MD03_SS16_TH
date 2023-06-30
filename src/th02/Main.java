package th02;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        String PATH_NUMBER = "C:\\Users\\ADMIN\\Desktop\\MODULE 3\\SS16_ThucHanh\\src\\th02\\number";
        String PATH_RESULT = "C:\\Users\\ADMIN\\Desktop\\MODULE 3\\SS16_ThucHanh\\src\\th02\\result";
        List<Integer>numbers = readFile(PATH_NUMBER);
        int maxValue = findMax(numbers);
        writeFile(PATH_RESULT,maxValue);
    }

    public static List<Integer> readFile(String filepath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi");
        }
        return numbers;
    }

    public static void writeFile(String filePath, int max) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
}
