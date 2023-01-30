package com.example.myuniver.service;

import com.example.myuniver.model.Groups;
import com.example.myuniver.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Groups createGroup(Groups group) {
        return groupRepository.save(group);
    }

    public List<Groups> getAllGroups() {
        return groupRepository.findAll();
    }

    public Groups getGroup(String name) {
        return groupRepository.findById(groupRepository.findIdBygroup_(name)).get();
    }
}
