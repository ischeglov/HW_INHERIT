import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @BeforeAll
    static void setUp() {
        System.out.println("Тесты запущены");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Тесты выполнены");
    }

    @Test
    public void shouldTestReturnsTrueWhenQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String query = "Позвонить";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestReturnsFalseWhenQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String query = "Приехать";

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestReturnsTrueWhenQueryEpic(){
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String query = "Молоко";

        boolean expected = true;
        boolean actual = epic.matches(query);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestReturnsFalseWhenQueryEpic(){
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String query = "Йогурт";

        boolean expected = false;
        boolean actual = epic.matches(query);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestReturnsTrueWhenQueryMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Выкатка";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestReturnsFalseWhenQueryMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Релиз";

        boolean expected = false;
        boolean actual = meeting.matches(query);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestReturnsTrueWhenQueryMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Приложение";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestReturnsFalseWhenQueryMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "ПО";

        boolean expected = false;
        boolean actual = meeting.matches(query);

        assertEquals(expected, actual);
    }
}