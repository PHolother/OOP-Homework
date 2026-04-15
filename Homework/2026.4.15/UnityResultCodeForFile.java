public enum UnityResultCodeForFile {
    // 假设错误码
    UPLOAD_SUCCESS(2001, "文件上传成功"),
    UPLOAD_FAILED(4001, "文件上传失败，请重试"),
    FILE_TOO_LARGE(4002, "文件大小超出限制"),
    FORMAT_NOT_SUPPORTED(4003, "不支持的文件格式"),
    FILE_NOT_FOUND(4004, "文件不存在"),
    DOWNLOAD_SUCCESS(2002, "文件下载成功");

    private final int code;
    private final String message;

    UnityResultCodeForFile(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }
}

// 测试方法
class FileTest {
    public static void main(String[] args) {
        // 假设成功场景
        UnityResultCodeForFile result = UnityResultCodeForFile.UPLOAD_SUCCESS;
        System.out.println("状态码：" + result.getCode());
        System.out.println("提示信息：" + result.getMessage());

        System.out.println("\n\n\n");

        // 假设失败场景
        UnityResultCodeForFile error = UnityResultCodeForFile.FILE_TOO_LARGE;
        System.out.println("状态码：" + error.getCode());
        System.out.println("提示信息：" + error.getMessage());
    }
}