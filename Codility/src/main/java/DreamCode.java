import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * We have several product categories for Square Trade in which we sell insurance. Categories include Furniture, Electronics,
 * Home Appliances. Categories have hierarchies.
 * So Home appliances have sub categories like Major Appliances, Minor Appliances, Lawn & Garden.
 * And Major Appliances have subcategories of Kitchen Appliances and General Appliances.
 * For each category there are zero or more keywords associated with it. This is used by our search engine to go to the specific category.
 * If a certain category is missing keywords, it needs to inherit it from the parent.
 * Example the Kitchen Appliances category will inherit the keywords "Home" and "Appliances".
 * Task:
 * 1. Create an appropriate data structure and populate it with the above data. You may use the raw data provided to you for convenience and convert it to the appropriate data structure of your choice.
 * 2. Write code that gets keywords for a given category.
 * 3. Write code that gets the "level" of the category starting from the Root. So categories whose parent is the Root are at level 1, their children are at level 2, etc.
 * 4. Package the results into the solution() method that takes in categoryID as a parameter and returns results. The first element of the array is the level converted to a string. Rest of the elements are the keywords for the category. Eg; solution (3) returns {"1", "Electronics", "Gadgets"}
 */
public class DreamCode {

    public static final int ROOT_LEVEL = -1;
    static Object[][] data = {
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


    public static String[] solution(int categoryID) {
        // Implement your solution here
        Map<Integer, Category> listTree = buildHierarchy(data);

        Optional<Category> optionalCategory = findCategory(categoryID, listTree);

        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            return new String[]{String.valueOf(category.getLevel()), category.getKeyWords()};
        }
        return new String[]{};
    }

    /**
     * Build Category 'tree' from the data set
     * @param data
     * @return
     */
    private static Map<Integer, Category> buildHierarchy(Object[][] data) {
        Map<Integer, Category> listTree = new HashMap<>();
        //starting from 1 to avoid edge case of the first row
        for (Object[] row : data) {
            Category category = new Category();
            category.setID((Integer) row[0]);
            category.setName((String) row[1]);
            category.setKeyWords((String) row[2]);
            category.setParentId((Integer) row[3]);
            addCategory(listTree, category);
        }
        return listTree;
    }

    /**
     * Add category to the tree in the corresponding level
     *
     * @param listTree
     * @param category
     */
    private static void addCategory(Map<Integer, Category> listTree, Category category){
        if(category.getParentId() == ROOT_LEVEL) {
            listTree.put(category.getID(), category);
        }
        if(listTree.containsKey(category.getParentId())) {
            listTree.get(category.getParentId()).getSubCategories().add(category);
            listTree.put(category.getID(), category);
        }
        /*
        else {

            if(category.getKeyWords().isEmpty() && child.getLevel()>=1){
                category.setKeyWords(child.getKeyWords());
            }
            addCategory(child.getSubCategories(), category);
        }
         */
    }

    private static Optional<Category> findCategory(int categoryID, Map<Integer, Category> categories){
        Optional<Category> result = Optional.empty();
        for(Map.Entry<Integer, Category> entry: categories.entrySet()){
            for(Category child: entry.getValue().getSubCategories()){
                if(categoryID == child.getID()){
                    return Optional.of(child);
                }
            }
        }

        return result;
    }

    public static class Category{
        private List<Category> subCategories = new ArrayList<>();
        private Category topCategory;
        private String name;
        private String keyWords;
        private Integer parentId;
        private Integer level = 0;
        private Integer ID;

        public Category() {
        }

        public Category getTopCategory() {
            return topCategory;
        }

        public void setTopCategory(Category topCategory) {
            this.topCategory = topCategory;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Integer getID() {
            return ID;
        }

        public void setID(Integer ID) {
            this.ID = ID;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public List<Category> getSubCategories() {
            return subCategories;
        }

        public void setSubCategories(List<Category> subCategories) {
            this.subCategories = subCategories;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKeyWords() {
            return keyWords;
        }

        public void setKeyWords(String keyWords) {
            this.keyWords = keyWords;
        }
    }
}
