package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUtil {
	
	// 업로드한 파일이 저장될 위치 지정 - 현재 임의로 설정함
	private final static String FILE_PATH = "C:\\upload";
	
	
    
    public static <T> List<T> uploadMultipleFiles(HttpServletRequest request, Class<T> targetType) throws Exception {
        List<T> uploadedFiles = new ArrayList<>();
        
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            List<FileItem> formItems = upload.parseRequest(request);
            
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        // 단일 파일 업로드 메서드 호출
                    	T fileUploadVO = uploadFile(item, targetType);
                        if (fileUploadVO != null) {
                            uploadedFiles.add(fileUploadVO);
                        }
                    }
                }
            }
        }
        return uploadedFiles;
    }

    // uploadFile 메서드를 FileItem을 받는 형태로 리팩토링
    private static <T> T uploadFile(FileItem item, Class<T> targetType) throws Exception {
        String originalFileName = new File(item.getName()).getName(); // 원본파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 확장자
        String uuidFileName = UUID.randomUUID().toString() + extension; // UUID.확장자

        File storeFile = new File(FILE_PATH + File.separator + uuidFileName);
        
        File file = new File(FILE_PATH);
		if(!file.exists()) {
			file.mkdirs();
		}
        
        item.write(storeFile);

        return targetType.getConstructor(String.class).newInstance(uuidFileName);
    }
    
}
