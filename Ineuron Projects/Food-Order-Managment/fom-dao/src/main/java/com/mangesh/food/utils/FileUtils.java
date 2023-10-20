//package com.mangesh.food.utils;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.mangesh.fomobject.FileData;
//
//public class FileUtils {
//	
//	public static FileData uploadFileToFileSystem(MultipartFile file, String location) throws IOException {
//		String fileloc = location + file.getOriginalFilename();
//		UUID uuid = UUID.randomUUID();
//		FileData fileData = (FileData.builder().name(uuid.toString()).type(file.getContentType()).filePath(fileloc)
//				.build());
//		file.transferTo(new File(fileloc));
//		if (fileData != null) {
//			return fileData;
//		}
//		return null;
//	}
//	
//	
//	public static byte[] downloadFileFromFileSystem(FileData file) throws IOException {
//		String filePath = file.getFilePath();
//		byte[] images = Files.readAllBytes(new File(filePath).toPath());
//		return images;
//	}
//
//	// multipartList
//	public static List<FileData> uploadFileListToFileSystem(MultipartFile[] multiPartFileList, String location)
//			throws IOException {
//		List<FileData> fileDataList = new ArrayList<FileData>();
//		for (MultipartFile multipartFile : multiPartFileList) {
//			String fileloc = location + multipartFile.getOriginalFilename();
//			UUID uuid = UUID.randomUUID();
//			FileData fileData = (FileData.builder().name(uuid.toString()).type(multipartFile.getContentType())
//					.filePath(fileloc).build());
//			multipartFile.transferTo(new File(fileloc));
//			fileDataList.add(fileData);
//		}
//		return fileDataList;
//	}
//
//}
