package com.my.exercises;
import java.util.Arrays;

public class UserSorting {

    public static void main(String[] args) {

        User[] users = getUsers();
      User[] sort = bubbleSort(users);
      //  User[] sort = mergeSort(users);
   //     User[] sort = insertionSort(users);

        for (User user : sort) {
            System.out.println(user.getName() + " " + user.getAge());
        }
    }

    public static User[] bubbleSort(User[] userArray) {
        for (int i = 0; i < userArray.length; i++) {
            User user = userArray[i];
            for (int j = i - 1; j >= 0; j--) {
                User leftUser = userArray[j];
                if (user.compareTo(leftUser) < 0) {
                    userArray[j + 1] = leftUser;
                    userArray[j] = user;
                } else {
                    break;
                }
            }
        }
        return userArray;
    }
    public static User[] mergeSort(User[] userArray) {
        if (userArray.length < 2)
            return userArray;
        int middle = userArray.length / 2;
        User[] arr1 = Arrays.copyOfRange(userArray, 0, middle);
        User[] arr2 = Arrays.copyOfRange(userArray, middle, userArray.length);
        return merge(mergeSort(arr1), mergeSort(arr2));
    }

    public static User[] merge(User arr1[], User arr2[]) {
        int n = arr1.length + arr2.length;
        User[] sortedArray = new User[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == arr1.length) {
                sortedArray[i] = arr2[i2++];
            } else if (i2 == arr2.length) {
                sortedArray[i] = arr1[i1++];
            } else {
                if (arr1[i1].getAge() < arr2[i2].getAge()) {
                    sortedArray[i] = arr1[i1++];
                } else {
                    sortedArray[i] = arr2[i2++];
                }
            }
        }
        return sortedArray;
    }
    public static User[] insertionSort(User[] userArray) {
        User element;
        for (int i = 0; i < userArray.length; i++) {
            element = userArray[i];

            while (i> 0 && userArray[i- 1].getAge() > element.getAge()) {
                userArray[i] = userArray[i - 1];
                i--;
               userArray[i]= element;
            }
        }
        return userArray;
    }

    public static User[] getUsers() {

        User user1 = new User("Viktoryia",35);
        User user2 = new User("Viktor",30);
        User user3 = new User("Denis",37);
        User user4 = new User("Dmitry",32);
        User user5 = new User("Olga",36);

//        user1.setName("Viktoryia");
//        user1.setAge(35);
//        user2.setName("Viktor");
//        user2.setAge(30);
//        user3.setName("Denis");
//        user3.setAge(37);
//        user4.setName("Dmitry");
//        user4.setAge(32);
//        user5.setName("Olga");
//        user5.setAge(36);
        User[] m = {user1, user2, user3, user4, user5};
        return m;
    }
}




