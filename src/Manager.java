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
        if(!isFind){
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
        writeStudentInfoToFile();
        readStudentInfo();
        for (Student student : readStudentInfo()) {
            System.out.println(student);
        }
    }

    // Sap xep sinh vien theo diem giam dan bang Bubble sort
    public void bubbleSortStudentList() {
        readStudentInfo();
        for (int i = 0; i < readStudentInfo().size(); i++) {
            for (int j = readStudentInfo().size(); j > i; j--) {
                if (readStudentInfo().get(j).getId() > readStudentInfo().get(j - 1).getId()) {
                    Student studentTemp = readStudentInfo().get(j);
                    readStudentInfo().set((j), readStudentInfo().get(j - 1));
                    readStudentInfo().set((j - 1), studentTemp);
                }
            }
        }
    }


    // T





}

