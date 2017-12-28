package kr.or.nextit.common.file.mapper;

import java.util.List;
import java.util.Map;

import kr.or.nextit.common.file.model.FileItem;

public interface FileMapper2 {
	
	public List<FileItem> selectFileItemList(Map<String, Object> paramMap) throws Exception;
	
	public FileItem selectFileItem(Map<String, Object> paramMap) throws Exception;
	
	public int insertFileItem(FileItem fileItem) throws Exception;
	
	public int deleteFileItem(Map<String, Object> paramMap) throws Exception;
	
	public int updateDownloadCnt(Map<String, Object> paramMap) throws Exception;
}
