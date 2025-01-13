import Database.Database;
import Executor.StudentExecutor;
import Executor.SystemExecutor;
import Executor.TeacherExecutor;
import Tool.Checker;
import Tool.FileIO;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine()) {
            String str = scan.nextLine().trim();
            String[] command = str.split("\\s+");
            if(command[0].hashCode() == 0) continue;

            if(!Checker.checkNotFoundCommand(command) || !Checker.checkCommandDataNumber(command)) continue;

            switch (command[0]) {
                case "quit": Database.systemQuit(); FileIO.cleanDirectory(); break;
                case "register": SystemExecutor.userRegister(command); break;
                case "login": SystemExecutor.userLogin(command); break;
                case "logout": SystemExecutor.userLogout(command); break;
                case "printInfo": SystemExecutor.printInfo(command); break;
                case "createCourse": TeacherExecutor.createCourse(command); break;
                case "listCourse": SystemExecutor.listCourse(command); break;
                case "selectCourse": StudentExecutor.selectCourse(command); break;
                case "cancelCourse": SystemExecutor.cancelCourse(command); break;
                case "switch": SystemExecutor.switchUser(command); break;
                case "outputCourseBatch": TeacherExecutor.outputCourseBatch(command); break;
                case "inputCourseBatch": TeacherExecutor.inputCourseBatch(command); break;
                case "listStudent": SystemExecutor.listStudent(command); break;
                case "removeStudent": SystemExecutor.removeStudent(command); break;
                case "listCourseSchedule": SystemExecutor.listCourseSchedule(command); break;
            }
        }

        scan.close();
    }
}