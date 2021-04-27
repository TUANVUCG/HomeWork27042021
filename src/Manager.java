import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Manager {

    List<Student> studentList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    // Nhap thong tin mot sinh vien moi
    public void addStudent() {
        Student student = new Student();
        student.inputStudentInfo();
        boolean isFind = false;
        for (Student student1 : studentList) {
            if (student1.getId() == student.getId()) {
                System.err.println("Mã sinh viên đã tồn tại !!!");
                isFind = true;
            }
        }
        if (!isFind) {
            studentList.add(student);
        }
    }


    // Ghi file
    public void writeStudentInfoToFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Student.txt");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Doc file
    public List<Student> readStudentInfo() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Student> studentListReader = null;
        try {
            fis = new FileInputStream("Student.txt");
            ois = new ObjectInputStream(fis);
            studentListReader = (List<Student>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentListReader;
    }

    // Hien thi tat ca sinh vien
    public void showAllStudentInfo() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // Sap xep sinh vien theo diem giam dan bang Bubble sort
    public void bubbleSortStudentList() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = (studentList.size() - 1); j > i; j--) {
                if (studentList.get(j).getMark() > studentList.get(j - 1).getMark()) {
                    Student studentTemp = studentList.get(j);
                    studentList.set((j), studentList.get(j - 1));
                    studentList.set((j - 1), studentTemp);
                }
            }
        }
        System.out.println("Danh sách sau sắp xếp");
        showAllStudentInfo();
    }

    // Sap xep theo diem
    public void sortStudentListById() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = (studentList.size() - 1); j > i; j--) {
                if (studentList.get(j).getId() > studentList.get(j - 1).getId()) {
                    Student studentTemp = studentList.get(j);
                    studentList.set((j), studentList.get(j - 1));
                    studentList.set((j - 1), studentTemp);
                }
            }
        }
    }

    //    // Tim kiem sinh vien bang nhi phan
    public int searchStudentBinary(int id) {
        sortStudentListById();
        int left = 0;
        int right = readStudentInfo().size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(readStudentInfo().get(mid).getId()==id){
                return mid;
            }
            if (id < readStudentInfo().get(mid).getId()) {
                left = mid + 1;
            }
            if(id>readStudentInfo().get(mid).getId()){
                right = mid-1;
            }
        }
        System.err.println("Không tìm thấy mã sinh viên phù hợp !!!");
        return -1;
    }

    public void showStudentInfoById(int id){
        if(searchStudentBinary(id)!=-1){
            System.out.println(studentList.get(searchStudentBinary(id)));
        }
    }


    // Xoa sinh vien theo ma sinh vien
    public void removeStudentById(int id){
        if(searchStudentBinary(id)!=-1){
            studentList.remove(searchStudentBinary(id));
        }
        System.out.println("Danh sách sau sắp xếp");
        showAllStudentInfo();
    }

}



