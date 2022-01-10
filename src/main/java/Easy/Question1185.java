package Easy;

public class Question1185 {

    private static final String[] dayIndex = new String[]{
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };

    private static final int[] numsOfMonths = new int[]{
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public String dayOfTheWeek(int day, int month, int year) {
        int ans = 4;
        for (int i = 1971; i < year; i++) {
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            ans += isLeap ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            ans += numsOfMonths[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) ans++;
        }
        ans += day;
        return dayIndex[ans % 7];
    }

    public static void main(String[] args) {
        Question1185 question = new Question1185();
        System.out.println(question.dayOfTheWeek(3, 1, 2022));
        System.out.println(question.dayOfTheWeek(31, 8, 2019));
        System.out.println(question.dayOfTheWeek(18, 7, 1999));
        System.out.println(question.dayOfTheWeek(15, 8, 1993));
    }
}
