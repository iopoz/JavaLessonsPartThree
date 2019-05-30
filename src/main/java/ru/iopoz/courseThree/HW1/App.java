package ru.iopoz.courseThree.HW1;


import java.util.*;

public class App
{
    public static int FIRST_ELEMENT = 0;
    public static int SECOND_ELEMENT = 4;
    public static Integer[] INT_ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    public static Double[] DOUBLE_ARRAY = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0};
    public static String[] STR_ARRAY = {" one ", " two ", " three ", " four ", " five ", " six ", " seven "};

    public static void main( String[] args ) throws Exception {
        HashMap arrays = new HashMap();
        arrays.put(1, INT_ARRAY);
        arrays.put(2, DOUBLE_ARRAY);
        arrays.put(3, STR_ARRAY);

        for (int i=0; i < 3; i++ ){
            taskOne((Object[]) arrays.get(i + 1), FIRST_ELEMENT, SECOND_ELEMENT);
            taskTwo((Object[]) arrays.get(i + 1));
        }

        taskThree();
    }

    public static void taskOne(Object[] array, int firstValue, int secondValue) throws Exception {
        System.out.println("Result for first task in array before exchanging: " + Arrays.toString(array));
        exchangeTwoElements(array, firstValue, secondValue);
        System.out.println("Exchange result in array: " + Arrays.toString(array));
    }

    public static void taskTwo(Object[] array){
        System.out.println("Result for second task in array before exchanging: " + Arrays.toString(array));
        List newArray = arrayToArrayList(array);
        System.out.println("Exchange result in array: " + newArray);
    }

    private static void exchangeTwoElements(Object[] array, int firstElement, int secondElement) throws Exception {
        if (firstElement < 0 || firstElement > array.length ||
                secondElement < 0 || secondElement > array.length || firstElement == secondElement) {
            throw new Exception("Incorrect element position");
        }
        Object temp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = temp;
    }

    private static <T> ArrayList arrayToArrayList(T[] array) {
        List<T> newList = new ArrayList<T>();
        Collections.addAll(newList,array);
        newList.add(newList.get(0));
        return (ArrayList) newList;
    }


    public static void taskThree(){
        Box<Apple> boxWithApple = new Box<Apple>(new Apple(), new Apple(), new Apple());
        Box<Orange> boxWithOranges = new Box<Orange>(new Orange(), new Orange());
        Box<Orange> secondBoxWithOranges = new Box<Orange>(new Orange(), new Orange());
        Box anotherBox = new Box<>();
        System.out.println("A box of apples weighs " + boxWithApple.getWeight());
        System.out.println("A box of oranges weight " + boxWithOranges.getWeight());
        System.out.println(boxWithApple.compare(boxWithOranges));
        boxWithOranges.replaceFruitsToAnotherBox(anotherBox);
        boxWithApple.replaceFruitsToAnotherBox(anotherBox);
        secondBoxWithOranges.replaceFruitsToAnotherBox(anotherBox);
        System.out.println(boxWithOranges.getBox());
        System.out.println(boxWithApple.getBox());
        System.out.println(anotherBox.getBox());
    }
}
