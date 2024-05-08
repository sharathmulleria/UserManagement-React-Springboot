package com.ems.service;

import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {

    public String saveProfileImage(MultipartFile profileImage, Long id);

    public String generateUniqueProfileName(Long id);

}
