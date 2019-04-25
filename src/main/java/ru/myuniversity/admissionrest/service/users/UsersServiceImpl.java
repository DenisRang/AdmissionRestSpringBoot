package ru.myuniversity.admissionrest.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;
import ru.myuniversity.admissionrest.entity.user.ManagerEntity;
import ru.myuniversity.admissionrest.entity.user.StaffEntity;
import ru.myuniversity.admissionrest.entity.user.UserEntity;
import ru.myuniversity.admissionrest.model.users.User;
import ru.myuniversity.admissionrest.repository.user.CandidateRepository;
import ru.myuniversity.admissionrest.repository.user.ManagerRepository;
import ru.myuniversity.admissionrest.repository.user.StaffRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    private CandidateRepository candidateRepository;
    private ManagerRepository managerRepository;
    private StaffRepository staffRepository;

    private Map<String, Integer> usersByKeys = new HashMap<String, Integer>() {{
        put("5dc757704dac085db29f3e9ea295e8b5a91ac3c5", 1);
        put("f1b5a91d4d6ad523f2610114591c007e75d15084", 2);
        put("7fc7f9e73856bd42a257ce7aac54fc3687f7ad60", 5);
        put("9b94238fa82c65ae69e7c1a4262f153321109338", 8);
    }};

    @Autowired
    public UsersServiceImpl(CandidateRepository candidateRepository, ManagerRepository managerRepository, StaffRepository staffRepository) {
        this.candidateRepository = candidateRepository;
        this.managerRepository = managerRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public List<User> getUsers(String name, User.Role role) {
        switch (role) {
            case CANDIDATE:
                return candidateRepository.findUsersWithName(name)
                        .stream()
                        .map(candidateEntity -> new User(candidateEntity.getId(),
                                candidateEntity.getName(),
                                candidateEntity.getEmail(),
                                User.Role.CANDIDATE))
                        .collect(Collectors.toList());
            case MANAGER:
                return managerRepository.findUsersWithName(name)
                        .stream()
                        .map(candidateEntity -> new User(candidateEntity.getId(),
                                candidateEntity.getName(),
                                candidateEntity.getEmail(),
                                User.Role.MANAGER))
                        .collect(Collectors.toList());
            case UNIVERSITY_STAFF:
                return staffRepository.findUsersWithName(name)
                        .stream()
                        .map(candidateEntity -> new User(candidateEntity.getId(),
                                candidateEntity.getName(),
                                candidateEntity.getEmail(),
                                User.Role.UNIVERSITY_STAFF))
                        .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public void createUser(String name, User.Role role, String email) {
        switch (role) {
            case CANDIDATE:
                candidateRepository.save(new CandidateEntity(name, email));
            case MANAGER:
                managerRepository.save(new ManagerEntity(name, email));
            case UNIVERSITY_STAFF:
                staffRepository.save(new StaffEntity(name, email));
        }
    }

    @Override
    public User getUser(int id) {
        Optional<CandidateEntity> candidateOptional = candidateRepository.findById(id);
        if (candidateOptional.isPresent()) {
            CandidateEntity candidateEntity = candidateOptional.get();
            return new User(candidateEntity.getId(),
                    candidateEntity.getName(),
                    candidateEntity.getEmail(),
                    User.Role.CANDIDATE);
        }
        Optional<ManagerEntity> managerOptional = managerRepository.findById(id);
        if (managerOptional.isPresent()) {
            ManagerEntity managerEntity = managerOptional.get();
            return new User(managerEntity.getId(),
                    managerEntity.getName(),
                    managerEntity.getEmail(),
                    User.Role.CANDIDATE);
        }
        Optional<StaffEntity> staffOptional = staffRepository.findById(id);
        if (staffOptional.isPresent()) {
            StaffEntity staffEntity = staffOptional.get();
            return new User(staffEntity.getId(),
                    staffEntity.getName(),
                    staffEntity.getEmail(),
                    User.Role.CANDIDATE);
        }
        return null;
    }

    @Override
    public User getUser(String token) {
        Integer id = usersByKeys.get(token);

        if (id != null)
            return getUser(id);
        else
            return null;
    }
}
