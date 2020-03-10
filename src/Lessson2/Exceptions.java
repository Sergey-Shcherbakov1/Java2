/*    Есть строка вида:"10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";(другими словами матрица 4x4)
        10 3 1 2
        2 3 2 2
        5 6 7 1
        300 3 1 0
        Написать метод,на вход которого подаётся такая строка,метод должен преобразовать строку в двумерный массив типа String[][];
        2.Преобразовать все элементы массива в числа типа int, просуммировать,поделить полученную сумму на 2,и вернуть результат;
         3. Ваши методы должны бросить исключения в случаях:
    Если размер матрицы, полученной из строки, не равен 4x4;
    Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
 5. * Написать собственные классы исключений для каждого из случаев
*/

package Lessson2;

public class Exceptions {
    private static final String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static int arrayLength = 4;
    private static String[][] array = new String[arrayLength][arrayLength];


    public static void main(String[] args) {
        stringTo2DArray(str); //ArrayIndexOutOfBoundsException
        arrayToInteger(array); //ArrayIndexOutOfBoundsException and NumberFormatException
    }


    private static String[][] stringTo2DArray(String s) {

        try {
            var splitColumn = str.split("\n");

            for (int i = 0; i < splitColumn.length; i++) {
                String[] splitRow = splitColumn[i].split(" ");

                for (int j = 0; j < splitRow.length; j++) {
                    array[i][j] = splitRow[j];
                }
            }

            if ( array.length != arrayLength )
                throw new ArrayIndexOutOfBoundsException("Ошибка массива");

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return array;
    }

    private static float arrayToInteger(String[][] s) {
        float total = 0;
        try {
            for (String[] strings : array) {
                for (int i = 0; i < strings.length; i++) {
                    var splitArray = strings[i].split(" ");
                    if (!strings[i].matches("[-+]?\\d+")) //данный метод проверки честно списал в интернете
                    throw new NumberFormatException("Ошибка массива");
                    Integer temp = Integer.parseInt(splitArray[0]);
                    total += temp;
                }
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        System.out.println(total / 2);
        return total / 2;
    }
}


