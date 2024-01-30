package feat;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
    static Scanner sc = new Scanner(System.in);

    public static void Delete(String forderPath) {
        System.out.print("삭제할 파일 입력: ");
        String file_name = sc.nextLine();
        File file = new File(forderPath+file_name+".txt");
        if(file.exists()){
            file.delete();
            System.out.println(file_name+" 파일 삭제했습니다.");
        }else {
            System.out.println("파일이 없습니다.");
        }
    }
}
