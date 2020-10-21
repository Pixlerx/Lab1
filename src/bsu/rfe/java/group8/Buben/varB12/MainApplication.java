package bsu.rfe.java.group8.Buben.varB12;
import java.util.Arrays;
public class MainApplication {
    // Конструктор класса отсутствует
    // Главный метод главного класса
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int howManyCalories = 0;
        int howManyBigApples = 0;
        int howManyMiddleApples = 0;
        int howManyLittleApples = 0;
        int howManyCheeses = 0;
        int howManyBeefsWithBlood = 0;
        int howManyNormalBeefs = 0;
        int howManyGrillBeefs = 0;
        int itemsSoFar = 0;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
// У сыра дополнительных параметров нет
                breakfast[itemsSoFar] = new Cheese();
                howManyCheeses++;
            } else if (parts[0].equals("Apple")) {
// У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Apple(parts[1]);
                if (parts[1].equals("Big")) {
                    howManyBigApples++;
                } else if (parts[1].equals("Middle")) {
                    howManyMiddleApples++;
                } else if (parts[1].equals("Little")) {
                    howManyLittleApples++;
                }
            }
            if (parts[0].equals("Beef")) {
// У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Beef(parts[1]);
                if (parts[1].equals("With Blood")) {
                    howManyBeefsWithBlood++;
                } else if (parts[1].equals("Normal")) {
                    howManyNormalBeefs++;
                } else if (parts[1].equals("Grill")) {
                    howManyGrillBeefs++;
                }
            }
// ... Продолжается анализ других продуктов для завтрака
            itemsSoFar++;
        }
        Arrays.sort(breakfast, new FoodComparator());
// Перебор всех элементов массива
        for (Food item : breakfast)
            if (item != null)
// Если элемент не null – употребить продукт
                item.consume();
            else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;
        for (String arg : args) {
            if (arg.startsWith("-")) {
                if (arg.equals("-calories")) {
                    for (Food item : breakfast)
                        if (item != null)
                            howManyCalories += item.calculateCalories();
                        else
                            break;
                    System.out.println("Calories in your breakfast: " + howManyCalories);
                }
                else
                if (arg.equals("-sort"))
                {
                    Arrays.sort(breakfast, new FoodComparator());
                    System.out.println();
                }
            }
        }
        if (howManyLittleApples != 0)
        {
            System.out.println("Съедено маленьких яблок: " + howManyLittleApples);
        }
        if (howManyMiddleApples != 0)
        {
            System.out.println("Съедено средних яблок: " + howManyMiddleApples);
        }
        if (howManyBigApples != 0)
        {
            System.out.println("Съедено больших яблок: " + howManyBigApples);
        }
        if (howManyBeefsWithBlood != 0)
        {
            System.out.println("Съедено ломтиков мяса с кровью: " + howManyBeefsWithBlood);
        }
        if (howManyGrillBeefs != 0)
        {
            System.out.println("Съедено ломтиков мяса с прожаркой: " + howManyGrillBeefs);
        }
        if (howManyNormalBeefs != 0)
        {
            System.out.println("Съедено ломтиков мяса с нормой: " + howManyNormalBeefs);
        }
        System.out.println("Всего хорошего!");
        if(howManyCheeses!=0)
        {
            System.out.println("Съедено ломтиков сыра: " + howManyCheeses);
        }
    }
}
