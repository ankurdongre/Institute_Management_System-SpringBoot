package org.example.service.impl;

import org.example.model.Management;
import org.example.model.Teacher;

import java.util.List;


public interface AdminServiceimpl {
     void insertmanagementsingle(Management management);
     void insertmanagementmultiple(List<Management> management);
     Management selectmanagementsingle(int id);
     List<Management> selectmanagementmultiple(List<Integer> ids);
     Management updatemanagementsingle(Management management);
     List<Management> updatemanagementmultiple(List<Management> management);
     Boolean deletemanagementsingle(int id);
     List<Boolean> deletemanagementmultiple(List<Integer> ids);
     List<Management> selectmanagementall();
     Boolean deletemanagementall();
}
