package file;

public class FileUploadVO {
	private String originalFileName; // 원래 파일명
    private String uuidFileName;     // UUID로 생성된 파일명
    private String extension;        // 파일 확장자
    
    
    
    // 생성자
	public FileUploadVO(String originalFileName, String uuidFileName, String extension) {
		super();
		this.originalFileName = originalFileName;
		this.uuidFileName = uuidFileName;
		this.extension = extension;
	}
	
	// getter, setter
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getUuidFileName() {
		return uuidFileName;
	}
	public void setUuidFileName(String uuidFileName) {
		this.uuidFileName = uuidFileName;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
    
    
}
