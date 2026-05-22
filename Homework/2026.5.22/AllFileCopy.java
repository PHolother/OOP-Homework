import java.io.*;

public class AllFileCopy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("请提供源文件和目标文件路径！");
            System.out.println("用法: java BinaryFileCopy source.bin dest.bin");
            return;
        }

        String sourcePath = args[0];
        String destPath = args[1];

        // 缓冲区大小（可调整）
        byte[] buffer = new byte[8192]; // 8KB
        int bytesRead;

        // try-with-resources 自动关闭流
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destPath))) {

            // 循环读取并写入，直到文件末尾
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("二进制文件复制成功！");
        } catch (FileNotFoundException e) {
            System.err.println("源文件未找到: " + sourcePath);
        } catch (IOException e) {
            System.err.println("文件读写错误: " + e.getMessage());
        }
    }
}