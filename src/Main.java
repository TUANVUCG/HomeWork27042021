import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập lựa chọn của bạn ");
        String choice = null;
        do{
            System.out.println("1. Nhập thông tin một sinh viên mới ");
            System.out.println("2. Xem toàn bộ danh sách sinh viên ");
            System.out.println("3. Cập nhật thông tin cho một sinh viên ");
            System.out.println("4. Xóa sinh viên theo mã sinh viên ");
            System.out.println("5. Sắp xếp sinh viên theo điểm giảm dần ");
            System.out.println("6. Tìm sinh viên có điểm cao nhất ");
            System.out.println("7. Tìm sinh viên theo mã sinh viên ");
            System.out.println("8. Thống kê lượng sinh viên của từng lớp ");
            System.out.println("9. Ghi danh sách sinh viên ra file");
            System.out.println("10. Đọc danh sách sinh viên từ file");
            System.out.println("0. Thoát chương trình ");
            choice = sc.nextLine();
            switch (choice){
                case "1":
                    manager.addStudent();//Done
                    break;
                case "2":
                    manager.showAllStudentInfo();//Done
                    break;
                case "3":
                    System.out.print("Nhập mã sinh viên cần update : ");
                    int idUpdate = Integer.parseInt(sc.nextLine());
                    manager.updateStudentInfo(idUpdate);
                    break;
                case "4":
                    System.out.print("Nhập mã sinh viên cần xóa : ");//Done
                    int id = Integer.parseInt(sc.nextLine());
                    manager.removeStudentById(id);
                    break;
                case "5":
                    manager.bubbleSortStudentList();// Done
                    break;
                case "6":
                    break;
                case "7":
                    System.out.println("Nhập mã sinh viên cần tìm : "); // Done
                    int id1 = Integer.parseInt(sc.nextLine());
                    manager.showStudentInfoById(id1);
                    break;
                case "8":
                    break;
                case "9":
                    manager.writeStudentInfoToFile(); // Done
                    break;
                case "10":
                    manager.readStudentInfo(); // Done
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    break;
                default:
                    System.err.println("Nhập sai !!!");
            }
        }while (!(choice.equals("0")));
    }
}
