package org.example.service;
import org.example.model.Management;
import org.example.model.Teacher;
import org.example.repo.impl.AdminRepoimpl;
import org.example.repo.impl.ManagementRepoimpl;
import org.example.service.impl.AdminServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements AdminServiceimpl {
    @Autowired
    private AdminRepoimpl repo;
    @Override
    public void insertmanagementsingle(Management management){
        repo.insertmanagementsingle(management);
    }
    @Override
    public void insertmanagementmultiple(List<Management> management){
        for (int i = 0;i<management.size();i++){
            repo.insertmanagementsingle(management.get(i));
        }
    }
    @Override
    public Management selectmanagementsingle(int id){
        return repo.selectmanagementsingle(id);
    }
    @Override
    public List<Management> selectmanagementmultiple(List<Integer> ids){
        List<Management> managementList = new ArrayList<>();
        for (int i = 0;i<ids.size();i++){
            Management m1 =repo.selectmanagementsingle(ids.get(i));
            managementList.add(m1);
        }
        return managementList;
    }
    @Override
    public Management updatemanagementsingle(Management management){
        return repo.updatemanagementsingle(management);
    }
    @Override
    public List<Management> updatemanagementmultiple(List<Management> management){
        List<Management> managementList = new ArrayList<>();
        for (int i = 0;i<management.size();i++){
            Management m1 = updatemanagementsingle(management.get(i));
            managementList.add(m1);
        }
        return managementList;
    }
    @Override
    public Boolean deletemanagementsingle(int id){
        return repo.deletemanagementsingle(id);
    }
    @Override
    public List<Boolean> deletemanagementmultiple(List<Integer> ids){
        List<Boolean> result = new ArrayList<>();
        for (int i = 0;i<ids.size();i++){
         Boolean b1 = deletemanagementsingle(ids.get(i));
         result.add(b1);
        }
        return result;
    }
    @Override
    public List<Management> selectmanagementall(){
        return repo.selectmanagementall();
    }
    @Override
    public Boolean deletemanagementall(){
        return repo.deletemanagementall();
    }
}
