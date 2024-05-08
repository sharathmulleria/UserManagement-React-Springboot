package com.ems.service;
import com.ems.model.Employees;
import com.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Value("${profile.image.storage.path}")
    private String imageStoragePath;


    @Override
    public String saveProfileImage(MultipartFile profileImage, Long id) {
        String fileName = generateUniqueProfileName(id);
        Employees employee = employeeRepository.findById(id).orElseThrow(()->
                new RuntimeException("user id not found"));
        try {
            Path filePath = Paths.get(imageStoragePath, fileName);
            profileImage.transferTo(filePath.toFile());
            String location = imageStoragePath+'/'+fileName;
            employee.setProfilePic(location);
            System.out.println(location);
            employeeRepository.save(employee);
            return  fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save profile image",e);
        }
    }


    public String generateUniqueProfileName(Long id){
        Employees employees = employeeRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("user id not found"));
        return employees.getFirstName()+employees.getLastName();
    }


}
