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

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    private CandidateRepository candidateRepository;
    private ManagerRepository managerRepository;
    private StaffRepository staffRepository;

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
}
