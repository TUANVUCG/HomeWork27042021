import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {

    private int id;
    private String name;
    private String homeTown;
    private String className;
    private float mark;

    public Student() {
    }

    public Student(int id, String name, String homeTown, String className, float mark) {
        this.id = id;
        this.name = name;
        this.homeTown = homeTown;
        this.className = className;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    // Nhap thong tin sinh vien
    public void inputStudentInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên : ");
        id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập họ tên : ");
        name = sc.nextLine();
        System.out.print("Nhập quê quán : ");
        homeTown = sc.nextLine();
        System.out.print("Nhập tên lớp học : ");
        className = sc.nextLine();
        System.out.print("Nhập điểm : ");
        mark = Integer.parseInt(sc.nextLine());

    }

    @Override
    public String toString() {
        return  "Mã sinh viên : " + id +"    "+
                "Tên : " + name + "    " +
                "Quên quán : " + homeTown + "    " +
                "Tên lớp : '" + className + "    " +
                "Điểm : " + mark;
    }
}
