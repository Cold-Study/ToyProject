package simpleboard;


import simpleboard.console.ConsoleUI;
import simpleboard.controller.BoardController;
import simpleboard.controller.MemberController;
import simpleboard.repository.BoardRepository;
import simpleboard.repository.MemberRepository;
import simpleboard.service.BoardService;
import simpleboard.service.MemberService;

public class Application {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemberRepository();
        BoardRepository boardRepository = new BoardRepository();

        MemberService memberService = new MemberService(memberRepository);
        BoardService boardService = new BoardService(boardRepository);

        MemberController memberController = new MemberController(memberService);
        BoardController boardController = new BoardController(boardService);

        ConsoleUI consoleUI = new ConsoleUI(memberController, boardController);

        // Application 실행
        consoleUI.start();
    }
}
