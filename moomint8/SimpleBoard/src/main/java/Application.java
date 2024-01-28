import controller.MemberController;
import controller.TitleController;
import view.TitlePage;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        TitleController titleController = new TitleController();
        titleController.selectTitleMenu();
    }
}
