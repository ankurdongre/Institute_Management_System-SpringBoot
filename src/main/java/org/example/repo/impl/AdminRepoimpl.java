package org.example.repo.impl;
import org.example.model.Management;
import java.util.List;

public interface AdminRepoimpl {
     void insertmanagementsingle(Management management);
     Management selectmanagementsingle(int id);
     Management updatemanagementsingle(Management management);
     Boolean deletemanagementsingle(int id);
     List<Management> selectmanagementall();
     Boolean deletemanagementall();

}
