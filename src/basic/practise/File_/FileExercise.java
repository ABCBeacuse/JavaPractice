package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileExercise {


    @Test
    void create01() {
        // 在 Java 内存中创建一个 File 对象
        File file = new File("d:\\new1.txt");
        try {
            // 将内存中的 File 对象实际上与 磁盘 关联
            file.createNewFile();
            // 创建文件时可能出现 IOException
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void create02() {
        // Java 内存中 先创建一个父目录的对象
        File parent = new File("d:\\");
        // 内存中创建一个 File 对象
        File file = new File(parent, "new2.txt");
        try {
            // 真正在磁盘上创建对象
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void create03() {
        // 父路径
        String parentPath = "d:\\";
        // 子路径
        String childPath = "new3.txt";
        // 根据父目录 + 子路径 创建
        File file = new File(parentPath, childPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testMethods() {
        File file = new File("d:\\new1.txt");
        System.out.println("文件名字: " + file.getName());
        System.out.println("文件绝对路径: " + file.getAbsolutePath());
        System.out.println("文件大小（字节）: " + file.length());
        System.out.println("文件父级目录: " + file.getParent());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("是不是一个文件: " + file.isFile());
        System.out.println("是不是一个目录: " + file.isDirectory());
    }

    //
    @Test
    void testOperation() {
        String path = "d:\\new1.txt";
        File file = new File(path);
        if (file.exists()) {
            // delete() 方法只能删除文件或空目录
            if (file.delete()) {
                System.out.println("删除" + file.getName() + "成功");
            } else {
                System.out.println("删除文件失败");
            }
        } else {
            System.out.println("文件目录不存在");
        }
    }

    @Test
    void testDeleteDir() {
        String path = "d:\\empty";
        File file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除" + file.getName() + "成功");
            } else {
                System.out.println("删除文件失败");
            }
        } else {
            System.out.println("文件目录不存在");
        }
    }

    @Test
    void testMakeDirs() {
        // 查看目录是否存在，如果存在则提示，不存在则创建
        String path = "d:\\demo";
        File file = new File(path);
        if (file.exists()) {
            System.out.println("文件存在");
        } else {
            // 不存在则创建 ( mkdirs：创建多级目录；mkdir：创建单级目录 )
            if (file.mkdir()) {
                System.out.println(file.getAbsolutePath() + "创建成功");
            } else {
                System.out.println(file.getAbsolutePath() + "创建失败");
            }
        }
    }
}
