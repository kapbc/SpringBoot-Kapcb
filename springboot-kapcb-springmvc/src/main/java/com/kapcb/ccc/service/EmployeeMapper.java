package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.Department;
import com.kapcb.ccc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title:EmployeeMapper</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/21 12:21
 */
@Repository
public class EmployeeMapper {

    private static final int INITIAL_CAPACITY = 2;

    private static Integer initId = 1006;

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentMapper departmentMapper;

    static {
        employees = new HashMap<>(INITIAL_CAPACITY);


        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
        employees.put(1002, new Employee(1001, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
        employees.put(1003, new Employee(1001, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
        employees.put(1004, new Employee(1001, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
        employees.put(1005, new Employee(1001, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
    }

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentMapper.getDepartmentsById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
