package nyamnyam1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class CsvToJsonConverter {

    // key   : CSV 열 인덱스 (첫 번째 열=0)
    // value : JSON에 들어갈 라벨(키) 이름
    private static final Map<Integer, String> COLUMN_LABELS = new LinkedHashMap<>();
    static {
        COLUMN_LABELS.put(0, "foodCode");     // 식품코드
        COLUMN_LABELS.put(1, "foodName");     // 식품명
        COLUMN_LABELS.put(17, "energyKcal");  // 에너지(kcal)
        COLUMN_LABELS.put(19, "protein");     // 단백질(g)
        COLUMN_LABELS.put(20, "fat");         // 지방(g)
        COLUMN_LABELS.put(22, "carbohydrate");// 탄수화물(g)
        COLUMN_LABELS.put(23, "glucide");	  // 당류(g)

    }

    public static void main(String[] args) throws Exception {
        String inputPath = "data/rawData.csv";
        String outputPath = "data/foodData.json";

        List<Map<String, Object>> resultList = convert(inputPath);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File(outputPath), resultList);

        System.out.println("변환 완료: " + resultList.size() + "건 -> " + outputPath);
    }

    private static List<Map<String, Object>> convert(String inputPath) throws IOException {
        List<Map<String, Object>> resultList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_8))) {

            String line = br.readLine(); // 첫 줄(헤더)은 건너뜀
            if (line == null) return resultList;

            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                String[] fields = parseCsvLine(line);

                Map<String, Object> rowData = new LinkedHashMap<>();
                for (Map.Entry<Integer, String> entry : COLUMN_LABELS.entrySet()) {
                    int colIndex = entry.getKey();
                    String label = entry.getValue();

                    if (colIndex >= fields.length) {
                        rowData.put(label, null);
                        continue;
                    }

                    rowData.put(label, parseValue(fields[colIndex]));
                }
                resultList.add(rowData);
            }
        }
        return resultList;
    }

    // 쌍따옴표로 감싼 필드 안의 콤마(,)도 안전하게 처리하는 간단한 CSV 파서
    private static String[] parseCsvLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                // 이스케이프된 쌍따옴표("") 처리
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    sb.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                result.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        result.add(sb.toString());
        return result.toArray(new String[0]);
    }

    // 숫자면 숫자로, 빈 값이면 null로, 나머지는 문자열로 변환
    private static Object parseValue(String raw) {
        if (raw == null) return null;
        String v = raw.trim();
        if (v.isEmpty()) return null;

        try {
            if (v.matches("^-?\\d+$")) {
                return Long.parseLong(v);
            }
            if (v.matches("^-?\\d*\\.\\d+$")) {
                return Double.parseDouble(v);
            }
        } catch (NumberFormatException ignored) {
            // 숫자 변환 실패하면 그냥 문자열로 취급
        }
        return v;
    }
}
