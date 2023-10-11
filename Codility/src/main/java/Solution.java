import java.util.*;

public class Solution {
    static Map<Integer, Category> categoryMap = new HashMap<>();

    public static void main(String[] args) {
        initData();
        System.out.println(Arrays.toString(solution(8))); // should print [3, Home, Appliances, Kitchen]
    }

    static void initData() {
        Object[][] data = {
                {1, "Root", "Products", -1},
                {2, "Furniture", "Furniture", 1},
                {3, "Electronics", "Electronics, Gadgets", 1},
                {4, "Home Appliances", "Home, Appliances", 1},
                {5, "Major Appliances", "", 4},
                {6, "Minor Appliances", "", 4},
                {7, "Lawn & Garden", "Lawn, Garden", 4},
                {8, "Kitchen Appliances", "", 5},
                {9, "General Appliances", "", 5}
        };

        for (Object[] row : data) {
            int id = (int) row[0];
            String name = (String) row[1];
            String keywords = (String) row[2];
            int parentId = (int) row[3];

            Category category = new Category(id, name);
            for (String keyword : keywords.split(", ")) {
                category.addKeyword(keyword);
            }
            categoryMap.put(id, category);

            if (parentId != -1) {
                categoryMap.get(parentId).addSubcategory(category);
            }
        }
    }

    public static String[] solution(int categoryID) {
        Category category = categoryMap.get(categoryID);
        if (category == null) return new String[0];

        int level = getLevel(categoryID);
        List<String> keywords = getKeywords(category);

        String[] result = new String[keywords.size() + 1];
        result[0] = String.valueOf(level);
        for (int i = 0; i < keywords.size(); i++) {
            result[i + 1] = keywords.get(i);
        }

        return result;
    }

    static int getLevel(int categoryId) {
        int level = 0;
        while (categoryId != -1) {
            categoryId = getParentId(categoryId);
            level++;
        }
        return level - 1;
    }

    static int getParentId(int categoryId) {
        for (Map.Entry<Integer, Category> entry : categoryMap.entrySet()) {
            for (Category subcategory : entry.getValue().subcategories) {
                if (subcategory.id == categoryId) return entry.getKey();
            }
        }
        return -1;
    }

    static List<String> getKeywords(Category category) {
        List<String> keywords = new ArrayList<>(category.keywords);
        while (!category.subcategories.isEmpty()) {
            category = category.subcategories.get(0);
            keywords.addAll(category.keywords);
        }
        return keywords;
    }

    static class Category {
        int id;
        String name;
        List<String> keywords;
        List<Category> subcategories;

        public Category(int id, String name) {
            this.id = id;
            this.name = name;
            this.keywords = new ArrayList<>();
            this.subcategories = new ArrayList<>();
        }

        public void addKeyword(String keyword) {
            this.keywords.add(keyword);
        }

        public void addSubcategory(Category subcategory) {
            this.subcategories.add(subcategory);
        }
    }
}