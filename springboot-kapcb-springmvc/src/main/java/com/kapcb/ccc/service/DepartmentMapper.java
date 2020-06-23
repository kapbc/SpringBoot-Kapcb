package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * <a>Title:DepartmentMapper</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/21 12:20
 */
@Repository
public class DepartmentMapper {

    private static final int INITIAL_CAPACITY = 2;

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>(INITIAL_CAPACITY);

        departments.put(101, new Department(101, "D-AA"));
        departments.put(102, new Department(102, "D-BB"));
        departments.put(103, new Department(103, "D-CC"));
        departments.put(104, new Department(104, "D-DD"));
        departments.put(105, new Department(105, "D-EE"));
    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public Department getDepartmentsById(Integer id) {
        return departments.get(id);
    }

}
