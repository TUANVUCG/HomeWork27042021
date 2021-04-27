import java.io.*;
import java.util.*;

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
//        List<Student> studentListReader = null;
        try {
            fis = new FileInputStream("Student.txt");
            ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
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
        return studentList;
    }

    // Hien thi tat ca sinh vien
    public void showAllStudentInfo() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // Sap xep sinh vien theo diem giam dan bang Bubble sort
    public void bubbleSortStudentListByMark() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = (studentList.size() - 1); j > i; j--) {
                if (studentList.get(j).getMark() > studentList.get(j - 1).getMark()) {
                    Student studentTemp = studentList.get(j);
                    studentList.set((j), studentList.get(j - 1));
                    studentList.set((j - 1), studentTemp);
                }
            }
        }
        System.out.println("Danh sách sắp xếp theo điểm : ");
        showAllStudentInfo();
    }

    // Sap xep theo ma sinh vien
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
        int right = studentList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(studentList.get(mid).getId()==id){
                return mid;
            }
            if (id < studentList.get(mid).getId()) {
                left = mid + 1;
            }
            if(id>studentList.get(mid).getId()){
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


    // Cap nhat thong tin mot sinh vien
    public void updateStudentInfo(int id){
        int search = searchStudentBinary(id);
        if(search!=-1){
            Student student = new Student();
            student.inputStudentInfo();
            studentList.set(search,student);
        }
    }

    // Tim sinh vien co diem cao nhat
    public void searchStudentHaveMaxMark(){
        bubbleSortStudentListByMark();
        System.out.println("Sinh viên có điểm cao nhất là : ");
        System.out.println(studentList.get(0));
    }

    // Thong ke luong sinh vien cua tung lop
    public void statisticalAmountStudentInAClass(){
        Map<String, Student> studentMap = new HashMap<String, Student>();
        for(int i = 0;i<studentList.size();i++){
            studentMap.put(studentList.get(i).getClassName(),studentList.get(i));
        }
       Set<String> keySet = studentMap.keySet();
        for(String key : keySet){
            System.out.println(key +  "    -    "+studentMap.get(key));
        }
    }


}



