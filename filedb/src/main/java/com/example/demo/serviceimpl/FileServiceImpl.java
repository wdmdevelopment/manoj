package com.example.demo.serviceimpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileModel;
import com.example.demo.model.FileResponse;
import com.example.demo.repository.FileRepsitory;
import com.example.demo.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	FileRepsitory fileRepo;

		//For Uploading a file
	public FileResponse store(MultipartFile file) throws IOException, SerialException, SQLException {

		//try {
		String fileName = file.getOriginalFilename();
		
		FileModel filemodel = new FileModel(UUID.randomUUID().toString(), fileName, file.getContentType(),
				new SerialBlob(file.getBytes()));
		fileRepo.save(filemodel);

		return mapToFileResponse(filemodel);
		
		}
	//	catch(Exception e) {
			
		//}
		
	//}

	// For get the file
	public FileResponse getFileById(String id) throws IOException, SQLException {

		java.util.Optional<FileModel> fileOptional = fileRepo.findById(id);

		if (fileOptional.isPresent()) {
			return mapToFileResponse( fileOptional.get());
		}
		return null;
	}

	public List<FileResponse> getFileList() {
		return fileRepo.findAll().stream().map(t -> {
			try {
				return mapToFileResponse(t);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		
	}

	public FileResponse mapToFileResponse(FileModel filemodel) throws IOException, SQLException 
	
	{

		return new FileResponse(filemodel.getId(), filemodel.getType(), filemodel.getName(),
				Base64.getEncoder().encodeToString(filemodel.getData().
	    		getBinaryStream().readAllBytes()));
	}
	
	public void deletefile(String id) {
		fileRepo.deleteById(id);
	}
}
