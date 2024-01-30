package feat;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class EditFile {
    static Scanner sc = new Scanner(System.in);

    public static void Edit(String forderPath) throws IOException {
        System.out.print("파일 입력: ");
        String file_name =sc.nextLine();
        File file = new File(forderPath+file_name+".txt");
        if(file.exists()){
            Desktop.getDesktop().open(file);
            //EditFile(file);
        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }
    }

    private static void EditFile(File file) throws IOException {
        System.out.println("\n파일에 원하는 문장들을 작성하세요. (quit: \'q!\')");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        while (true){
            System.out.print("작성: ");
            String insert = sc.nextLine();
            if( insert.equals("q!") ) {
                System.out.println('\n');
                break;
            }
            writer.write(insert);
            writer.newLine();
        }
        // 버퍼 및 스트림 뒷정리
        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
        writer.close(); // 스트림 종료
    }
}
