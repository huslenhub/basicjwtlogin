package org.example.springjwt.service;

import org.example.springjwt.dto.JoinDTO;
import org.example.springjwt.entity.UserEntity;
import org.example.springjwt.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;//선언
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;//초기화
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDTO joinDTO) {

        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();
        String email = joinDTO.getEmail();
        String phone = joinDTO.getPhone();

        Boolean isExists = userRepository.existsByUsername(username);

        if (isExists) {
            //username  존재함
            return;
        }
        UserEntity data = new UserEntity();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));//암호화 할 필요있음 security config에서 만든 암호화 사용
        data.setEmail(email);
        data.setPhone(phone);
        data.setRole("ROLE_ADMIN");
        userRepository.save(data);
    }
}
