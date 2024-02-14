package vo.common;

public class PageVo {
	
	// 조회, 계산시 필요한 값들
	private String searchGubun; 	// 검색 구분
	private String searchText; 		// 검색어
	
	
	private int currentPageNo = 1; 	// 현재 페이지 번호
	
	private int recordViewSize = 3; // 보여줄 레코드 갯수
	
	private int startRecordNo; 		// 레코드 시작번호(계산)
	
	private int endRecordNo; 		// 레코드 끝번호(계산)
	
	private int recordTotalCount; 	// 검색 or 전체 레코드 갯수(조회 필요)
	
	
	private int currentPageArea = 1; // 현재 페이지목록 구역번호

	private int pageViewSize = 2; 	// 보여줄 페이지 갯수 
		
	private int startPageNo; 		// 페이지 시작 번호
	
	private int endPageNo; 			// 페이지 끝 번호
	
	private int pageTotalCount; 	// 총 페이지 갯수	(계산)
	

	// startRecordNo, endRecordNo setting.
	public void recordNoRangeSetting() {
		this.startRecordNo = (this.currentPageNo - 1) * recordViewSize + 1; // 레코드 시작번호 세팅
		this.endRecordNo = this.currentPageNo * recordViewSize; // 레코드 끝번호 세팅
	}
	
	// pageTotalCount setting.
	public void pageTotalCountSetting() {
		this.pageTotalCount = (int) Math.ceil(this.recordTotalCount / (recordViewSize * 1.0));
	}
	
	// startPageNo, endPageNo setting.
	public void pageNoRangeSetting() {
		this.startPageNo = (this.currentPageArea - 1) * pageViewSize + 1; // 페이지 시작번호 세팅
		this.endPageNo = this.currentPageArea * pageViewSize; // 페이지 끝번호 세팅
		if(this.endPageNo > pageTotalCount) this.endPageNo = this.pageTotalCount;
	}

	


	// getter, setter
	public int getCurrentPageArea() {
		return currentPageArea;
	}

	public void setCurrentPageArea(int currentPageArea) {
		this.currentPageArea = currentPageArea;
	}
	public String getSearchGubun() {
		return searchGubun;
	}

	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getRecordViewSize() {
		return recordViewSize;
	}

	public void setRecordViewSize(int recordViewSize) {
		this.recordViewSize = recordViewSize;
	}

	public int getStartRecordNo() {
		return startRecordNo;
	}

	public void setStartRecordNo(int startRecordNo) {
		this.startRecordNo = startRecordNo;
	}

	public int getEndRecordNo() {
		return endRecordNo;
	}

	public void setEndRecordNo(int endRecordNo) {
		this.endRecordNo = endRecordNo;
	}

	public int getRecordTotalCount() {
		return recordTotalCount;
	}

	public void setRecordTotalCount(int recordTotalCount) {
		this.recordTotalCount = recordTotalCount;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	public int getPageViewSize() {
		return pageViewSize;
	}

	public void setPageViewSize(int pageViewSize) {
		this.pageViewSize = pageViewSize;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}
}
