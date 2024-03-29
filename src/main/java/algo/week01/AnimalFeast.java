package algo.week01;



public class AnimalFeast {
    public static void main(String[] args) {
        String animal = "great blue heron";
        String dish = "arlic nan";

        System.out.println(isEligible(animal, dish));
        System.out.println(isEligible2(animal, dish));

    }

    public static boolean isEligible(String animal, String dish) {
        return animal.charAt(0) == dish.charAt(0) && animal.charAt(animal.length() - 1) == dish.charAt(dish.length() - 1);
    }

    public static boolean isEligible2(String animal, String dish) {
        return (animal.charAt(0) + "" + animal.charAt(animal.length() - 1)).equals(dish.charAt(0) + "" + dish.charAt(dish.length() - 1));
    }



}

    /*
All the animals are having a feast! Each animal is bringing one dish. There is just one rule: the dish must start and
end with the same letters as the animal's name. For example, the great blue heron is bringing garlic naan and
the chickadee is bringing chocolate cake.
Write a method that takes the animal's name and dish as arguments and returns true or false to indicate
whether the beast is allowed to bring the dish to the feast.
Assume that beast and dish are always lowercase strings, and that each has at least two letters.
Beast and dish may contain hyphens and spaces, but these will not appear at the beginning or end of the string.
They will not contain numerals.
*/

